package com.mikhail.golovackii.pet_shelter.repository;

import com.mikhail.golovackii.pet_shelter.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
