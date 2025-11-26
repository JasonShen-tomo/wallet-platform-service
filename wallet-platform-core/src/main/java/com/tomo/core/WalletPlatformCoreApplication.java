package com.tomo.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Wallet Platform Core Application
 * Main entry point for the Spring Boot application
 */
@SpringBootApplication
@EnableFeignClients
@EnableRetry
@EnableScheduling
@MapperScan("com.tomo.core.mapper")
public class WalletPlatformCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletPlatformCoreApplication.class, args);
	}

}
