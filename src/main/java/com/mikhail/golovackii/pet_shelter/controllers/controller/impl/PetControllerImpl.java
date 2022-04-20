package com.mikhail.golovackii.pet_shelter.controllers.controller.impl;

import com.mikhail.golovackii.pet_shelter.controllers.controller.PetController;
import com.mikhail.golovackii.pet_shelter.model.Pet;
import com.mikhail.golovackii.pet_shelter.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pet")
public class PetControllerImpl implements PetController {

    private final PetService petService;

    @Autowired
    public PetControllerImpl(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/new")
    public String newPet(Model model) {
        model.addAttribute("newPet", new Pet());

        return "pet/new-pet";
    }

    @PostMapping
    public String createPet(@ModelAttribute("pet") Pet pet) {

        petService.saveElem(pet);

        return "redirect:/home-page";
    }

}
