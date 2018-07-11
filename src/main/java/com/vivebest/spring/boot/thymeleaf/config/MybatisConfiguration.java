
package com.vivebest.spring.boot.thymeleaf.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.vivebest.spring.boot.thymeleaf.config.properties.MyBatisProperties;

/**
 * MyBatis属性配置 Document MybatisConfiguration
 * <p>
 * 
 * @version 1.0.0,2017年4月25日
 * @author zhengzhangwen
 * @since 1.0.0
 */
@Configuration
@ConditionalOnClass({ EnableTransactionManagement.class})
@EnableConfigurationProperties(MyBatisProperties.class)
@AutoConfigureAfter({ DruidDataSourceConfiguration.class })
@MapperScan(basePackages = { "com.vivebest.spring.boot.thymeleaf.dao" })
public class MybatisConfiguration {

    private static Logger logger = LoggerFactory.getLogger(MybatisConfiguration.class);

    @Autowired
    private MyBatisProperties myBatisProperties;

    @Autowired
    private DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() {
        try {
            SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
            sessionFactory.setDataSource(dataSource);
            sessionFactory.setTypeAliasesPackage(myBatisProperties.getTypeAliasesPackage());
            sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(myBatisProperties.getMapperLocations()));
            sessionFactory.setConfigLocation(new DefaultResourceLoader().getResource(myBatisProperties.getConfigLocation()));

            return sessionFactory.getObject();
        } catch (Exception e) {
            logger.warn("Could not confiure mybatis session factory");
            return null;
        }
    }

    @Bean
    @ConditionalOnMissingBean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
