package com.example.apigateway.controller.nplus1;

import com.example.apigateway.feign.NPlus1Client;
import com.example.apigateway.model.nplus1.Pet;
import com.example.apigateway.model.nplus1.Vet;
import com.example.apigateway.model.nplus1.Visit;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.BatchLoaderEnvironment;
import org.dataloader.DataLoader;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.graphql.execution.BatchLoaderRegistry;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Controller
@RequiredArgsConstructor
public class NPlus1Controller {

    private final NPlus1Client nPlus1Client;

//    public NPlus1Controller(NPlus1Client nPlus1Client, BatchLoaderRegistry batchLoaderRegistry) {
//        this.nPlus1Client = nPlus1Client;
//
//        batchLoaderRegistry.forTypePair(Integer.class, Vet.class)
//                .registerBatchLoader(
//                        (List<Integer> ids, BatchLoaderEnvironment env) -> {
//                            log.info("Loading vets with ids {}", ids);
//                            Flux<Vet>
//                        }
//                );
//    }

    @QueryMapping
    List<Vet> vets() {
        log.info("Getting all vets...");
        return nPlus1Client.getAllVets();
    }

    @QueryMapping
    Vet vet(@Argument int id) {
        log.info("Getting vet with id {}", id);
        return nPlus1Client.getVetById(id);
    }

    @QueryMapping
    List<Visit> visits(@Argument int petId) {
        log.info("Getting all visits for pet with id {}", petId);
        return nPlus1Client.getAllVisitsForPet(petId);
    }

    @QueryMapping
    List<Pet> pets() {
        log.info("Getting all pets...");
        return nPlus1Client.getAllPets();
    }

    @QueryMapping
    Pet pet(@Argument int id) {
        log.info("Getting pet by id {}", id);
        return nPlus1Client.getPetById(id);
    }

    //when CompleteableFutures and DataLoaders are introduced, schema mapping is still called
    //each time, but it doesn't make all calls to REST API
    @SchemaMapping(typeName = "Visit")
    public Vet treatingVet(Visit visit, DataFetchingEnvironment env, DataLoader<Integer, Vet> dataLoader) {
        if (visit.getTreatingVetId() == null) {
            return null;
        }

        log.info("Delegating loading of Vet with id {} from REST", visit.getTreatingVetId());

      //  return dataLoader.load(visit.getTreatingVetId());

         return nPlus1Client.getVetById(visit.getTreatingVetId());
    }

}
