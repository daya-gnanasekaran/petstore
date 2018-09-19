package com.mypetstore;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetStore {

    public static void main(String[] args) {

        try {
            Map<Parameter, String> params = processArgs(args);
            List<Pet> matchingPets = new PetsRepository(params.get(Parameter.file)).search(createSearchCriteria(params));
            printSearchResults(matchingPets);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            printUsage();
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Error while accessing file:" + e.getMessage());
        }
    }

    static Map<Parameter, String> processArgs(String[] args) throws FileNotFoundException{

        Map<Parameter, String> params = new HashMap<>();

        for (int i = 0; i < args.length; i += 2) {
            Parameter parameter = Enum.valueOf(Parameter.class, args[i].replace("-", ""));
            if (args.length - 1 == i) {
                throw new IllegalArgumentException(String.format("Value needed for %s", args[i]));
            }
            params.put(parameter, args[i + 1]);
        }

        if (!params.containsKey(Parameter.file)) {
            throw new IllegalArgumentException(String.format("Missing required argument: %s %n", Parameter.file.name()));
        }


        if (Files.notExists(Paths.get(params.get(Parameter.file)))) {
            throw new FileNotFoundException(String.format("File not found: %s %n", params.get(Parameter.file)));
        }
        return params;
    }

    private static void printUsage() {
        StringBuilder usageMessageBuilder = new StringBuilder("Usage: java ").append(PetStore.class.getSimpleName()).append(" ");
        for (Parameter parameter : Parameter.values()) {
            usageMessageBuilder.append(String.format("-%s <value> ", parameter.name()));
        }

        System.out.println(usageMessageBuilder.toString());
    }

    private static Pet createSearchCriteria(Map<Parameter, String> params) {
        return new Pet(-1l, params.get(Parameter.name), params.get(Parameter.type), params.get(Parameter.gender), params.get(Parameter.zipcode));
    }

    private static void printSearchResults(List<Pet> searchResults) {
        if (searchResults.isEmpty()) {
            System.out.println("No Pets found matching the search criteria!");
            return;
        }

        System.out.println("Pets matching the search criteria:");

        searchResults.forEach(System.out::println);

    }

}
