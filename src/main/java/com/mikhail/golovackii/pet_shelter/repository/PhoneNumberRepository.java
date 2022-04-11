package com.mikhail.golovackii.pet_shelter.repository;

import com.mikhail.golovackii.pet_shelter.model.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {
}
