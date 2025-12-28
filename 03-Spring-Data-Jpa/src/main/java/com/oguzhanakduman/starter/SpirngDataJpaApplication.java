package com.oguzhanakduman.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.oguzhanakduman.cofiguration.GlobalProperties;

@SpringBootApplication
@EntityScan(basePackages = {"com.oguzhanakduman"})
@ComponentScan(basePackages = {"com.oguzhanakduman"})
@EnableJpaRepositories(basePackages = {"com.oguzhanakduman"})
@PropertySource(value = "classpath:app.properties")
@EnableConfigurationProperties(value = GlobalProperties.class)
public class SpirngDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpirngDataJpaApplication.class, args);
	}

}
