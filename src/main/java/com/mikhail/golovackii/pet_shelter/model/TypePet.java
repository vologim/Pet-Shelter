package com.mikhail.golovackii.pet_shelter.model;

public enum TypePet {
    DOG("собака"),
    CAT("кот");

    private final String value;

    TypePet(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
