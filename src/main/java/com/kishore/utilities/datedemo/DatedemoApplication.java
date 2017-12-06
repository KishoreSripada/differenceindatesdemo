package com.kishore.utilities.datedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.kishore.utilities.controller,com.kishore.utilities.service"})
public class DatedemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DatedemoApplication.class, args);
	}
}
