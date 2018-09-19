package com.mypetstore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class PetsRepository {

    File file;

    LineToPetMapper mapper = new LineToPetMapper();

    public PetsRepository(String file) {

        this.file = new File(file);
    }

    public List<Pet> search(Pet searchCriteria) throws IOException {

        List<Pet> matchingPets;

        PetComparator petFilter = new PetComparator(searchCriteria);
        try (InputStream is = new FileInputStream(file);
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            matchingPets = br.lines().skip(1).map(line -> mapper.mapLineToPet(line)).filter(pet -> petFilter.test(pet)).collect(Collectors.toList());

        }

        return matchingPets;


    }


}
