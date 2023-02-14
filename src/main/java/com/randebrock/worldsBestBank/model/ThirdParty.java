package com.randebrock.worldsBestBank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class ThirdParty {
    @Id
    private String hashedKey;
    private String name;

    public ThirdParty() {
    }

    public ThirdParty(String hashedKey, String name) {
        this.hashedKey = hashedKey;
        this.name = name;
    }

    public String getHashedKey() {
        return hashedKey;
    }
    public void setHashedKey(String hashedKey) {
        this.hashedKey = hashedKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}