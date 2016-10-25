package com.bbva.eurekaclient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by icanon on 25/10/16.
 */
@RestController
public class RestContr {


    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

}
