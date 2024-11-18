package com.freitas.publisherAPI.service;

import com.freitas.publisherAPI.model.PublisherModel;
import com.freitas.publisherAPI.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public List<PublisherModel> getAllPublishers(){
        return publisherRepository.findAll();
    }

    public PublisherModel savePublisher(PublisherModel publisher) {
        return publisherRepository.save(publisher);
    }

    public Optional<PublisherModel> findPublisherById(UUID id) {
        return publisherRepository.findById(id);
    }

    public void deletePublisher(UUID id){
        publisherRepository.deleteById(id);
    }
}