package com.example.modularmonolith.nplus1.util;

import com.example.modularmonolith.nplus1.model.Pet;
import com.example.modularmonolith.nplus1.model.Vet;
import com.example.modularmonolith.nplus1.model.Visit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataUtil {

    public static final List<Vet> vets = new ArrayList<>(Arrays.asList(Vet.builder().id(1).firstName("Vet 1 name").lastName("lastname 2").build(),
            Vet.builder().id(2).firstName("Vet 2 name").lastName("lastname 2").build(), Vet.builder().id(3).firstName("Vet 3 name").lastName("lastname 3").build()));

    public static final List<Pet> pets = new ArrayList<>(Arrays.asList(Pet.builder().id(1).name("pet1").build(),
            Pet.builder().id(2).name("pet2").build(), Pet.builder().id(3).name("pet3").build()));

    public static final List<Visit> visits = new ArrayList<>(Arrays.asList(Visit.builder().treatingVetId(1).petId(1).id(1).build(), Visit.builder().treatingVetId(1).petId(2).id(2).build(),
            Visit.builder().treatingVetId(1).petId(3).id(3).build(), Visit.builder().treatingVetId(2).petId(2).id(4).build(),
            Visit.builder().treatingVetId(1).petId(1).id(5).build(), Visit.builder().treatingVetId(1).petId(1).id(6).build(),
            Visit.builder().treatingVetId(2).petId(1).id(7).build(), Visit.builder().treatingVetId(2).petId(1).id(8).build(),
            Visit.builder().treatingVetId(3).petId(3).id(9).build(), Visit.builder().treatingVetId(3).petId(2).id(10).build()));

}
