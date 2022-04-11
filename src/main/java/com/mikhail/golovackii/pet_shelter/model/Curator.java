package com.mikhail.golovackii.pet_shelter.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity
@Table(name = "curator")
@Data
public class Curator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "date_birth", nullable = false)
    private LocalDate dateBirth;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "curator", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Pet> pets;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "phones_curator", joinColumns = @JoinColumn(name = "curator_id"),
            inverseJoinColumns = @JoinColumn(name = "phone_number_id"))
    private List<PhoneNumber> phones;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "shelter_curator", joinColumns = @JoinColumn(name = "curator_id"), inverseJoinColumns = @JoinColumn(name = "shelter_id"))
    private List<Shelter> shelters;

    public void addPet(Pet pet) {
        if (pets == null) {
            pets = new ArrayList<>();
        }
        pets.add(pet);
    }

    public void deletePet(Pet pet) {
        if (pets != null) {
            pets.remove(pet);
        }
    }

    public void addPhone(PhoneNumber number) {
        if (phones == null) {
            phones = new ArrayList<>();
        }
        phones.add(number);
    }

    public void deletePhone(PhoneNumber number) {
        if (phones != null) {
            phones.remove(number);
        }
    }

    public void addShelter(Shelter shelter) {
        if (shelters == null) {
            shelters = new ArrayList<>();
        }
        shelters.add(shelter);
    }

    public void deleteShelter(Shelter shelter) {
        if (shelters != null) {
            shelters.remove(shelter);
        }
    }
}
