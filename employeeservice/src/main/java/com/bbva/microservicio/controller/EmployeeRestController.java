package com.bbva.microservicio.controller;

import com.bbva.microservicio.api.EmployeeService;
import com.bbva.microservicio.repo.EmployeesRepository;
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
public class EmployeeRestController implements EmployeeService {

    @Autowired
    private EmployeesRepository employeesRepository;

    @Override
    public ResponseEntity<String> retrieveNameByUserId(@PathVariable(USER_ID) String userId) {
        return Optional.ofNullable(employeesRepository.findNameByUserId(userId)).
                map(name -> ResponseEntity.ok(name)).
                orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("user '" + userId + "' not found"));
    }

    @Override
    public ResponseEntity<String> retrieveEmailByUserId(@PathVariable(USER_ID) String userId) {
        return Optional.ofNullable(employeesRepository.findEmailByUserId(userId)).
                map(name -> ResponseEntity.ok(name)).
                orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("user '" + userId + "' not found"));
    }

    @Override
    public ResponseEntity<String> retrievePhoneByUserId(@PathVariable(USER_ID) String userId) {
        return Optional.ofNullable(employeesRepository.findPhoneByUserId(userId)).
                map(name -> ResponseEntity.ok(name)).
                orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("user '" + userId + "' not found"));
    }

}
