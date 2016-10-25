package com.bbva.eurekaserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by icanon on 25/10/16.
 */
@RestController
public class MiController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/miraaver")
    private ResponseEntity<List<String>> givetome() {
        return ResponseEntity.ok(discoveryClient.getServices());
    }
}
