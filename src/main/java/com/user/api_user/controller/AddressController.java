package com.user.api_user.controller;

import com.user.api_user.model.Address;
import com.user.api_user.service.implement.AddressImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressImplement addressService;

    @GetMapping("/all")
    public List<Address> getAll(){
        return addressService.findAll();
    }

    @GetMapping("/getAddress/{id}")
    public List<Address> getAllAddressUser(@PathVariable Long id){
        return addressService.getAddressUser(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Address> save(@RequestBody Address address){
        Address addressSaved = addressService.save(address);
        return new ResponseEntity<>(addressSaved, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Address> update(@RequestBody Address address){
        if (Objects.isNull(addressService.save(address))) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(address, HttpStatus.OK);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Address> find(@PathVariable Long id){
        return addressService.findById(id).map(user -> new ResponseEntity<>(user,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Address> delete(@PathVariable Long id){
        if(addressService.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
