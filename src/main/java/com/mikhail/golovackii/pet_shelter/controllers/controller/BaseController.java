package com.mikhail.golovackii.pet_shelter.controllers.controller;

import java.util.List;

public interface BaseController<T, ID> {
    String saveElem(T elem);

    String updateElem(T elem);

    String getElemById(ID id);

    String getAllElements();

    String deleteElemById(ID id);
}
