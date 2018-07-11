/*@(#)MyBatisProperties.java   2017年12月7日 
 * Copy Right 2017 Vivebest Co.Ltd.
 * All Copyright Reserved
 */

package com.vivebest.spring.boot.thymeleaf.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * MyBatis属性配置加载 Document MyBatisProperties
 * <p>
 * 
 * @version 1.0.0,2017年12月7日
 * @author zwenzheng
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "mybatis")
public class MyBatisProperties {

    private String typeAliasesPackage;

    private String mapperLocations;

    private String configLocation;

    public String getTypeAliasesPackage() {
        return typeAliasesPackage;
    }

    public void setTypeAliasesPackage(String typeAliasesPackage) {
        this.typeAliasesPackage = typeAliasesPackage;
    }

    public String getMapperLocations() {
        return mapperLocations;
    }

    public void setMapperLocations(String mapperLocations) {
        this.mapperLocations = mapperLocations;
    }

    public String getConfigLocation() {
        return configLocation;
    }

    public void setConfigLocation(String configLocation) {
        this.configLocation = configLocation;
    }
}
