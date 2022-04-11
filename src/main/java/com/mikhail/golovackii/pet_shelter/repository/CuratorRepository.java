package com.mikhail.golovackii.pet_shelter.repository;

import com.mikhail.golovackii.pet_shelter.model.Curator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuratorRepository extends JpaRepository<Curator, Long> {
}
