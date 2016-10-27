package com.bbva.microservicio2.controller;

import com.bbva.microservicio2.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by icanon on 25/10/16.
 */
@RestController
public class RestContr {
    public static final String NAME_URI_BASE = "/customer/name";
    public static final String EMAIL_URI_BASE = "/customer/email";
    public static final String PHONE_URI_BASE = "/customer/phone";
    public static final String USER_ID = "userId";
    private static final String NAME_URI = NAME_URI_BASE + "/{" + USER_ID + "}";
    private static final String EMAIL_URI = EMAIL_URI_BASE + "/{" + USER_ID + "}";
    private static final String PHONE_URI = PHONE_URI_BASE + "/{" + USER_ID + "}";
    @Autowired
    private CustomerRepository customersRepository;

    @RequestMapping(value = NAME_URI, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> saymyname(@PathVariable(USER_ID) String userId) {
        return Optional.ofNullable(customersRepository.findNameByUserId(userId)).
                map(name -> ResponseEntity.ok(name)).
                orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("user '" + userId + "' not found"));
    }

    @RequestMapping(value = EMAIL_URI, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> getmyemail(@PathVariable(USER_ID) String userId) {
        return Optional.ofNullable(customersRepository.findEmailByUserId(userId)).
                map(name -> ResponseEntity.ok(name)).
                orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("user '" + userId + "' not found"));
    }

    @RequestMapping(value = PHONE_URI, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> hello(@PathVariable(USER_ID) String userId) {
        return Optional.ofNullable(customersRepository.findPhoneByUserId(userId)).
                map(name -> ResponseEntity.ok(name)).
                orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("user '" + userId + "' not found"));
    }

}
