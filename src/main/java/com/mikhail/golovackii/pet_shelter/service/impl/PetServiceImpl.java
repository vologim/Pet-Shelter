package com.mikhail.golovackii.pet_shelter.service.impl;

import com.mikhail.golovackii.pet_shelter.model.Pet;
import com.mikhail.golovackii.pet_shelter.repository.PetRepository;
import com.mikhail.golovackii.pet_shelter.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Override
    public void saveElem(Pet elem) {
        petRepository.save(elem);
    }

    @Override
    public void updateElem(Pet elem) {
        petRepository.save(elem);
    }

    @Override
    public Pet getElemById(Long id) {
        return petRepository.getById(id);
    }

    @Override
    public List<Pet> getAllElements() {
        return petRepository.findAll();
    }

    @Override
    public void deleteElemById(Long id) {
        petRepository.deleteById(id);
    }
}
