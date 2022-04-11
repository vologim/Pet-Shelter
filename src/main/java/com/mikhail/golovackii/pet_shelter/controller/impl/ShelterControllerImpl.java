package com.mikhail.golovackii.pet_shelter.controller.impl;

import com.mikhail.golovackii.pet_shelter.controller.ShelterController;
import com.mikhail.golovackii.pet_shelter.model.Shelter;
import com.mikhail.golovackii.pet_shelter.service.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shelters")
public class ShelterControllerImpl implements ShelterController {

    @Autowired
    private ShelterService shelterService;

    @Override
    @GetMapping("/{id}")
    public Shelter getElemById(@PathVariable Long id) {
        return shelterService.getElemById(id);
    }

    @Override
    @GetMapping
    public List<Shelter> getAllElements() {
        return shelterService.getAllElements();
    }

    @Override
    @PostMapping
    public void saveElem(@RequestBody Shelter elem) {
        shelterService.saveElem(elem);
    }

    @Override
    @PutMapping
    public void updateElem(@RequestBody Shelter elem) {
        shelterService.updateElem(elem);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteElemById(@PathVariable Long id) {
        shelterService.deleteElemById(id);
    }


}
