package com.unioeste.academus.services;

import com.unioeste.academus.exceptions.NotFoundException;
import com.unioeste.academus.models.Course;
import com.unioeste.academus.models.address.Address;
import com.unioeste.academus.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address findById(Long courseId) {
        return addressRepository.findById(courseId).orElseThrow(() -> new NotFoundException("Curso não encontrado com id " + courseId));
    }

    public void save(Address address) {
        addressRepository.save(address);
    }

    public void delete(Long courseId) {
        if(addressRepository.existsById(courseId)) {
            addressRepository.deleteById(courseId);
        }

        throw new NotFoundException("Não foi possível encontrar endereço com id " + courseId);
    }

    public boolean existsById(Long courseId) {
        return addressRepository.existsById(courseId);
    }
}
