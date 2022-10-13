package com.user.api_user.service;

import com.user.api_user.model.Documents;
import com.user.api_user.model.Dto.DocumentsDto;

import java.util.List;
import java.util.Optional;

public interface DocumentsService {
    List<Documents> findAll();

    Optional<Documents> findById(Long id);

    Documents save(Documents documents);

    List<Documents> getDocumentsUser(Long id);

    boolean delete(Long id);
}
