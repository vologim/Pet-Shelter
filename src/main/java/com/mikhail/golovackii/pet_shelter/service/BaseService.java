package com.mikhail.golovackii.pet_shelter.service;

import java.util.List;

public interface BaseService <T, ID> {
    void saveElem(T elem);

    void updateElem(T elem);

    T getElemById(ID id);

    List<T> getAllElements();

    void deleteElemById(ID id);
}
