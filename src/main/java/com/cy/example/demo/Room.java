package com.cy.example.demo;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=2)
    private String address;

    @NotNull
    @Size(min=3)
    private String city;

    @NotNull
    @Size(min=1)
    private String state;

    @NotNull
    @Size(min=1)
    private String price;

    @NotNull
    @Size(min=1)
    private String description;

    @NotNull
    @Size(min=1)
    private String rules;


    private Boolean wifi;



    //@Value("none basic premium")
    private String cable;


    private Boolean privbath;



    private Boolean isRented;


    //private Boolean isRoomPublic;


    public Room() {
        isRented = Boolean.FALSE;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public String getCable() {
        return cable;
    }

    public void setCable(String cable) {
        this.cable = cable;
    }

    public Boolean getPrivbath() {
        return privbath;
    }

    public void setPrivbath(Boolean privbath) {
        this.privbath = privbath;
    }

    public Boolean getIsRented() {
        return isRented;
    }

    public void setIsRented(Boolean rented) {
        isRented = rented;
    }
}

