package com.Practicas._SpringBoot_Properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties
@Getter
@Setter
public class AllProperties {
    @Value("${VAR1: var1 no tiene valor}")
    private String var1;

    @Value("${VAR2: var2 no tiene valor}")
    private String var2;

    @Value("${VAR_SISTEMA: valor defecto}")
    private String var3;
}
