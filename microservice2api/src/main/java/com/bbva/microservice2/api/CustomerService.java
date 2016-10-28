package com.bbva.microservice2.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by icanon on 27/10/16.
 */
@FeignClient("microservice2test")
public interface CustomerService {
    String NAME_URI_BASE = "/customer/name";
    String EMAIL_URI_BASE = "/customer/email";
    String PHONE_URI_BASE = "/customer/phone";
    String USER_ID = "userId";
    String NAME_URI = NAME_URI_BASE + "/{" + USER_ID + "}";
    String EMAIL_URI = EMAIL_URI_BASE + "/{" + USER_ID + "}";
    String PHONE_URI = PHONE_URI_BASE + "/{" + USER_ID + "}";

    @RequestMapping(value = NAME_URI, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<String> retrieveNameByUserId(@PathVariable(USER_ID) String userId);

    @RequestMapping(value = EMAIL_URI, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<String> retrieveEmailByUserId(@PathVariable(USER_ID) String userId);

    @RequestMapping(value = PHONE_URI, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<String> retrievePhoneByUserId(@PathVariable(USER_ID) String userId);
}
