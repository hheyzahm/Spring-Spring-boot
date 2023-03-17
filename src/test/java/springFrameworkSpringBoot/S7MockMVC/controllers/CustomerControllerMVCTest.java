package springFrameworkSpringBoot.S7MockMVC.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import springFrameworkSpringBoot.S7MockMVC.Model.CustomerMockMVC;
import springFrameworkSpringBoot.S7MockMVC.services.CustomerServiceMockMVC;
import springFrameworkSpringBoot.S7MockMVC.services.CustomerServiceMockMVCImpl;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerControllerMockMVC.class)
class CustomerControllerMockMVCTest {

    @MockBean
    CustomerServiceMockMVC customerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    CustomerServiceMockMVCImpl customerServiceImpl;

    @BeforeEach
    void setUp() {
        customerServiceImpl = new CustomerServiceMockMVCImpl();
    }

    @Captor
    ArgumentCaptor<UUID> uuidArgumentCaptor;

    @Test
    void testDeleteCustomer() throws Exception {
        CustomerMockMVC customer = customerServiceImpl.getAllCustomers().get(0);

        mockMvc.perform(delete("/api/v1/MockMVC/customer/" + customer.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(customerService).deleteCustomerById(uuidArgumentCaptor.capture());

        assertThat(customer.getId()).isEqualTo(uuidArgumentCaptor.getValue());
    }

    @Test
    void testUpdateCustomer() throws Exception {
        CustomerMockMVC customer = customerServiceImpl.getAllCustomers().get(0);

        mockMvc.perform(put("/api/v1/MockMVC/customer/" + customer.getId())
                        .content(objectMapper.writeValueAsString(customer))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(customerService).updateCustomerById(uuidArgumentCaptor.capture(), any(CustomerMockMVC.class));

        assertThat(customer.getId()).isEqualTo(uuidArgumentCaptor.getValue());
    }

    @Test
    void testCreateCustomer() throws Exception {
        CustomerMockMVC customer = customerServiceImpl.getAllCustomers().get(0);
        customer.setId(null);
        customer.setVersion(null);

        given(customerService.saveNewCustomer(any(CustomerMockMVC.class)))
                .willReturn(customerServiceImpl.getAllCustomers().get(1));

        mockMvc.perform(post("/api/v1/MockMVC/customer/").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"));
    }

    @Test
    void listAllCustomers() throws Exception {
        given(customerService.getAllCustomers()).willReturn(customerServiceImpl.getAllCustomers());

        mockMvc.perform(get("/api/v1/MockMVC/customer/")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()", is(3)));
    }

    @Test
    void getCustomerById() throws Exception {
        CustomerMockMVC customer = customerServiceImpl.getAllCustomers().get(0);

        given(customerService.getCustomerById(customer.getId())).willReturn(customer);

        mockMvc.perform(get("/api/v1/MockMVC/customer/" + customer.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is(customer.getName())));

    }
}


