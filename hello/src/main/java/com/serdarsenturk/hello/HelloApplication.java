package com.serdarsenturk.hello;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloApplication {

	public static void main(String[] args){
		SpringApplication.run(HelloApplication.class, args);
	}

	private static final Logger logger = LoggerFactory.getLogger(HelloApplication.class);

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name){
		logger.trace("This is a TRACE message.");
		logger.debug("This is a DEBUG message.");
		logger.info("This is an INFO message.");
		logger.warn("This is a WARN message.");
		logger.error("You guessed it, an ERROR message.");
		logger.info("User Landed on MainPage");
		return String.format("Hello %s!", name);
	}

}