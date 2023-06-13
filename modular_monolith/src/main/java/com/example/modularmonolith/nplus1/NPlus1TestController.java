package com.example.modularmonolith.nplus1;

import com.example.modularmonolith.nplus1.model.Pet;
import com.example.modularmonolith.nplus1.model.Vet;
import com.example.modularmonolith.nplus1.model.Visit;
import com.example.modularmonolith.nplus1.util.DataUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/test")
public class NPlus1TestController {


    @GetMapping("/vets")
    List<Vet> getAllVets() {
        log.info("Getting all vets...");
        return DataUtil.vets;
    }

    @GetMapping("/vets/{id}")
    Vet getVetById(@PathVariable int id) {
        log.info("Getting vet with id {}", id);
        return DataUtil.vets.stream().filter(vet -> vet.getId() == id).findFirst().orElse(null);
    }

    @GetMapping("/pets/{petId}/visits")
    List<Visit> getAllVisitsForPet(@PathVariable int petId) {
        log.info("Getting all visits for pet with id {}", petId);
        return DataUtil.visits.stream().filter(visit -> visit.getPetId() == petId).toList();
    }

    @GetMapping("/pets")
    List<Pet> getAllPets() {
        log.info("Getting all pets...");
        return DataUtil.pets;
    }

    @GetMapping("/pets/{id}")
    Pet getPetById(@PathVariable int id) {
        log.info("Getting pet by id {}", id);
        return DataUtil.pets.stream().filter(pet -> pet.getId() == id).findFirst().orElse(null);
    }

    @GetMapping("/vets/ids")
    List<Vet> getVetsWithIds(List<Integer> ids) {
        return DataUtil.vets.stream().filter(vet -> isIdPresent(vet.getId(), ids)).toList();
    }

    private boolean isIdPresent(int id, List<Integer> ids) {
        return ids.stream().anyMatch(requestedId -> requestedId == id);
    }

}
