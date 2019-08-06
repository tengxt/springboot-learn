package com.tengxt.springbootaoplog.config;

import com.tengxt.springbootaoplog.entity.SysLog;
import com.tengxt.springbootaoplog.service.SysLogService;
import com.tengxt.springbootaoplog.util.HttpContextUtils;
import com.tengxt.springbootaoplog.util.IPUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LogAspect {

    @Autowired
    private SysLogService sysLogService;

    @Pointcut("@annotation(com.tengxt.springbootaoplog.config.Log)")
    public void pointcut(){}


    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point){
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try {
            // 执行方法
            result = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        // 执行时长（毫秒）
        long endTime = System.currentTimeMillis();
        // 保存日志
        saveLog(point, (endTime - beginTime));
        return result;
    }

    private int saveLog(ProceedingJoinPoint joinPoint, Long time){
        int res = 0;
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLog sysLog = new SysLog();
        Log logAnnotation = method.getAnnotation(Log.class);
        if(null != logAnnotation){
            // 注解上的描述
            sysLog.setOperation(logAnnotation.value());
        }
        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className+"."+methodName+"()");
        // 请求的方法参数值
        Object[] args = joinPoint.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer nameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = nameDiscoverer.getParameterNames(method);
        if(null != args && null != parameterNames){
            String params = "";
            for(int i = 0; i < args.length; i++){
                params += " " + parameterNames[i] + " : " + args[i];
            }
            sysLog.setParams(params);
        }
        // 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 设置IP地址
        sysLog.setIp(IPUtils.getIpAddr(request));
        // 模拟一个用户名
        sysLog.setUsername("tengxt");
        sysLog.setTime(time.toString());
        sysLog.setCreateTime(new Date());
        // 保存系统日志
        try {
            res = sysLogService.saveSysLog(sysLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res > 0 ? res : 0;
    }
}
