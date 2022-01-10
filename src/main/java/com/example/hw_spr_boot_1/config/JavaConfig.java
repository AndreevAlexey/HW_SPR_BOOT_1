package com.example.hw_spr_boot_1.config;

import com.example.hw_spr_boot_1.profile.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    @ConditionalOnProperty(prefix = "netology.profile", name = "dev", havingValue = "true", matchIfMissing = true)
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(prefix = "netology.profile", name = "dev", havingValue = "false", matchIfMissing = false)
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
