package com.bnpl.fantasy.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingConfig {

	@Bean
	public Logger logger(InjectionPoint injectionPoint) {
		Class<?> targetClass = injectionPoint.getMember().getDeclaringClass();
		return LoggerFactory.getLogger(targetClass);
	}
}
