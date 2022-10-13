package com.user.api_user.repository;

import com.user.api_user.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {


    @Query(nativeQuery = true, value = "SELECT *  FROM  USERS.USERS.address A where A.id_user = :id \n")
      List<Address> listAddressUser(Long id);

}

