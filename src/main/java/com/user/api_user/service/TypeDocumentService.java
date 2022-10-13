package com.user.api_user.service;

import com.user.api_user.model.TypeDocument;

import java.util.List;
import java.util.Optional;

public interface TypeDocumentService {
    List<TypeDocument> findAll();

    Optional<TypeDocument> findById(Long id);

    TypeDocument save(TypeDocument typeDocument);

    boolean delete(Long id);
}
