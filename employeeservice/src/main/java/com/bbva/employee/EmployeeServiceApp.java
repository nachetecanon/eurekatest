package com.bbva.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by icanon on 25/10/16.
 */
@SpringBootApplication
@EnableEurekaClient
public class EmployeeServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApp.class, args);
    }
}
