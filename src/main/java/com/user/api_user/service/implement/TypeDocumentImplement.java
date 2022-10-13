package com.user.api_user.service.implement;
import com.user.api_user.model.TypeDocument;
import com.user.api_user.repository.TypeDocumentRepository;
import com.user.api_user.service.TypeDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TypeDocumentImplement implements TypeDocumentService {

    @Autowired
    TypeDocumentRepository typeDocumentRepository;

    @Override
    public List<TypeDocument> findAll() {
        List<TypeDocument> typeDocument = new ArrayList<>();
        try{
            typeDocument = typeDocumentRepository.findAll();
        }catch(Exception e){
            System.out.println("Ocurrio un error" + e);
        }
        return typeDocument;
    }

    @Override
    public Optional<TypeDocument> findById(Long id) {
    Optional<TypeDocument> typeDocument = Optional.empty();
        try{
            typeDocument = typeDocumentRepository.findById(id);
        }catch(Exception e){
            System.out.println("Ocurrio un error: "+e);
        }
        return typeDocument;
    }

    @Override
    public TypeDocument save(TypeDocument typeDocument) {
        TypeDocument typeDocumentSaved = new TypeDocument();
        try{
            typeDocumentSaved = typeDocumentRepository.save(typeDocumentSaved);
        }catch(Exception e){
            System.out.println("Ocurrio un error: " + e);
        }
        return typeDocumentSaved;
    }

    @Override
    public boolean delete(Long id) {
        Optional<TypeDocument> typeDocument = typeDocumentRepository.findById(id);
        if(typeDocument.isPresent()){
            typeDocumentRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
