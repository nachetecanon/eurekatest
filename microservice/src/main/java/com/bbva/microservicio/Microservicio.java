package com.bbva.microservicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by icanon on 25/10/16.
 */
@SpringBootApplication
@EnableEurekaClient
public class Microservicio {

    public static void main(String[] args) {
        SpringApplication.run(Microservicio.class, args);
    }
}
