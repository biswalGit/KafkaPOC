package com.pit.auditms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class AuditmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditmsApplication.class, args);
	}

}
