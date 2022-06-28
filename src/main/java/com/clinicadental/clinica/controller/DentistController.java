package com.clinicadental.clinica.controller;
import com.clinicadental.clinica.model.Dentist;
import com.clinicadental.clinica.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentists")
public class DentistController {

    @Autowired
    private DentistService dentistService;

    @GetMapping("/{id}")
    public ResponseEntity<Dentist> findById(@PathVariable Long id){
       if (dentistService.findById(id) != null){
           return ResponseEntity.ok(dentistService.findById(id));
       } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        ResponseEntity<String> response;
        if (dentistService.findById(id) != null){
            dentistService.deleteById(id);
            response = ResponseEntity.status(HttpStatus.OK).body("Deleted");
        }else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;

    }


    @GetMapping
    public ResponseEntity<List<Dentist>> findAll(){
        return ResponseEntity.ok(dentistService.findAll());
    }


    @PostMapping
    public ResponseEntity<Dentist> save(@RequestBody Dentist dentist){
        return ResponseEntity.ok(dentistService.save(dentist));
    }

    @PutMapping
    public ResponseEntity<Dentist> update(@RequestBody Dentist dentist){
        return ResponseEntity.ok(dentistService.update(dentist));
    }
    @PostMapping("/list")
    public ResponseEntity<List<Dentist>> saveAll(@RequestBody List<Dentist> dentists){
        return ResponseEntity.ok(dentistService.saveAll(dentists));
    }
}
