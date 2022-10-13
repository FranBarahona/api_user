package com.user.api_user.repository;

import com.user.api_user.model.Documents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DocumentsRepository extends JpaRepository<Documents,Long> {


    @Query(nativeQuery = true, value = "SELECT *  FROM users.users.documents d WHERE d.id_user = :id")
      List<Documents>  listDocumentUser(Long id);
}
