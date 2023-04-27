package com.delivery.food_api.model;


import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Customer customer;

    private String street;
    private String complement;
    private Integer number;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
    private String zipcode;

    public Address() {
    }

    public Address(Long id, Customer customer, String street, String complement, Integer number, String neighborhood, String city, String state, String country, String zipcode) {
        this.id = id;
        this.customer = customer;
        this.street = street;
        this.complement = complement;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
    }
}
