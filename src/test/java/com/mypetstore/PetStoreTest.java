package com.mypetstore;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Map;

public class PetStoreTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldCheckIfFileIsProvided() throws FileNotFoundException {

        //given
        String[] args = {};

        //when

        PetStore.processArgs(args);
    }

    @Test(expected = FileNotFoundException.class)
    public void shouldCheckIfProvidedFileExists() throws FileNotFoundException {

        //given
        String[] args = {"-file", "123.txt"};

        //when

        PetStore.processArgs(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldValidateEmptyArgs() throws FileNotFoundException {

        //given
        String[] args = {"-name", "123.txt", "-type"};

        //when

        PetStore.processArgs(args);
    }

    @Test
    public void shouldProcessArgs() throws FileNotFoundException {

        //given
        String[] args = {"-name", "123.txt", "-file", this.getClass().getClassLoader().getResource(".").getPath()};

        //when
        Map<Parameter, String> params = PetStore.processArgs(args);


        //then
        Assert.assertEquals(false, params.isEmpty());
        Assert.assertEquals(2, params.size());
    }
}