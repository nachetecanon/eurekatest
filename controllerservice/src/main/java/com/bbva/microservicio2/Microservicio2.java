package com.bbva.microservicio2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by icanon on 27/10/16.
 */
@SpringBootApplication
@EnableEurekaClient
public class Microservicio2 {
    public static void main(String[] args) {
        SpringApplication.run(Microservicio2.class, args);
    }
}
