package com.clinicadental;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DentistTest {

    /*Odontologo odontologo = new Odontologo(1522, "Isabella", "Lopez");
    Odontologo odontologo2 = new Odontologo(2366, "Pablo", "Perez");
    Odontologo odontologo3 = new Odontologo(1010, "Gino", "Pascualino");
    OdontologoService odontologoService = new OdontologoService();

    @Test
    public void TestBuscarTodos(){

        List<Odontologo> odontologoList = new ArrayList<>();
        odontologoList.add(odontologo);
        odontologoList.add(odontologo2);
        odontologoList.add(odontologo3);

        Assertions.assertEquals(odontologoList.size(), odontologoService.buscarTodos().size());
    }

    @Test
    public void TestBuscarPorId(){
        Assertions.assertNotNull(odontologoService.buscarPorId(2L));
    }

    /*@Test
    public void TestEliminar(){
        Assertions.assertTrue(odontologoService.eliminar(3L));
    }*/
}
