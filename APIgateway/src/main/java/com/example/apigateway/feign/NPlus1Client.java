package com.example.apigateway.feign;

import com.example.apigateway.model.nplus1.Pet;
import com.example.apigateway.model.nplus1.Vet;
import com.example.apigateway.model.nplus1.Visit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "nplus1-client", url = "${config.main-app.url}")
public interface NPlus1Client {

    @GetMapping("/test/vets")
    List<Vet> getAllVets();

    @GetMapping("/test/vets/{id}")
    Vet getVetById(@PathVariable int id);

    @GetMapping("/test/pets/{petId}/visits")
    List<Visit> getAllVisitsForPet(@PathVariable int petId);

    @GetMapping("/test/pets")
    List<Pet> getAllPets();

    @GetMapping("/test/pets/{id}")
    Pet getPetById(@PathVariable int id);

}
