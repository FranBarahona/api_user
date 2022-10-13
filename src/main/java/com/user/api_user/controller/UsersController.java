package com.user.api_user.controller;

import com.user.api_user.model.Dto.DtoUser;
import com.user.api_user.model.Users;
import com.user.api_user.service.implement.UsersImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UsersController {


    @Autowired
    private UsersImplement Userservice;


    @GetMapping("/all")
    public List<Users> getAll(){
        return Userservice.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<Users> save(@RequestBody Users user){
        Users userSaved = Userservice.save(user);
        return new ResponseEntity<>(userSaved, HttpStatus.OK);
    }

    @PostMapping("/saveUser")
    public ResponseEntity<DtoUser> save(@RequestBody DtoUser user){
        DtoUser userSaved = Userservice.saveUser(user);
        return new ResponseEntity<>(userSaved, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Users> update(@RequestBody Users user){
        if (Objects.isNull(Userservice.save(user))) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Users> find(@PathVariable Long id){
        return Userservice.findById(id).map(user -> new ResponseEntity<>(user,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Users> delete(@PathVariable Long id){
        if(Userservice.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

}
