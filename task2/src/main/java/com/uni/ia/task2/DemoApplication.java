package com.uni.ia.task2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("THIS SHould be visible at the end of the run commant");
		System.out.println("run mvn package, mvn exec:java");
	}

}
