package com.unioeste.academus;

import com.unioeste.academus.controllers.CourseController;
import com.unioeste.academus.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Console;
import java.util.List;

@SpringBootApplication
public class AcademusApplication implements CommandLineRunner {
	@Autowired
	private CourseController controller;

	public static void main(String[] args) {
		SpringApplication.run(AcademusApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		controller.findAll();
	}
}
