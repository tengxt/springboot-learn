package com.tengxt.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 一、搭建基本环节
 * 1. 导入数据库文件，创建表
 * 2. 创建javaBean封装数据
 * 3. 整合MyBatis操作数据库
 *     1. 配置数据源信息
 *     2. 使用注解版的MyBatis
 *       1）. `@MapperScan`指定需要扫描的mapper接口所在的包
 * 二、快速体验缓存
 * 	步骤
 * 		1. 开启基于注解的缓存 @EnableCaching
 * 		2. 标注缓存注解即可
 * 			@Cacheable
 * 			@CacheEvict
 * 			@CachePut
 * 	默认使用的是 ConcurrentMapCacheManager == ConcurrentMapCache 将数据保存在 ConcurrentMap<Object, Object>中
 * 	开发中使用缓存中间件： redis、memcached、ehcache
 * 	三、整合redis作为缓存
 * 	Redis 是一个开源的，内存中的数据结构存储系统，它凯瑞用作数据库、缓存和消息中间件
 * 	1. 安装redis， 使用 docker
 * 	2. 引入 redis 的 starter
 * 	3. 配置redis
 * 	4. 测试缓存
 * 	    原理： CacheManager === Cache 缓存组件来实际给缓存中存取数据
 * 	    1).引入Redis 的starter，容器中保存的是 RedisCacheManager
 * 	    2).RedisCacheManager 帮我们创建 RedisCache 来作为缓存组件， RedisCache通过操作 Redis缓存数据
 * 	    3).默认保存数据k-v都是 Object ；利用序列化保存；如何保存为json
 * 	        1、引入Redis 的starter，CacheManager 变为 RedisCacheManager
 * 	        2、默认创建的 RedisCacheManager 操作 redis的时候使用的是 RedisTemplate<Object, Object>
 * 	        3、RedisTemplate<Object, Object> 是默认使用的jdk的序列化机制
 * 	    4).自定义CacheManager
 *
 */
@MapperScan("com.tengxt.cache.mapper")
@SpringBootApplication
@EnableCaching
public class SpringBootCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCacheApplication.class, args);
	}

}
