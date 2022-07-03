package com.clinicadental.clinica.controller;
import com.clinicadental.clinica.exceptions.ResourceNotFoundException;
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
    public ResponseEntity<Dentist> findById(@PathVariable Integer id){
        Dentist dentist = dentistService.findById(id);
        if (dentist != null){
           return ResponseEntity.ok(dentist);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) throws ResourceNotFoundException {
        ResponseEntity<String> response;
        if (dentistService.findById(id) != null){
            dentistService.deleteById(id);
            response = ResponseEntity.status(HttpStatus.OK).body("Dentist with id " + id + " deleted.");
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
        if(dentistService.findById(dentist.getId()) != null) {
            return ResponseEntity.ok(dentistService.update(dentist));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping("/list")
    public ResponseEntity<List<Dentist>> saveAll(@RequestBody List<Dentist> dentists){
        return ResponseEntity.ok(dentistService.saveAll(dentists));
    }

  /*  @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> manageErrorNotFound(ResourceNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }*/
}
