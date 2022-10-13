package com.user.api_user.controller;
import com.user.api_user.model.Documents;
import com.user.api_user.model.Dto.DocumentsDto;
import com.user.api_user.service.implement.DocumentsImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/documents")
public class DocumentController {
    @Autowired
    private DocumentsImplement documentsService;

    @GetMapping("/all")
    public List<Documents> getAll() {
        return documentsService.findAll();
    }

    @GetMapping("/getDocuments/{id}")
    public List<Documents> getAllDocumentsUser(@PathVariable Long id) {
        return documentsService.getDocumentsUser(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Documents> save(@RequestBody Documents document) {
        Documents documentSaved = documentsService.save(document);
        return new ResponseEntity<>(documentSaved, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Documents> update(@RequestBody Documents document) {
        if (Objects.isNull(documentsService.save(document))) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(document, HttpStatus.OK);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Documents> find(@PathVariable Long id) {
        return documentsService.findById(id).map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Documents> delete(@PathVariable Long id) {
        if (documentsService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
