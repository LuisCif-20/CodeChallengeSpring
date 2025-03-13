package com.ayd2.cc4.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.mockito.BDDMockito.given;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;

import com.ayd2.cc4.dto.DriverDto;
import com.ayd2.cc4.model.Driver;
import com.ayd2.cc4.response.DriverResponse;
import com.ayd2.cc4.service.DriverServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = DriverController.class)
@AutoConfigureMockMvc(addFilters = false)
public class DriverControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private DriverServiceImpl driverServiceiImpl;

    private DriverDto driverDto;

    private Driver driver;

    private DriverResponse driverResponse;

    @BeforeEach()
    public void init() {
        driver = new Driver();
        driver.setName("Luis Nery Cifuentes Rodas");
        driver.setAge(22);
        driverDto = DriverDto.builder()
            .name("Luis Nery Cifuentes Rodas")
            .age(22)
            .build();
        driverResponse = new DriverResponse(driver);
    }

    @Test
    public void createDriverShouldReturnCreated() throws Exception {
        given(this.driverServiceiImpl.createDriver(driverDto)).willReturn(driverResponse);
        ResultActions response = mockMvc.perform(
            post("/driver")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(driverDto))
        );
        response.andExpect(status().isCreated());
    }

}
