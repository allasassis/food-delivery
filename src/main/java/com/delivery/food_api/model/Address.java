package com.delivery.food_api.model;


import com.delivery.food_api.dto.address.DataAddress;
import com.delivery.food_api.dto.address.DataUpdateAddress;
import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "address")
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

    public Address(String street, String complement, Integer number, String neighborhood, String city, String state, String country, String zipcode) {
        this.street = street;
        this.complement = complement;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
    }

    public Address(DataAddress address) {
        this.street = address.street();
        this.complement = address.complement();
        this.number = address.number();
        this.neighborhood = address.neighborhood();
        this.city = address.city();
        this.state = address.state();
        this.country = address.country();
        this.zipcode = address.zipcode();
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getStreet() {
        return street;
    }

    public String getComplement() {
        return complement;
    }

    public Integer getNumber() {
        return number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void update(DataUpdateAddress dto) {
        if (dto.street() != null) {
            this.street = dto.street();
        }
        if (dto.complement() != null) {
            this.complement = dto.complement();
        }
        if (dto.number() != null) {
            this.number = dto.number();
        }
        if (dto.neighborhood() != null) {
            this.neighborhood = dto.neighborhood();
        }
        if (dto.city() != null) {
            this.city = dto.city();
        }
        if (dto.state() != null) {
            this.state = dto.state();
        }
        if (dto.country() != null) {
            this.country = dto.country();
        }
        if (dto.zipcode() != null) {
            this.zipcode = dto.zipcode();
        }
    }
}
