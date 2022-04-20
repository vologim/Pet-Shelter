package com.mikhail.golovackii.pet_shelter.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Component
@Entity
@Table(name = "pet")
@Data
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TypePet typePet;

    @Column(name = "address_photo")
    private String addressPhoto;

    @Column(name = "date_birth")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateBirth;

    @Column(name = "breed")
    @Enumerated(EnumType.STRING)
    private PetBreed breed;

    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(name = "color")
    private String color;

    @Column(name = "information")
    private String information;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "curator_id")
    private Curator curator;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;
}
