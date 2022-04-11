package com.mikhail.golovackii.pet_shelter.controller.impl;

import com.mikhail.golovackii.pet_shelter.controller.PetController;
import com.mikhail.golovackii.pet_shelter.model.Pet;
import com.mikhail.golovackii.pet_shelter.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetControllerImpl implements PetController {

    @Autowired
    private PetService petService;

    @Override
    @PostMapping
    public void saveElem(@RequestBody Pet elem) {
        petService.saveElem(elem);
    }

    @Override
    @PutMapping
    public void updateElem(@RequestBody Pet elem) {
        petService.saveElem(elem);
    }

    @Override
    @GetMapping("/{id}")
    public Pet getElemById(@PathVariable Long id) {
        return petService.getElemById(id);
    }

    @Override
    @GetMapping
    public List<Pet> getAllElements() {
        return petService.getAllElements();
    }

    @Override
    @DeleteMapping
    public void deleteElemById(@PathVariable Long id) {
        petService.deleteElemById(id);
    }
}
