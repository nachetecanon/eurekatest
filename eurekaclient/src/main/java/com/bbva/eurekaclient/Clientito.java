package com.bbva.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by icanon on 25/10/16.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Clientito {

    public static void main(String[] args) {
        SpringApplication.run(Clientito.class, args);
    }
}
