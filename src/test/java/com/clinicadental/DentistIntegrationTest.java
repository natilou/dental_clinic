package com.clinicadental;
import com.clinicadental.clinica.model.Dentist;
import com.clinicadental.clinica.service.DentistService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)//add this anotation
public class DentistIntegrationTest {

    @Autowired
    private MockMvc mockMvc; //inyect this dependency
    @Autowired
    private DentistService dentistService;


    @Test
    public void saveOdontologoTest() throws Exception {
        //Crea un nuevo objeto Odontologo
        Dentist Dentist = new Dentist(348971960, "Juan", "Ramirez");
        //Ahora se debe convertir el objeto a un String Json para enviarlo al REQUEST
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String odontolgoJson = writer.writeValueAsString(dentistService);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/dentists")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(odontolgoJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }


}



