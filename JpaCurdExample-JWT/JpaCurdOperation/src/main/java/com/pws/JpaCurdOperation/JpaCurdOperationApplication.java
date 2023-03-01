package com.pws.JpaCurdOperation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ComponentScan(basePackages = {"com.pws.JpaCurdOperation.*"})
@EnableJpaAuditing
public class JpaCurdOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaCurdOperationApplication.class, args);
	}

}
