package com.Practicas._SpringBoot_BS5.Logging;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
		log.trace("Esto es un log.trace");
		log.debug("Esto es un log.debug");
		log.info("Esto es un log.info");
		log.warn("Esto es un log.warn");
		log.error("Esto es un log.error");
	}


}
