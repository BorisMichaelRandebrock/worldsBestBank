package com.randebrock.worldsBestBank.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String streetName;
    private int houseNumber;
    private String appartmentNumber;
    private String city;
    private int postCode;
    private String country;

    public Address() {
    }



    public Address(String streetName, int houseNumber, String appartmentNumber, String city, int postCode, String country) {
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

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
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

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
