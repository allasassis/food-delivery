package com.delivery.food_api.model;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    private String email;
    private String cellphone;
    @OneToOne
    private Address address;
    private LocalDate birthDate;

    private LocalDate creationDate;

    public Customer() {
    }

    public Customer(Long id, String name, String lastName, String email, String cellphone, Address address, LocalDate birthDate, LocalDate creationDate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.cellphone = cellphone;
        this.address = address;
        this.birthDate = birthDate;
        this.creationDate = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public Address getAddress() {
        return address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}
