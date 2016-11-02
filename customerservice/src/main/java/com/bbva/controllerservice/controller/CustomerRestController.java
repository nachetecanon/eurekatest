package com.bbva.controllerservice.controller;

import com.bbva.controllerservice.repo.CustomerRepository;
import com.bbva.microservice2.api.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


/**
 * Created by icanon on 25/10/16.
 */
@RestController
public class CustomerRestController implements CustomerService {
    @Autowired
    private CustomerRepository customersRepository;

    @Override
    public ResponseEntity<String> retrieveNameByUserId(@PathVariable(USER_ID) String userId) {
        return Optional.ofNullable(customersRepository.findNameByUserId(userId)).
                map(ResponseEntity::ok).
                orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("user '" + userId + "' not found"));
    }

    @Override
    public ResponseEntity<String> retrieveEmailByUserId(@PathVariable(USER_ID) String userId) {
        return Optional.ofNullable(customersRepository.findEmailByUserId(userId)).
                map(ResponseEntity::ok).
                orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("user '" + userId + "' not found"));
    }

    @Override
    public ResponseEntity<String> retrievePhoneByUserId(@PathVariable(USER_ID) String userId) {
        return Optional.ofNullable(customersRepository.findPhoneByUserId(userId)).
                map(ResponseEntity::ok).
                orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("user '" + userId + "' not found"));
    }

}
