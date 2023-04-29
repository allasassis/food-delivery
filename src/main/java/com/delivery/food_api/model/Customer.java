package com.delivery.food_api.model;

import com.delivery.food_api.dto.customer.DataInsertCustomer;
import com.delivery.food_api.dto.customer.DataUpdateCustomer;
import jakarta.persistence.*;

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
    @JoinColumn(name = "address_id")
    private Address address;

    private LocalDate birthDate;

    private final LocalDate creationDate = LocalDate.now();

    public Customer() {
    }

    public Customer(Long id, String name, String lastName, String email, String cellphone, Address address, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.cellphone = cellphone;
        this.address = address;
        this.birthDate = birthDate;
    }

    public Customer(DataInsertCustomer dto) {
        this.name = dto.name();
        this.lastName = dto.lastName();
        this.email = dto.email();
        this.cellphone = dto.cellphone();
        this.birthDate = dto.birthDate();
        this.address = new Address(dto.address());
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

    public void setAddress(Address address) {
        this.address = address;
    }

    public void update(DataUpdateCustomer dto) {
        if (dto.name() != null) {
            this.name = dto.name();
        }
        if (dto.lastName() != null) {
            this.lastName = dto.lastName();
        }
        if (dto.email() != null) {
            this.email = dto.email();
        }
        if (dto.cellphone() != null) {
            this.cellphone = dto.cellphone();
        }
        if (dto.birthDate() != null) {
            this.birthDate = dto.birthDate();
        }
        if (dto.address() != null) {
            this.address.update(dto.address());
        }
    }
}
