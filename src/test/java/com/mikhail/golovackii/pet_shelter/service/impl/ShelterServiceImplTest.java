package com.mikhail.golovackii.pet_shelter.service.impl;

import com.mikhail.golovackii.pet_shelter.model.Shelter;
import com.mikhail.golovackii.pet_shelter.repository.ShelterRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShelterServiceImplTest {

    @Autowired
    private ShelterServiceImpl shelterService;

    @MockBean
    private ShelterRepository shelterRepository;

    @Test
    void saveElem() {
        shelterService.saveElem(getShelter());

        Mockito.verify(shelterRepository).save(getShelter());
    }

    @Test
    void updateElem() {
        shelterService.updateElem(getShelter());

        Mockito.verify(shelterRepository).save(getShelter());
    }

    @Test
    void getElemById() {
        Mockito.when(shelterRepository.getById(1L)).thenReturn(getShelter());

        Shelter shelter = shelterService.getElemById(1L);

        Assert.assertEquals(getShelter().getAddress(), shelter.getAddress());
        Assert.assertEquals(getShelter().getId(), shelter.getId());
        Assert.assertNotNull(shelter);
    }

    @Test
    void getAllElements() {
        Mockito.when(shelterRepository.findAll()).thenReturn(getShelters());

        List<Shelter> shelters = shelterService.getAllElements();

        Assert.assertEquals(getShelters().size(), shelters.size());
        Assert.assertEquals(getShelters().get(1).getName(), shelters.get(1).getName());
        Assert.assertNotNull(shelters);
    }

    @Test
    void deleteElemById() {
        shelterService.deleteElemById(1L);

        Mockito.verify(shelterRepository).deleteById(1L);
    }

    private Shelter getShelter() {
        Shelter shelter = new Shelter();
        shelter.setId(1L);
        shelter.setName("Test");
        shelter.setAddress("Test address");

        return shelter;
    }

    private List<Shelter> getShelters() {
        List<Shelter> shelters = new ArrayList<>();

        Shelter shelter = getShelter();

        for (long i = 0; i < 3; i++) {
            shelter.setId(i);
            shelters.add(shelter);
        }

        return shelters;
    }
}