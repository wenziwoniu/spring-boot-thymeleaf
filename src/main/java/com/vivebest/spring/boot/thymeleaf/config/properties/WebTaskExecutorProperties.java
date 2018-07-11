/*@(#)WebTaskExecutorProperties.java   2017年12月7日 
 * Copy Right 2017 Vivebest Co.Ltd.
 * All Copyright Reserved
 */

package com.vivebest.spring.boot.thymeleaf.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * 线程池配置 Document WebTaskExecutorProperties
 * <p>
 * @version 1.0.0,2017年12月7日
 * @author zwenzheng
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "web.threadpool")
public class WebTaskExecutorProperties {

    private int corePoolSize;

    private int keepAliveSeconds;

    private int maxPoolSize;

    private int queueCapacity;

    private boolean allowCoreThreadTimeout;

    private int awaitTerminationSeconds;

    private boolean waitForTaskToCompleteOnShutdown;

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getKeepAliveSeconds() {
        return keepAliveSeconds;
    }

    public void setKeepAliveSeconds(int keepAliveSeconds) {
        this.keepAliveSeconds = keepAliveSeconds;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public boolean getAllowCoreThreadTimeout() {
        return allowCoreThreadTimeout;
    }

    public void setAllowCoreThreadTimeout(boolean allowCoreThreadTimeout) {
        this.allowCoreThreadTimeout = allowCoreThreadTimeout;
    }

    public int getAwaitTerminationSeconds() {
        return awaitTerminationSeconds;
    }

    public void setAwaitTerminationSeconds(int awaitTerminationSeconds) {
        this.awaitTerminationSeconds = awaitTerminationSeconds;
    }

    public boolean getWaitForTaskToCompleteOnShutdown() {
        return waitForTaskToCompleteOnShutdown;
    }

    public void setWaitForTaskToCompleteOnShutdown(boolean waitForTaskToCompleteOnShutdown) {
        this.waitForTaskToCompleteOnShutdown = waitForTaskToCompleteOnShutdown;
    }

    @Override
    public String toString() {
        return "WebTaskExecutorPropertiesConfiguration [corePoolSize=" + corePoolSize + ", keepAliveSeconds=" + keepAliveSeconds
            + ", maxPoolSize=" + maxPoolSize + ", queueCapacity=" + queueCapacity + ", allowCoreThreadTimeout=" + allowCoreThreadTimeout
            + ", awaitTerminationSeconds=" + awaitTerminationSeconds + ", waitForTaskToCompleteOnShutdown=" + waitForTaskToCompleteOnShutdown
            + "]";
    }
}
