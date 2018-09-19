package com.mypetstore;

import java.util.function.Predicate;

public class PetComparator implements Predicate<Pet> {

    Pet ref;

    public PetComparator(Pet ref) {
        if (ref == null) {
            throw new IllegalArgumentException("Invalid filter criteria");
        }
        this.ref = ref;
    }

    @Override
    public boolean test(Pet pet) {

        if (pet == null) {
            return false;
        }

        if (ref.name != null && !ref.name.equalsIgnoreCase(pet.name)) {
            return false;
        }

        if (ref.type != null && !ref.type.equalsIgnoreCase(pet.type)) {
            return false;
        }

        if (ref.gender != null && !ref.gender.equalsIgnoreCase(pet.gender)) {
            return false;
        }

        if (ref.zipcode != null && !ref.zipcode.equalsIgnoreCase(pet.zipcode)) {
            return false;
        }

        return true;
    }
}
