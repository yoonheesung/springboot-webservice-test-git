package com.skcc.study.jpa.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class StudyJpaSampleAppliacation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(StudyJpaSampleAppliacation.class, args);

	}

}
