package com.bbva.microservice2.test;

import com.bbva.microservice2.test.helper.TestHelper;
import com.bbva.microservicio2.api.CustomerService;
import com.bbva.microservicio2.repo.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static com.bbva.microservice2.test.helper.TestHelper.TEST_USERID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by icanon on 26/10/16.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestHelper.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestContrTest {

    private MockMvc mockMvc;

    private final MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private CustomerRepository customerRepository;

    @Before
    public void setup() {
        mockMvc = webAppContextSetup(wac).build();
    }

    private void call_rest_method_and_expect_result(final String expectedResult, final String uriMethod, final String userId) throws Exception {
        MvcResult returnedName = mockMvc.perform(get(uriMethod + "/" + userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andReturn();
        assertThat(returnedName.getResponse().getContentAsString())
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(expectedResult);
    }

    private void call_rest_method_with_not_foundable_userid_and_expect_not_found_result(final String uri) throws Exception {
        mockMvc.perform(get(uri + "/notFoundable"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void test_user_name_found_useCase() throws Exception {
        final String expectedName = customerRepository.findNameByUserId(TEST_USERID);
        call_rest_method_and_expect_result(expectedName, CustomerService.NAME_URI_BASE, TEST_USERID);
    }

    @Test
    public void test_user_name_notFound_useCase() throws Exception {
        call_rest_method_with_not_foundable_userid_and_expect_not_found_result(CustomerService.NAME_URI_BASE);
    }

    @Test
    public void test_user_email_found_useCase() throws Exception {
        final String expectedEmail = customerRepository.findEmailByUserId(TEST_USERID);
        call_rest_method_and_expect_result(expectedEmail, CustomerService.EMAIL_URI_BASE, TEST_USERID);
    }

    @Test
    public void test_user_email_notFound_useCase() throws Exception {
        call_rest_method_with_not_foundable_userid_and_expect_not_found_result(CustomerService.EMAIL_URI_BASE);
    }

    @Test
    public void test_user_phone_found_useCase() throws Exception {
        final String expectedPhone = customerRepository.findPhoneByUserId(TEST_USERID);
        call_rest_method_and_expect_result(expectedPhone, CustomerService.PHONE_URI_BASE, TEST_USERID);
    }

    @Test
    public void test_user_phone_notFound_useCase() throws Exception {
        call_rest_method_with_not_foundable_userid_and_expect_not_found_result(CustomerService.PHONE_URI_BASE);
    }


}
