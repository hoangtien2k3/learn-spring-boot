package com.hoangtien2k3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootSchedulingTasksExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSchedulingTasksExampleApplication.class, args);
	}

}
