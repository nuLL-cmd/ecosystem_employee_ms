package com.automato_dev.hrEmploye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HrEmployeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrEmployeApplication.class, args);
	}

}
