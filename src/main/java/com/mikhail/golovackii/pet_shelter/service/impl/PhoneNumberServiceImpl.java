package com.mikhail.golovackii.pet_shelter.service.impl;

import com.mikhail.golovackii.pet_shelter.model.PhoneNumber;
import com.mikhail.golovackii.pet_shelter.repository.PhoneNumberRepository;
import com.mikhail.golovackii.pet_shelter.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @Override
    public void saveElem(PhoneNumber elem) {
        phoneNumberRepository.save(elem);
    }

    @Override
    public void updateElem(PhoneNumber elem) {
        phoneNumberRepository.save(elem);
    }

    @Override
    public PhoneNumber getElemById(Long id) {
        return phoneNumberRepository.getById(id);
    }

    @Override
    public List<PhoneNumber> getAllElements() {
        return phoneNumberRepository.findAll();
    }

    @Override
    public void deleteElemById(Long id) {
        phoneNumberRepository.deleteById(id);
    }
}
