package com.mypetstore;

public class LineToPetMapper {

    public Pet mapLineToPet(String line) {

        String[] fields = line.split(",");

        if (fields.length != 5) {
            System.err.format("Skipping invalid line : %s %n", line);
            return null;
        }


        Long id;

        try {
            id = Long.parseLong(fields[0]);
        } catch (NumberFormatException e) {
            System.err.format("Skipping invalid line : %s %n", line);
            return null;
        }

        String name = fields[1];
        String type = fields[2];
        String gender = fields[3];
        String zipcode = fields[4];


        return new Pet(id, name, type, gender, zipcode);

    }
}
