package com.mikhail.golovackii.pet_shelter.repository;

import com.mikhail.golovackii.pet_shelter.model.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelterRepository extends JpaRepository<Shelter, Long> {

}
