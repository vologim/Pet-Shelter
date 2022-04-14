package com.mikhail.golovackii.pet_shelter.controllers.RESTcontroller;

import java.util.List;

public interface BaseRESTController<T, ID> {
    void saveElem(T elem);

    void updateElem(T elem);

    T getElemById(ID id);

    List<T> getAllElements();

    void deleteElemById(ID id);
}
