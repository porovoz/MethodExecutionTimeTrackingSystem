package com.bestapp.MethodExecutionTimeTrackingSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MethodExecutionTimeTrackingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MethodExecutionTimeTrackingSystemApplication.class, args);
	}

}
