package com.user.api_user.repository;

import com.user.api_user.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRespository extends JpaRepository<Users, Long> {


}
