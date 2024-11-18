package com.freitas.publisherAPI.controller;

import com.freitas.publisherAPI.dto.PublisherDto;
import com.freitas.publisherAPI.model.PublisherModel;
import com.freitas.publisherAPI.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService; //Injeção

    @GetMapping
    public ResponseEntity<List<PublisherModel>> getAllPublishers(){
        return ResponseEntity.status(HttpStatus.OK).body(publisherService.getAllPublishers());
    }

    @PostMapping
    public ResponseEntity<PublisherModel> createPublisher(@RequestBody PublisherDto publisherDto) {
        PublisherModel publisher = new PublisherModel();
        publisher.setName(publisherDto.getName());
        PublisherModel savedPublisher = publisherService.savePublisher(publisher);
        return ResponseEntity.ok(savedPublisher);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherModel> getPublisher(@PathVariable UUID id) {
        return publisherService.findPublisherById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePublisher(@PathVariable UUID id) {
        publisherService.deletePublisher(id);
        return ResponseEntity.status(HttpStatus.OK).body("Editora deletada com sucesso!");
    }
}
