package com.vivebest.spring.boot.thymeleaf.config;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.vivebest.spring.boot.thymeleaf.config.properties.WebTaskExecutorProperties;

/**
 * 公共配置类，所有模块共用 AppConfiguration
 * <p>
 * 
 * @version 1.0.0,2017年5月9日
 * @author zhengzhangwen
 * @since 1.0.0
 */
@Configuration
public class ApplicationCommonConfiguration {

    /**
     * @Title: messageSource 
     * @Description: 国际资源化配置 
     * @param @return    设定文件 
     * @return MessageSource    返回类型 
     * @throws
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
        bundleMessageSource.setBasename("classpath:messages");
        bundleMessageSource.setDefaultEncoding("UTF-8");
        bundleMessageSource.setCacheSeconds(3600);
        return bundleMessageSource;
    }

    /**
     * TODO http服务接入线程池配置
     * <p>
     * @version 1.0.0,2017年5月9日
     * @author zhengzhangwen
     * @since 1.0.0
     */
    @Configuration
    @EnableConfigurationProperties(WebTaskExecutorProperties.class)
    public class WebTaskExecutorConfiguration {

        @Autowired
        private WebTaskExecutorProperties webTaskExecutorProperties;

        @Bean(name = "webTaskExecutor")
        public ThreadPoolTaskExecutor webTaskExecutor() {
            ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
            taskExecutor.setCorePoolSize(webTaskExecutorProperties.getCorePoolSize());
            taskExecutor.setKeepAliveSeconds(webTaskExecutorProperties.getKeepAliveSeconds());
            taskExecutor.setMaxPoolSize(webTaskExecutorProperties.getMaxPoolSize());
            taskExecutor.setQueueCapacity(webTaskExecutorProperties.getQueueCapacity());
            taskExecutor.setAllowCoreThreadTimeOut(webTaskExecutorProperties.getAllowCoreThreadTimeout());
            taskExecutor.setAwaitTerminationSeconds(webTaskExecutorProperties.getAwaitTerminationSeconds());
            taskExecutor.setWaitForTasksToCompleteOnShutdown(webTaskExecutorProperties.getWaitForTaskToCompleteOnShutdown());
            taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
            return taskExecutor;
        }
    }
}
