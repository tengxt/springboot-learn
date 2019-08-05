package com.tengxt.springbootmybatismultidatasource.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = MyBatisConfigOne.PACKAGE, sqlSessionFactoryRef = "sqlSessionFactoryOne")
public class MyBatisConfigOne {

    // mapper 接口扫描路径
    static final String PACKAGE = "com.tengxt.springbootmybatismultidatasource.mapper";

    // mapper xml文件扫描路径
    static final String  MAPPER_LOCATION = "classpath:mapper/UserOneMapper.xml";


    @Resource(name = "dsOne")
    DataSource dsOne;

    @Bean(name = "sqlSessionFactoryOne")
    SqlSessionFactory sqlSessionFactoryOne(){
        SqlSessionFactory sqlSessionFactory = null;

        try {
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dsOne);
            //如果不使用xml的方式配置mapper，则可以省去下面这行mapper location的配置。
            sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                    .getResources(MyBatisConfigOne.MAPPER_LOCATION));
            sqlSessionFactory = sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sqlSessionFactory;
    }

    @Bean
    SqlSessionTemplate sqlSessionTemplateOne() {
        return new SqlSessionTemplate(sqlSessionFactoryOne());
    }
}
