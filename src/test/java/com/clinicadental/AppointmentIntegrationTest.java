package com.clinicadental;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc //add this anotation
public class AppointmentIntegrationTest {

    @Autowired
    private MockMvc mockMvc; //inyect this dependency


    @Test
    public void listAppointmentsTest() throws Exception {
        //call a controller method
        this.mockMvc.perform(MockMvcRequestBuilders.get("/appointments"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findAppointmentsByIdTest() throws Exception {
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/appointments/{id}","52"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Assert.assertEquals("application/json", response.getResponse().getContentType());
    }
}
