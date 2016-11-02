package com.bbva.controllerservice.test;

import com.bbva.controllerservice.repo.CustomerRepository;
import com.bbva.controllerservice.test.helper.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static com.bbva.controllerservice.test.helper.TestHelper.TEST_USERID;
import static com.bbva.controllerservice.test.helper.TestHelper.UNKNOWN_USERID;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by icanon on 26/10/16.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestHelper.class})
@SpringBootTest
public class CustomerRepositoryTest {


    @Autowired
    CustomerRepository customerRepository;


    @Test
    public void test_that_customer_findname_works_as_expected() throws Exception {
        assertThat(customerRepository.findNameByUserId(UNKNOWN_USERID))
                .isNull();
        assertThat(customerRepository.findNameByUserId(TEST_USERID))
                .isNotNull()
                .isNotEmpty();
    }

    @Test
    public void test_that_customer_findphone_works_as_expected() throws Exception {
        assertThat(customerRepository.findPhoneByUserId(UNKNOWN_USERID))
                .isNull();
        assertThat(customerRepository.findPhoneByUserId(TEST_USERID))
                .isNotNull()
                .isNotEmpty();
    }

    @Test
    public void test_that_customer_findemail_works_as_expected() throws Exception {
        assertThat(customerRepository.findEmailByUserId(UNKNOWN_USERID))
                .isNull();
        assertThat(customerRepository.findEmailByUserId(TEST_USERID))
                .isNotNull()
                .isNotEmpty();
    }
}
