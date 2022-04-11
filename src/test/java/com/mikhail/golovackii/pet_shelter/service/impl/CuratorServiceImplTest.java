package com.mikhail.golovackii.pet_shelter.service.impl;

import com.mikhail.golovackii.pet_shelter.model.Curator;
import com.mikhail.golovackii.pet_shelter.repository.CuratorRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
public class CuratorServiceImplTest {

    @Autowired
    private CuratorServiceImpl curatorService;

    @MockBean
    private CuratorRepository curatorRepository;

    @Test
    public void saveElem() {
        curatorService.saveElem(getCurator());

        Mockito.verify(curatorRepository).save(getCurator());
    }

    @Test
    public void updateElem() {
        curatorService.updateElem(getCurator());

        Mockito.verify(curatorRepository).save(getCurator());
    }

    @Test
    public void getElemById() {
        Mockito.when(curatorRepository.getById(12L)).thenReturn(getCurator());

        Curator curator = curatorService.getElemById(12L);

        Assert.assertEquals(getCurator().getId(), curator.getId());
        Assert.assertEquals(getCurator().getAddress(), curator.getAddress());
        Assert.assertEquals(getCurator().getDateBirth(), curator.getDateBirth());
        Assert.assertNotNull(curator);
    }

    @Test
    public void getAllElements() {
        Mockito.when((curatorRepository.findAll())).thenReturn(getCurators());

        List<Curator> curators = curatorService.getAllElements();

        Assert.assertEquals(getCurators().size(), curators.size());
        Assert.assertEquals(getCurators().get(1).getId(), curators.get(1).getId());
    }

    @Test
    public void deleteElemById() {
        curatorService.deleteElemById(1L);

        Mockito.verify(curatorRepository).deleteById(1L);
    }

    private Curator getCurator() {
        Curator curator = new Curator();
        curator.setId(12L);
        curator.setFirstName("Test");
        curator.setLastName("Test last name");
        curator.setPatronymic("Test patronymic");
        curator.setDateBirth(LocalDate.now());
        curator.setAddress("Test Address");

        return curator;
    }

    private List<Curator> getCurators() {
        List<Curator> curators = new ArrayList<>();

        Curator curator = getCurator();

        for (long i = 0; i < 3; i++) {
            curator.setId(i);
            curators.add(curator);
        }

        return curators;
    }
}