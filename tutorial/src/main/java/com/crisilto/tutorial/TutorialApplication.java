package com.crisilto.tutorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TutorialApplication {

	private static Logger logger = LoggerFactory.getLogger(TutorialApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TutorialApplication.class, args);

		/*
		* logger.errer -> Mensaje que alarma para las aplicaciones que tengamos en producción.
		* logger.warn -> Algo va mal pero la aplicación todavía funciona.
		* logger.info -> Todo está bien pero hay algo que deberíamos saber.
		* logger.debug -> Mensajes para los desarrolladores, por probar, que no deberían llegar a producción.
		*/
		logger.error("An error occurred in the application");
        logger.warn("A warning occurred in the application");
        logger.info("An informational message");
        logger.debug("A debug message");
	}

}
