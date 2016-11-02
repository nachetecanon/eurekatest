package com.bbva.microservicio.test;

import com.bbva.employee.repo.EmployeesRepository;
import com.bbva.microservicio.test.helper.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by icanon on 26/10/16.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestHelper.class})
@SpringBootTest
public class EmployeesRepositoryTest {

    @Autowired
    EmployeesRepository employeesRepository;


    @Test
    public void test_that_employees_findname_works_as_expected() throws Exception {
        assertThat(employeesRepository.findNameByUserId("unknown"))
                .isNull();
        assertThat(employeesRepository.findNameByUserId("icanon"))
                .isNotNull()
                .isNotEmpty();
    }

    @Test
    public void test_that_employees_findphone_works_as_expected() throws Exception {
        assertThat(employeesRepository.findPhoneByUserId("unknown"))
                .isNull();
        assertThat(employeesRepository.findPhoneByUserId("icanon"))
                .isNotNull()
                .isNotEmpty();
    }

    @Test
    public void test_that_employees_findemail_works_as_expected() throws Exception {
        assertThat(employeesRepository.findEmailByUserId("unknown"))
                .isNull();
        assertThat(employeesRepository.findEmailByUserId("icanon"))
                .isNotNull()
                .isNotEmpty();
    }
}
