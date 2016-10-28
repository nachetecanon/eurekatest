package com.bbva.microservicio.test.helper;

import com.bbva.microservicio.controller.EmployeeRestController;
import com.bbva.microservicio.repo.EmployeesRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by icanon on 26/10/16.
 */
@SpringBootApplication(scanBasePackageClasses = {EmployeesRepository.class, EmployeeRestController.class})
public class TestHelper {
}
