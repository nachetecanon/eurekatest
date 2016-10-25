package com.bbva.eurekaserver;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by icanon on 25/10/16.
 */
@RestController
public class MiController {


    @RequestMapping("/miraaver/")
    private ResponseEntity<List<String>> givetome() {
        return ResponseEntity.ok(Arrays.asList("Sttring1", "string2"));
    }
}
