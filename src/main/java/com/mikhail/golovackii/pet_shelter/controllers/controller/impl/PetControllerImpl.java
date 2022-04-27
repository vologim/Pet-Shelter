package com.mikhail.golovackii.pet_shelter.controllers.controller.impl;

import com.mikhail.golovackii.pet_shelter.controllers.controller.PetController;
import com.mikhail.golovackii.pet_shelter.model.Pet;
import com.mikhail.golovackii.pet_shelter.service.CuratorService;
import com.mikhail.golovackii.pet_shelter.service.PetService;
import com.mikhail.golovackii.pet_shelter.service.ShelterService;
import com.mikhail.golovackii.pet_shelter.utils.FileProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/pet")
public class PetControllerImpl implements PetController {

    private final PetService petService;
    private final CuratorService curatorService;
    private final ShelterService shelterService;
    private final FileProcessing fileProcessing;

    @Autowired
    public PetControllerImpl(PetService petService, CuratorService curatorService,
                             ShelterService shelterService, FileProcessing fileProcessing) {
        this.petService = petService;
        this.curatorService = curatorService;
        this.shelterService = shelterService;
        this.fileProcessing = fileProcessing;
    }

    @GetMapping("/new")
    public String newPet(Model model) {
        model.addAttribute("newPet", new Pet());
        model.addAttribute("curators", curatorService.getAllElements());
        model.addAttribute("shelters", shelterService.getAllElements());

        return "pet/new-pet";
    }

    @PostMapping
    public String createPet(@ModelAttribute("pet") Pet pet,
                            @RequestParam("files") MultipartFile file) throws IOException {

        String a = fileProcessing.saveFile(file, Pet.class.getSimpleName(), pet.getName());
        pet.setAddressPhoto(a);

        petService.saveElem(pet);

        return "redirect:/home-page";
    }

}
