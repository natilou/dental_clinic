package com.clinicadental;

import com.clinicadental.clinica.repository.impl.OdontologoDaoH2;
import com.clinicadental.clinica.model.Odontologo;
import com.clinicadental.clinica.service.OdontologoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestOdontologos {

    Odontologo odontologo = new Odontologo(1522, "Isabella", "Lopez");
    Odontologo odontologo2 = new Odontologo(2366, "Pablo", "Perez");
    Odontologo odontologo3 = new Odontologo(1010, "Gino", "Pascualino");
    OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

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
        Assertions.assertNotNull(odontologoService.buscarPorId(2));
    }

    @Test
    public void TestEliminar(){
        Assertions.assertTrue(odontologoService.eliminar(3));
    }
}
