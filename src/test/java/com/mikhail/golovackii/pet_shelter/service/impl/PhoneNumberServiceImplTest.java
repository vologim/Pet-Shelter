package com.mikhail.golovackii.pet_shelter.service.impl;

import com.mikhail.golovackii.pet_shelter.model.PhoneNumber;
import com.mikhail.golovackii.pet_shelter.repository.PhoneNumberRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class PhoneNumberServiceImplTest {

    @Autowired
    private PhoneNumberServiceImpl phoneNumberService;

    @MockBean
    private PhoneNumberRepository phoneNumberRepository;

    @Test
    void saveElem() {
        phoneNumberService.saveElem(getPhoneNumber());

        Mockito.verify(phoneNumberRepository).save(getPhoneNumber());
    }

    @Test
    void updateElem() {
        phoneNumberService.updateElem(getPhoneNumber());

        Mockito.verify(phoneNumberRepository).save(getPhoneNumber());
    }

    @Test
    void getElemById() {
        Mockito.when(phoneNumberRepository.getById(12L)).thenReturn(getPhoneNumber());

        PhoneNumber number = phoneNumberService.getElemById(12L);

        Assert.assertEquals(getPhoneNumber().getId(), number.getId());
        Assert.assertEquals(getPhoneNumber().getPhoneNumber(), number.getPhoneNumber());
        Assert.assertNotNull(number);
    }

    @Test
    void getAllElements() {
        Mockito.when(phoneNumberRepository.findAll()).thenReturn(getPhonesNumbers());

        List<PhoneNumber> numbers = phoneNumberService.getAllElements();

        Assert.assertEquals(getPhonesNumbers().size(), numbers.size());
        Assert.assertEquals(getPhonesNumbers().get(1).getId(), numbers.get(1).getId());
    }

    @Test
    void deleteElemById() {
        phoneNumberService.deleteElemById(1L);

        Mockito.verify(phoneNumberRepository).deleteById(1L);
    }

    private PhoneNumber getPhoneNumber() {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setId(12L);
        phoneNumber.setPhoneNumber("222-22-22");

        return phoneNumber;
    }

    private List<PhoneNumber> getPhonesNumbers() {
        List<PhoneNumber> list = new ArrayList<>();

        PhoneNumber number = getPhoneNumber();

        for (long i = 0; i < 3; i++) {
            number.setId(i);
            list.add(number);
        }

        return list;
    }
}