package com.clinicadental.clinica.service;

import com.clinicadental.clinica.model.Address;
import com.clinicadental.clinica.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private IAddressRepository iAddressRepository;

    public Address save(Address address){
        return iAddressRepository.save(address);
    }

    public Optional<Address> findById(Long id){
        return iAddressRepository.findById(id);
    }


    public void deleteById(Long id){
        iAddressRepository.deleteById(id);
    }


    public Address update(Address address){
        return iAddressRepository.saveAndFlush(address);
    }


    public List<Address> findAll(){
        return iAddressRepository.findAll();
    }
}
