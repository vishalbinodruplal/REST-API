package com.qadashboard.qadashboardprojectdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing	// This annotation is used for Enabling the Jpa Auditing feature
public class QaDashboardProjectDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(QaDashboardProjectDetailsApplication.class, args);
	}

}
