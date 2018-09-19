package com.mypetstore;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class PetsRepositoryTest {

    @Test(expected = FileNotFoundException.class)
    public void shouldReturnErrorForFileNotFound() throws IOException {
        //when
        new PetsRepository(this.getClass().getClassLoader().getResource(".").getPath()).search(new Pet());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnErrorForInvalidSearchCriteria() throws IOException {
        //when
        new PetsRepository(this.getClass().getClassLoader().getResource(".").getPath()).search(null);
    }

    @Test
    public void shouldMatchThePet() throws IOException {
        //given
        Pet searchCriteria = new Pet(1l, "snoopy", "dog", "male", "1234");

        //when
        List<Pet> matchingPet = new PetsRepository(this.getClass().getClassLoader().getResource("goodrepo.csv").getPath()).search(searchCriteria);

        //then

        Assert.assertNotNull(matchingPet);
        Assert.assertEquals(1, matchingPet.size());
        Assert.assertEquals("snoopy", matchingPet.get(0).name);


    }

    @Test
    public void shouldMatchAll() throws IOException {
        //given
        Pet searchCriteria = new Pet(null, null, null, null, "1234");

        //when
        List<Pet> matchingPet = new PetsRepository(this.getClass().getClassLoader().getResource("goodrepo.csv").getPath()).search(searchCriteria);

        //then

        Assert.assertNotNull(matchingPet);
        Assert.assertEquals(3, matchingPet.size());
    }

    @Test
    public void shouldFindAllDogsInZip() throws IOException {
        //given
        Pet searchCriteria = new Pet(null, null, "dog", null, "1234");

        //when
        List<Pet> matchingPet = new PetsRepository(this.getClass().getClassLoader().getResource("goodrepo.csv").getPath()).search(searchCriteria);

        //then
        matchingPet.forEach(System.out::println);
        Assert.assertNotNull(matchingPet);
        Assert.assertEquals(2, matchingPet.size());
    }

    @Test
    public void shouldNotMatchAny() throws IOException {
        //given
        Pet searchCriteria = new Pet(1l, "snoopy", "dog", "male", "12345");

        //when
        List<Pet> matchingPet = new PetsRepository(this.getClass().getClassLoader().getResource("goodrepo.csv").getPath()).search(searchCriteria);

        //then

        Assert.assertNotNull(matchingPet);
        Assert.assertEquals(0, matchingPet.size());


    }


}