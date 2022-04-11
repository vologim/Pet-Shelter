package com.mikhail.golovackii.pet_shelter.service.impl;

import com.mikhail.golovackii.pet_shelter.model.Shelter;
import com.mikhail.golovackii.pet_shelter.repository.ShelterRepository;
import com.mikhail.golovackii.pet_shelter.service.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelterServiceImpl implements ShelterService {

    @Autowired
    private ShelterRepository repository;

    @Override
    public void saveElem(Shelter elem) {
        repository.save(elem);
    }

    @Override
    public void updateElem(Shelter elem) {
        repository.save(elem);
    }

    @Override
    public Shelter getElemById(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<Shelter> getAllElements() {
        return repository.findAll();
    }

    @Override
    public void deleteElemById(Long id) {
        repository.deleteById(id);
    }
}
