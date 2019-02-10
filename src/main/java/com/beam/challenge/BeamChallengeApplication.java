package com.beam.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BeamChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeamChallengeApplication.class, args);
	}

}

