package com.vivebest.spring.boot.thymeleaf.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.vivebest.spring.boot.thymeleaf.config.properties.DruidDataSourceProperties;

/**
 * Druid的DataResource配置类 凡是被Spring管理的类，实现接口 EnvironmentAware 重写方法 setEnvironment 可以在工程启动时，
 * 获取到系统环境变量和application配置文件中的变量。 还有一种方式是采用注解的方式获取 @value("${变量的key值}") 获取application配置文件中的变量。 这里采用第一种要方便些
 * <p>
 * 
 * @version 1.0.0,2017年4月25日
 * @author zhengzhangwen
 * @since 1.0.0
 */
@Configuration
@EnableConfigurationProperties(DruidDataSourceProperties.class)
// 主动加载DruidPropertiesConfiguration配置
public class DruidDataSourceConfiguration {

    private static Logger logger = LoggerFactory.getLogger(DruidDataSourceConfiguration.class);

    @Autowired
    private DruidDataSourceProperties druidDataSourceProperties;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        logger.info("DataSource Configruing...");
        logger.info("druidPropertiesConfiguration :" + druidDataSourceProperties);

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(druidDataSourceProperties.getUrl());
        druidDataSource.setUsername(druidDataSourceProperties.getUsername());
        druidDataSource.setPassword(druidDataSourceProperties.getPassword());
        if (druidDataSourceProperties.getInitialSize() > 0) {
            druidDataSource.setInitialSize(druidDataSourceProperties.getInitialSize());
        }
        if (druidDataSourceProperties.getMinIdle() > 0) {
            druidDataSource.setMinIdle(druidDataSourceProperties.getMinIdle());
        }
        if (druidDataSourceProperties.getMaxActive() > 0) {
            druidDataSource.setMaxActive(druidDataSourceProperties.getMaxActive());
        }
        druidDataSource.setTestOnBorrow(druidDataSourceProperties.isTestOnBorrow());
        try {
            if (null != druidDataSource) {
                druidDataSource.setFilters("wall,stat");
                druidDataSource.setUseGlobalDataSourceStat(true);
                druidDataSource.init();
            }
        } catch (Exception e) {
            logger.error("load DruidDataSource error, dbProperties is :{}" + e);
            throw new RuntimeException("load DruidDataSource error, dbProperties is :", e);
        }
        return druidDataSource;
    }
}
