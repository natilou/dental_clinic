package com.clinicadental.clinica.service;

import com.clinicadental.clinica.model.Address;
import com.clinicadental.clinica.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IAddressService{
    @Autowired
    private IAddressRepository iAddressRepository;

    @Override
    public Address save(Address address){
        return iAddressRepository.save(address);
    }


    @Override
    public Optional<Address> findById(Long id){
        return iAddressRepository.findById(id);
    }


    @Override
    public void deleteById(Long id){
        iAddressRepository.deleteById(id);
    }


    @Override
    public Address update(Address address){
        return iAddressRepository.saveAndFlush(address);
    }


    @Override
    public List<Address> findAll(){
        return iAddressRepository.findAll();
    }
}
