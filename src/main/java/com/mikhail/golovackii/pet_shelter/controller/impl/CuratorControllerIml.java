package com.mikhail.golovackii.pet_shelter.controller.impl;

import com.mikhail.golovackii.pet_shelter.controller.CuratorController;
import com.mikhail.golovackii.pet_shelter.model.Curator;
import com.mikhail.golovackii.pet_shelter.service.CuratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curators")
public class CuratorControllerIml implements CuratorController {

    @Autowired
    private CuratorService curatorService;

    @Override
    @PostMapping
    public void saveElem(@RequestBody Curator elem) {
        curatorService.saveElem(elem);
    }

    @Override
    @PutMapping
    public void updateElem(@RequestBody Curator elem) {
        curatorService.saveElem(elem);
    }

    @Override
    @GetMapping("/{id}")
    public Curator getElemById(@PathVariable Long id) {
        return curatorService.getElemById(id);
    }

    @Override
    @GetMapping
    public List<Curator> getAllElements() {
        return curatorService.getAllElements();
    }

    @Override
    @DeleteMapping
    public void deleteElemById(@PathVariable Long id) {
        curatorService.deleteElemById(id);
    }
}