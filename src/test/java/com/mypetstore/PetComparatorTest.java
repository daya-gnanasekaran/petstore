package com.mypetstore;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PetComparatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowErrorIfRefIsNull() {
        //when
        new PetComparator(null);
    }


    @Test
    public void shouldReturnFalseForNullPet() {

        //given
        PetComparator petComparator = new PetComparator(new Pet());

        //when

        boolean result = petComparator.test(null);

        //then
        assertEquals(false, result);

    }

    @Test
    public void shouldMatchByName() {

        //given
        Pet ref = new Pet();
        ref.name = "snoopy";

        Pet pet = new Pet();
        pet.name = "noopy";
        pet.type = "dog";

        PetComparator petComparator = new PetComparator(ref);

        //when
        boolean result = petComparator.test(pet);

        //then
        assertEquals(false, result);

    }

    @Test
    public void shouldMatchByType() {

        //given
        Pet ref = new Pet();
        ref.name = "snoopy";
        ref.type = "cat";


        Pet pet = new Pet();
        pet.name = "snoopy";
        pet.type = "dog";

        PetComparator petComparator = new PetComparator(ref);

        //when
        boolean result = petComparator.test(pet);

        //then
        assertEquals(false, result);

    }

    @Test
    public void shouldMatchByGender() {

        //given
        Pet ref = new Pet();
        ref.name = "snoopy";
        ref.type = "dog";
        ref.gender = "female";


        Pet pet = new Pet();
        pet.name = "snoopy";
        pet.type = "dog";
        pet.gender = "male";


        PetComparator petComparator = new PetComparator(ref);

        //when
        boolean result = petComparator.test(pet);

        //then
        assertEquals(false, result);

    }

    @Test
    public void shouldMatchByZipCode() {

        //given
        Pet ref = new Pet();
        ref.name = "snoopy";
        ref.type = "dog";
        ref.gender = "male";
        ref.zipcode ="1234";


        Pet pet = new Pet();
        pet.name = "snoopy";
        pet.type = "dog";
        pet.gender = "male";
        pet.zipcode ="2345";



        PetComparator petComparator = new PetComparator(ref);

        //when
        boolean result = petComparator.test(pet);

        //then
        assertEquals(false, result);

    }

    @Test
    public void shouldMatch() {

        //given
        Pet ref = new Pet();
        ref.name = "snoopy";
        ref.type = "dog";
        ref.gender = "male";
        ref.zipcode ="1234";


        Pet pet = new Pet();
        pet.name = "snoopy";
        pet.type = "dog";
        pet.gender = "male";
        pet.zipcode ="1234";



        PetComparator petComparator = new PetComparator(ref);

        //when
        boolean result = petComparator.test(pet);

        //then
        assertEquals(true, result);

    }

}