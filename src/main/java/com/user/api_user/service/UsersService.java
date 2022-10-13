package com.user.api_user.service;

import com.user.api_user.model.Dto.DtoUser;
import com.user.api_user.model.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {


   List<Users> findAll();

   Optional<Users> findById(Long id);

   Users save(Users user);

   boolean delete(Long id);

  DtoUser saveUser(DtoUser user);

}
