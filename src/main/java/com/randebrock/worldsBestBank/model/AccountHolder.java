package com.randebrock.worldsBestBank.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

    @Entity
    @PrimaryKeyJoinColumn(name = "id")
    public class AccountHolder extends User {
    private Date dateOfBirth;
/*
@AttributeOverrides({
                @AttributeOverride(name = "streetName", column = @Column(name = "primary_address")),
                @AttributeOverride(name = "houseNumber", column = @Column(name = "primary_house_number")),
                @AttributeOverride(name = "appartmentNumber", column = @Column(name = "primary_appartment_number")),
                @AttributeOverride(name = "city", column = @Column(name = "primary_city")),
                @AttributeOverride(name = "country", column = @Column(name = "primary_country")),
                @AttributeOverride(name = "postCode", column = @Column(name = "primary_postCode"))
        })
        */
        @Embedded
    private Address primaryAddress;
        @AttributeOverrides({
                @AttributeOverride(name = "streetName", column = @Column(name = "secondary_address")),
                @AttributeOverride(name = "houseNumber", column = @Column(name = "secondary_house_number")),
                @AttributeOverride(name = "appartmentNumber", column = @Column(name = "secondary_appartment_number")),
                @AttributeOverride(name = "city", column = @Column(name = "secondary_city")),
                @AttributeOverride(name = "country", column = @Column(name = "secondary_country")),
                @AttributeOverride(name = "postCode", column = @Column(name = "secondary_postCode"))
        })
        @Embedded
    private Address secondaryAddress;


    public AccountHolder() {
    }

    public AccountHolder(String name, String username, String password, Date dateOfBirth, Address primaryAddress) {
        super(name, username, password);
        this.dateOfBirth = dateOfBirth;
        this.primaryAddress = primaryAddress;
    }

    public AccountHolder(String name, String username, String password, Date dateOfBirth, Address primaryAddress, Address secondaryAddress) {
        super(name, username, password);
        this.dateOfBirth = dateOfBirth;
        this.primaryAddress = primaryAddress;
        this.secondaryAddress = secondaryAddress;
    }

        public static AccountHolder findByOwnerIdAndAccountId(AccountHolder sendingAccount) {
            return sendingAccount;
        }

        public static AccountHolder findByAccountId(AccountHolder receivingAccount) {
            return receivingAccount;
        }

        public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public Address getSecondaryAddress() {
        return secondaryAddress;
    }

    public void setSecondaryAddress(Address secondaryAddress) {
        this.secondaryAddress = secondaryAddress;
    }

        public BigDecimal getBalance() {
            return null;
        }

        public void setBalance(BigDecimal subtract) {
        }
    }
