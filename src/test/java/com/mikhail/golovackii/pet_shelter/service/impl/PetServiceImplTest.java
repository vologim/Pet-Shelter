package com.mikhail.golovackii.pet_shelter.service.impl;

import com.mikhail.golovackii.pet_shelter.model.Pet;
import com.mikhail.golovackii.pet_shelter.model.PetBreed;
import com.mikhail.golovackii.pet_shelter.model.Sex;
import com.mikhail.golovackii.pet_shelter.model.TypePet;
import com.mikhail.golovackii.pet_shelter.repository.PetRepository;
import com.mikhail.golovackii.pet_shelter.service.PetService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
public class PetServiceImplTest {

    @Autowired
    private PetService petService;

    @MockBean
    private PetRepository petRepository;

    @Test
    public void saveElem() {
        petService.saveElem(getPet());

        Mockito.verify(petRepository).save(getPet());
    }

    @Test
    public void updateElem() {
        petService.updateElem(getPet());

        Mockito.verify(petRepository).save(getPet());
    }

    @Test
    public void getElemById() {
        Mockito.when(petRepository.getById(12L)).thenReturn(getPet());

        Pet pet = petService.getElemById(12L);

        Assert.assertEquals(getPet().getId(), pet.getId());
        Assert.assertEquals(getPet().getBreed(), pet.getBreed());
        Assert.assertNotNull(pet);
    }

    @Test
    public void getAllElements() {
        Mockito.when(petRepository.findAll()).thenReturn(getPets());

        List<Pet> pets = petService.getAllElements();

        Assert.assertEquals(getPets().size(), pets.size());
        Assert.assertEquals(getPets().get(1).getInformation(), pets.get(1).getInformation());
        Assert.assertNotNull(pets);
    }

    @Test
    public void deleteElemById() {
        petService.deleteElemById(1L);

        Mockito.verify(petRepository).deleteById(1L);
    }

    private Pet getPet() {
        Pet pet = new Pet();
        pet.setId(12L);
        pet.setTypePet(TypePet.DOG);
        pet.setAddressPhoto("Address photo");
        pet.setDateBirth(LocalDate.now());
        pet.setBreed(PetBreed.BULLDOG);
        pet.setSex(Sex.M);
        pet.setColor("Brown");
        pet.setInformation("Test information");

        return pet;
    }

    private List<Pet> getPets() {
        List<Pet> pets = new ArrayList<>();

        Pet pet = getPet();

        for (long i = 0; i < 3; i++) {
            pet.setId(i);
            pets.add(pet);
        }

        return pets;
    }
}