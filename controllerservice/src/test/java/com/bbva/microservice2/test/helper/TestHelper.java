package com.bbva.microservice2.test.helper;

import com.bbva.microservicio2.controller.CustomerRestController;
import com.bbva.microservicio2.repo.CustomerRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by icanon on 26/10/16.
 */
@SpringBootApplication(scanBasePackageClasses = {CustomerRepository.class, CustomerRestController.class})
public class TestHelper {
    public static final String UNKNOWN_USERID = "unknown";
    public static final String TEST_USERID = "menganito";
}
