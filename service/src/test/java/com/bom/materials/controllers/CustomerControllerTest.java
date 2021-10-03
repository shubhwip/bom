package com.bom.materials.controllers;

import com.bom.materials.model.Customer;
import com.bom.materials.model.CustomerResponse;
import com.bom.materials.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerService customerService;

    private final static String BOM_CUSTOMER_ROOT_PATH = "/customer";
    private final static String BOM_CUSTOMER_CREATE_PATH = BOM_CUSTOMER_ROOT_PATH + "/create";
    private final static String BOM_CUSTOMER_GET_PATH = BOM_CUSTOMER_ROOT_PATH + "/get/1";
    private final static String VALID_CUSTOMER = "{\"companyName\":\"Zen Technologies\",\"maintainer\":\"Shubham Jain\",\"versionControlUrl\":\"https://github.com/zen\"}";

    @Test
    public void givenCustomerDetails_registerCustomer_returnsSuccess() throws Exception {
        doNothing().when(customerService).save(isA(Customer.class));
        this.mockMvc.perform(post(BOM_CUSTOMER_CREATE_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(VALID_CUSTOMER))
                .andExpect(status().isCreated());
    }

    @Test
    public void givenValidCustomerId_getCustomer_returnsSuccess() throws Exception {
        when(customerService.get(anyInt())).thenReturn(
                new CustomerResponse(1));
        this.mockMvc.perform(get(BOM_CUSTOMER_GET_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"customerId\":1}"));
    }


}
