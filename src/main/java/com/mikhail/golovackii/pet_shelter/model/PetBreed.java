package com.mikhail.golovackii.pet_shelter.model;

public enum PetBreed {

//    Dogs
    OUTBRED_DOG("дворняжка"),
    LABRADOR_RETRIEVER("лабрадор"),
    YORKSHIRE_TERRIER("йоркшер"),
    TAKSA("такса"),
    PEKINGESE("пекинес"),
    CHIHUAHUA("чихуахуа"),
    ROTTWEILER("ротвейлер"),
    CORGI("корги"),
    BULLDOG(",ekmlju"),
    HUSKY("хаски"),
    PUG("мопс"),

//    Cats
    OUTBRED_CAT("метис"),
    MAINE_COON("мейн-кун"),
    SIBERIAN("себирская"),
    BRITISH("британская"),
    SCOTTISH("шотландская"),
    SPHINX("сфинкс"),
    SIAMESE("сиамская");

    private final String value;

    PetBreed(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
