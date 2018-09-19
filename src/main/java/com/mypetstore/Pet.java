package com.mypetstore;

public class Pet {

    Long id;

    String name;
    String type;
    String gender;
    String zipcode;

    public Pet() {
    }

    public Pet(Long id, String name, String type, String gender, String zipcode) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.gender = gender;
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %s %s", id, name, type, gender, zipcode);
    }
}
