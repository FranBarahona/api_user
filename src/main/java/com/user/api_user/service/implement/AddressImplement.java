package com.user.api_user.service.implement;

import com.user.api_user.model.Address;
import com.user.api_user.repository.AddressRepository;
import com.user.api_user.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AddressImplement implements AddressService {
    @Autowired
    AddressRepository addressRepository;


    @Override
    public List<Address> findAll() {
        List<Address> address = new ArrayList<>();
        try{
            address = addressRepository.findAll();
        }catch (Exception e){
            System.out.println("Ocurrio un erro"+ e);
        }
        return address;
    }

    @Override
    public Optional<Address> findById(Long id) {
        Optional<Address> address = Optional.empty();
        try{
            address = addressRepository.findById(id);
        }catch(Exception e){
            System.out.println("Ocurrio un error: "+e);
        }
        return address;
    }

    @Override
    public Address save(Address address) {
        Address addressSaved = new Address();
        try{
            addressSaved = addressRepository.save(address);
        }catch(Exception e){
            System.out.println("Ocurrio un error: " + e);
        }
        return addressSaved;
    }

    @Override
    public List<Address> getAddressUser(Long id) {

        return addressRepository.listAddressUser(id);
    }

    @Override
    public boolean delete(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        if(address.isPresent()){
            addressRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
