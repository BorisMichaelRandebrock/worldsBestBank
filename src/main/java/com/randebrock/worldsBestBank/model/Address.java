package com.randebrock.worldsBestBank.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String streetName;
    private Integer houseNumber;
    private String appartmentNumber;
    private String city;
    private Integer postCode;
    private String country;

    public Address() {
    }



    public Address(String streetName, Integer houseNumber, String appartmentNumber, String city, Integer postCode, String country) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.appartmentNumber = appartmentNumber;
        this.city = city;
        this.postCode = postCode;
        this.country = country;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getAppartmentNumber() {
        return appartmentNumber;
    }

    public void setAppartmentNumber(String appartmentNumber) {
        this.appartmentNumber = appartmentNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
