package com.user.api_user.controller;

import com.user.api_user.model.TypeDocument;
import com.user.api_user.service.implement.TypeDocumentImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/typedocument")
public class TypeDocumentController {

    @Autowired
    TypeDocumentImplement typeDocumentService;

    @GetMapping("/all")
    public List<TypeDocument> getAll(){
        return typeDocumentService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<TypeDocument> save(@RequestBody TypeDocument typeDocument){
        TypeDocument typeDocumentSaved = typeDocumentService.save(typeDocument);
        return new ResponseEntity<>(typeDocumentSaved, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<TypeDocument> update(@RequestBody TypeDocument typeDocument){
        if (Objects.isNull(typeDocumentService.save(typeDocument))) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(typeDocument, HttpStatus.OK);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<TypeDocument> find(@PathVariable Long id){
        return typeDocumentService.findById(id).map(user -> new ResponseEntity<>(user,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TypeDocument> delete(@PathVariable Long id){
        if(typeDocumentService.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
