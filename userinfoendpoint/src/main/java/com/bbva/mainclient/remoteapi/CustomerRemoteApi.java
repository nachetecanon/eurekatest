package com.bbva.mainclient.remoteapi;

import com.bbva.microservice2.api.CustomerService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by icanon on 2/11/16.
 */
@FeignClient("customerservice")
public interface CustomerRemoteApi extends CustomerService {
}
