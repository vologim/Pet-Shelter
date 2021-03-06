package com.mikhail.golovackii.pet_shelter.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
@Entity
@Table(name = "shelter")
public class Shelter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            mappedBy = "shelter")
    private List<Pet> pets;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "phones_shelter", joinColumns = @JoinColumn(name = "shelter_id"),
            inverseJoinColumns = @JoinColumn(name = "phone_number_id"))
    private List<PhoneNumber> phones;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "shelter_curator", joinColumns = @JoinColumn(name = "shelter_id"), inverseJoinColumns = @JoinColumn(name = "curator_id"))
    private List<Curator> curators;

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

    public void addCurator(Curator curator) {
        if (curators == null) {
            curators = new ArrayList<>();
        }
        curators.add(curator);
    }

    public void deleteCurator(Curator curator) {
        if (curators != null) {
            curators.remove(curator);
        }
    }
}
