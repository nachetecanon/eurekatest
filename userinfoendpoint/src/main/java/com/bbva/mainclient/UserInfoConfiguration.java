package com.bbva.mainclient;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * Created by icanon on 28/10/16.
 */
@Configuration
@EnableEurekaClient
@EnableFeignClients
public class UserInfoConfiguration {

}
