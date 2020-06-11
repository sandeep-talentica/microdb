package com.sandeep.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories("com.sandeep.ws.repo") 
@EntityScan("com.sandeep.ws.model")
@SpringBootApplication
@EnableDiscoveryClient
public class MicrodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrodbApplication.class, args);
	}

}
