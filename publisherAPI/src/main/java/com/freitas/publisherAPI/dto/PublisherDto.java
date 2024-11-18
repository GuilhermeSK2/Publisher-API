package com.freitas.publisherAPI.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class PublisherDto {
    private UUID id;
    private String name;

    // Getters e Setters
}