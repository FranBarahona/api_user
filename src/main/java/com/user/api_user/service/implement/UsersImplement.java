package com.user.api_user.service.implement;

import com.user.api_user.model.Address;
import com.user.api_user.model.Documents;
import com.user.api_user.model.Dto.DtoUser;
import com.user.api_user.model.TypeDocument;
import com.user.api_user.model.Users;
import com.user.api_user.repository.AddressRepository;
import com.user.api_user.repository.DocumentsRepository;
import com.user.api_user.repository.TypeDocumentRepository;
import com.user.api_user.repository.UsersRespository;
import com.user.api_user.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersImplement implements UsersService {

    @Autowired
    UsersRespository usersRespository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    TypeDocumentRepository typeDocumentRepository;

    @Autowired
    DocumentsRepository documentsRepository;

    @Override
    public List<Users> findAll() {
        List<Users> users = new ArrayList<>();
        try{
            users = usersRespository.findAll();
        }catch(Exception e){
            System.out.println("Ocurrio un error" + e);
        }
        return users;
    }

    @Override
    public Optional<Users> findById(Long id) {
        Optional<Users> user = Optional.empty();
        try{
            user = usersRespository.findById(id);
        }catch(Exception e){
            System.out.println("Ocurrio un error: "+e);
        }
        return user;
    }

    @Override
    public Users save(Users user) {
        Users userSaved = new Users();
        try{
            userSaved = usersRespository.save(user);
        }catch(Exception e){
            System.out.println("Ocurrio un error: " + e);
        }
        return userSaved;
    }


    @Override
    public boolean delete(Long id) {
        try{
            usersRespository.deleteById(id);
            return true;
        }catch(Exception e){
            System.out.println("Ocurrio un error "+ e);
            return false;
        }
    }

    //este metodo se encarga de guardar losd atos que vienen del formulario
    @Override
    public DtoUser saveUser(DtoUser user) {

        try {
            //users
            Users userToSave = new Users();
            userToSave.setNames(user.getNames());
            userToSave.setLastNames(user.getLastNames());
            Users userSaved = usersRespository.save(userToSave);

            //Address
            user.getAddress().forEach(address -> {
                Address addressToSave = new Address();
                addressToSave.setIdUsers(userSaved);
                addressToSave.setAddress(address.get("address"));
                addressRepository.save(addressToSave);
            });

            //Documents
            user.getDocuments().forEach(document -> {
                Documents documentToSave = new Documents();
                TypeDocument typeDocumentToSave = new TypeDocument();
                typeDocumentToSave.setId(document.get("typeDocument"));
                documentToSave.setIdTypeDocument(typeDocumentToSave);
                documentToSave.setDocument(Long.toString(document.get("document")));
                documentToSave.setIdUser(userSaved);
                documentsRepository.save(documentToSave);
            });

            return null;
        } catch (Exception e) {
            System.out.println("ocurrio un error: " + e);
        }
    return null;
    }
}
