package com.mikhail.golovackii.pet_shelter.service.impl;

import com.mikhail.golovackii.pet_shelter.model.Curator;
import com.mikhail.golovackii.pet_shelter.repository.CuratorRepository;
import com.mikhail.golovackii.pet_shelter.service.CuratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuratorServiceImpl implements CuratorService {

    @Autowired
    private CuratorRepository curatorRepository;

    @Override
    public void saveElem(Curator elem) {
        curatorRepository.save(elem);
    }

    @Override
    public void updateElem(Curator elem) {
        curatorRepository.save(elem);
    }

    @Override
    public Curator getElemById(Long id) {
        return curatorRepository.getById(id);
    }

    @Override
    public List<Curator> getAllElements() {
        return curatorRepository.findAll();
    }

    @Override
    public void deleteElemById(Long id) {
        curatorRepository.deleteById(id);
    }
}
