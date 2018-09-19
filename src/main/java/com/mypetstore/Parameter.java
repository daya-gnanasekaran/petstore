package com.mypetstore;

import java.util.Arrays;
import java.util.List;

public enum Parameter {
    file,
    name,
    type,
    gender,
    zipcode;


    public static List<Parameter> searchParameters() {
        return Arrays.asList(name, type, gender, zipcode);
    }
}
