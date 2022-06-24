package com.clinicadental.clinica.service;

import com.clinicadental.clinica.model.Address;

import java.util.List;
import java.util.Optional;

public interface IAddressService {
    Address save(Address address);
    Optional<Address> findById(Long id);
    void deleteById(Long id);
    Address update(Address address);
    List<Address> findAll();
}

