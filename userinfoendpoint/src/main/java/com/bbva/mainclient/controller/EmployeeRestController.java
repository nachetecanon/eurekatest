package com.bbva.mainclient.controller;

import com.bbva.microservicio.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by icanon on 28/10/16.
 */
@RestController
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee/name/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> getEmployeeNameByUserId(@PathVariable("userId") final String userId) {
        return employeeService.retrieveNameByUserId(userId);
    }


}
