package com.mikhail.golovackii.pet_shelter.controllers.controller.impl;

import com.mikhail.golovackii.pet_shelter.controllers.controller.CuratorController;
import com.mikhail.golovackii.pet_shelter.model.Curator;
import com.mikhail.golovackii.pet_shelter.service.CuratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/curator")
public class CuratorControllerImpl implements CuratorController {

    @Autowired
    private CuratorService curatorService;

}
