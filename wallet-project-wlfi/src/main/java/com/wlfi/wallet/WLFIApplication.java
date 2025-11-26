package com.wlfi.wallet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * WLFI Application
 * Main entry point for WLFI project
 * 
 * Component scan includes:
 * - com.tomo.core: Core platform services
 * - com.wlfi.wallet: WLFI project services
 */
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.tomo.core", "com.wlfi.wallet"})
@EnableRetry
@EnableScheduling
@MapperScan({"com.tomo.core.mapper", "com.wlfi.wallet.mapper"})
@ComponentScan(basePackages = {"com.tomo.core", "com.wlfi.wallet"})
public class WLFIApplication {

    public static void main(String[] args) {
        SpringApplication.run(WLFIApplication.class, args);
    }
}
