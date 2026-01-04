package com.oguzhanakduman.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.oguzhanakduman")
@EntityScan(basePackages = "com.oguzhanakduman")
@EnableJpaRepositories(basePackages = "com.oguzhanakduman")
@SpringBootApplication
public class PageableApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(PageableApplicationStarter.class, args);
	}

}
