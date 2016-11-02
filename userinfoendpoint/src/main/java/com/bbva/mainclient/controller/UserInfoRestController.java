package com.bbva.mainclient.controller;

import com.bbva.mainclient.remoteapi.CustomerRemoteApi;
import com.bbva.mainclient.remoteapi.EmployeeRemoteApi;
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
public class UserInfoRestController {

    @Autowired
    private CustomerRemoteApi customerRemoteApi;
    @Autowired
    private EmployeeRemoteApi employeeRemoteApi;

    @RequestMapping(value = "/employee/name/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> getEmployeeNameByUserId(@PathVariable("userId") final String userId) {
        return employeeRemoteApi.retrieveNameByUserId(userId);
    }

    @RequestMapping(value = "/customer/phone/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> getCustomerPhoneByUserId(@PathVariable("userId") final String userId) {
        return customerRemoteApi.retrievePhoneByUserId(userId);
    }


}
