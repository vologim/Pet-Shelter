package com.mikhail.golovackii.pet_shelter.model;

public enum Sex {
    M("мальчик"),
    F("девочка");

    private final String value;

    Sex(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
