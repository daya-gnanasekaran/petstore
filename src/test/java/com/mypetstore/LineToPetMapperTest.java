package com.mypetstore;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class LineToPetMapperTest {

    LineToPetMapper lineToPetMapper = new LineToPetMapper();

    @Test
    public void shouldMapValidLineToPet() {
        //given

        String line = "1,snoopy,dog,male,97205";

        //when

        Pet pet = lineToPetMapper.mapLineToPet(line);

        //then
        Assert.assertNotNull("Should be mapped", pet);
        assertEquals(Long.valueOf(1), pet.id);
        assertEquals("snoopy", pet.name);
        assertEquals("dog", pet.type);
        assertEquals("male", pet.gender);
        assertEquals("97205", pet.zipcode);


    }


    @Test
    public void shouldSkipInValidLine() {
        //given

        String line = "1,dog,male,97205";

        //when

        Pet pet = lineToPetMapper.mapLineToPet(line);

        //then
        assertNull("Should be mapped", pet);
    }

    @Test
    public void shouldSkipInValidId() {
        //given

        String line = "x,snoopy,dog,male,97205";

        //when

        Pet pet = lineToPetMapper.mapLineToPet(line);

        //then
        assertNull("Should be mapped", pet);
    }
}