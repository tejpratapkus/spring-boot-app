package com.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

import com.event.sevice.EventProcessTaskRunner;

@SpringBootApplication
@EnableTask
public class EventTaskApplication {

	@Bean
	EventProcessTaskRunner getEventProcessTaskRunner() {
		return new EventProcessTaskRunner();
	}

	public static void main(String[] args) {
		SpringApplication.run(EventTaskApplication.class, args);
	}

}
