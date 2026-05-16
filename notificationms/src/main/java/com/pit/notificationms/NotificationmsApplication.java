package com.pit.notificationms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class NotificationmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationmsApplication.class, args);
	}

}
