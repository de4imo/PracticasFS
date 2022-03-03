package com.events._SpringBoot_SystemEvents;

import com.events._SpringBoot_SystemEvents.services.DemoPublisherService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@ComponentScan("com.events._SpringBoot_SystemEvents")
@EnableAsync
public class EventsApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				EventsApplication.class);
		DemoPublisherService demoPublisherService = applicationContext
				.getBean(DemoPublisherService.class);

		demoPublisherService.doSomething();

		applicationContext.close();
	}

}