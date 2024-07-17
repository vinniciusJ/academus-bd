package com.unioeste.academus;

import com.unioeste.academus.controllers.AppController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AcademusApplication implements CommandLineRunner {

	@Autowired
	private AppController appController;

	public static void main(String[] args) {
		SpringApplication.run(AcademusApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		appController.startApp();
	}
}
