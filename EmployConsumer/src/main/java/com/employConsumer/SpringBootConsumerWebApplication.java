package com.employConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootConsumerWebApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootConsumerWebApplication.class, args);
		ClientController clientController = context.getBean(ClientController.class);
		clientController.printEmploy();

		ClientControllerRibbon clientControllerRibbon = context.getBean(ClientControllerRibbon.class);
		clientControllerRibbon.printEmploy();

		ClientControllerZuul clientControllerZuul = context.getBean(ClientControllerZuul.class);
		clientControllerZuul.printEmploy();
	}

	@Bean
	public ClientController clientController() {
		return new ClientController();
	}

	@Bean
	public ClientControllerRibbon clientControllerRibbon() {
		return new ClientControllerRibbon();
	}

	@Bean
	public ClientControllerZuul clientControllerZuul() {
		return new ClientControllerZuul();
	}
}