package com.example.apigateway.controller.nplus1;

import com.example.apigateway.feign.NPlus1Client;
import com.example.apigateway.model.nplus1.Pet;
import com.example.apigateway.model.nplus1.Vet;
import com.example.apigateway.model.nplus1.Visit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class NPlus1Controller {

    private final NPlus1Client client;

    @QueryMapping
    List<Vet> vets() {
        log.info("Getting all vets...");
        return client.getAllVets();
    }

    @QueryMapping
    Vet vet(@Argument int id) {
        log.info("Getting vet with id {}", id);
        return client.getVetById(id);
    }

    @QueryMapping
    List<Visit> visits(@Argument int petId) {
        log.info("Getting all visits for pet with id {}", petId);
        return client.getAllVisitsForPet(petId);
    }

    @QueryMapping
    List<Pet> pets() {
        log.info("Getting all pets...");
        return client.getAllPets();
    }

    @QueryMapping
    Pet pet(@Argument int id) {
        log.info("Getting pet by id {}", id);
        return client.getPetById(id);
    }

    @SchemaMapping(typeName = "Visit")
    public Vet treatingVet(Visit visit) {
        if (visit.getTreatingVetId() == null) {
            return null;
        }

        log.info("Delegating loading of Vet with id {} from REST", visit.getTreatingVetId());

        return client.getVetById(visit.getTreatingVetId());
    }

}
