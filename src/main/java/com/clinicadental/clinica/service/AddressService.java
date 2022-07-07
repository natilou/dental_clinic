package com.clinicadental.clinica.service;

import com.clinicadental.clinica.exceptions.ResourceNotFoundException;
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

    public Address findById(Long id) throws ResourceNotFoundException {
        Optional<Address> optionalAddress = iAddressRepository.findById(id);
        if(optionalAddress.isEmpty()){
            throw new ResourceNotFoundException("Address with id " + id + " does not exist.");
        }
        return optionalAddress.get();
    }


    public boolean deleteById(Long id) throws ResourceNotFoundException {
        if(this.findById(id) == null) {
            throw new ResourceNotFoundException("Address with id " + id + " does not exist.");
        }
        iAddressRepository.deleteById(id);
        return true;
    }


    public Address update(Address address){
        return iAddressRepository.save(address);
    }


    public List<Address> findAll(){
        return iAddressRepository.findAll();
    }
}
