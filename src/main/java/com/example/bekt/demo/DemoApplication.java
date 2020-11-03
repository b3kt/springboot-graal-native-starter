package com.example.bekt.demo;

import com.example.bekt.demo.service.CustomerHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

@SpringBootApplication(proxyBeanMethods = false)
@EnableR2dbcRepositories
@EnableAutoConfiguration
public class DemoApplication {

	private Logger log = LoggerFactory.getLogger(DemoApplication.class);
	private static ApplicationContext applicationContext;

	public DemoApplication() {
		log.info("Constructor Called");
	}

	public void init() {
		log.info("Init Called");
	}

	// @Bean
	// public CommandLineRunner demo(CustomerHandler handler) {
	// 	return (args) -> {
	// 		System.out.println("CommandLineRunner Called");
	// 		log.info("CommandLine Runner Called");
	// 		log.info("Application Context: "+ applicationContext.getApplicationName());
	// 	};
	// }

	public static void main(String[] args) {
		// applicationContext = new AnnotationConfigApplicationContext(DemoApplication.class);
		// applicationContext = new SpringApplicationBuilder(DemoApplication.class)
		// 	// .initializers(new AppContextInitializer())
		// 	// .properties("application.properties")
		// 	.run(args);

		applicationContext = SpringApplication.run(DemoApplication.class, args);
	}

}