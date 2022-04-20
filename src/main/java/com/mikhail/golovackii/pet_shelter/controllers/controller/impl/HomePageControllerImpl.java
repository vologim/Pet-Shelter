package com.mikhail.golovackii.pet_shelter.controllers.controller.impl;

import com.mikhail.golovackii.pet_shelter.controllers.controller.HomePageController;
import com.mikhail.golovackii.pet_shelter.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomePageControllerImpl implements HomePageController {

    private final PetService petService;

    @Autowired
    public HomePageControllerImpl(PetService petService) {
        this.petService = petService;
    }

    @Override
    @GetMapping
    public String showMainPage(Model model) {

        model.addAttribute("numberPets", petService.getQuantityPets());

        return "home-page";
    }
}
