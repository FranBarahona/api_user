package com.user.api_user.service.implement;

import com.user.api_user.model.Documents;
import com.user.api_user.repository.DocumentsRepository;
import com.user.api_user.service.DocumentsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class DocumentsImplement implements DocumentsService {

    @Autowired
    DocumentsRepository documentsRepository;



    @Override
    public List<Documents> findAll() {
        List<Documents> documents = new ArrayList<>();
        try{
            documents = documentsRepository.findAll();
        }catch(Exception e){
            System.out.println("Ocurrio un error" + e);
        }
        return documents;
    }

    @Override
    public Optional<Documents> findById(Long id) {
        Optional<Documents> documents = Optional.empty();
        try{
            documents = documentsRepository.findById(id);
        }catch(Exception e){
            System.out.println("Ocurrio un error: "+e);
        }
        return documents;
    }

    @Override
    public Documents save(Documents documents) {
        Documents documentSaved = new Documents();
        try{
            documentSaved = documentsRepository.save(documents);
        }catch(Exception e){
            System.out.println("Ocurrio un error: " + e);
        }
        return documentSaved;
    }

    @Override
    public List<Documents> getDocumentsUser(Long id ) {

        return documentsRepository.listDocumentUser(id);
    }

    @Override
    public boolean delete(Long id) {
        Optional<Documents> document = documentsRepository.findById(id);
        if(document.isPresent()){
            documentsRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
