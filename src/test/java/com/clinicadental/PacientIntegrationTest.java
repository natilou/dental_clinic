package com.clinicadental;


import com.clinicadental.clinica.model.Address;
import com.clinicadental.clinica.model.Patient;
import com.clinicadental.clinica.service.AddressService;
import com.clinicadental.clinica.service.PatientService;
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

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc //add this anotation
public class PacientIntegrationTest {

    @Autowired
    private MockMvc mockMvc; //inyect this dependency


    @Test
    public void listPatientsTest() throws Exception {
        //call a controller method
        this.mockMvc.perform(MockMvcRequestBuilders.get("/patients"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findPacientByIdTest() throws Exception {
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/patients/{id}","1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Assert.assertEquals("application/json", response.getResponse().getContentType());
    }
}
