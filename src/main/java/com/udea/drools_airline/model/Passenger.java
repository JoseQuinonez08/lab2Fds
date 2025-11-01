package com.udea.drools_airline.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Passenger {
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min=2, max=100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String name;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 0, message = "La edad debe ser positiva")
    private int age;

    @NotBlank(message = "El estatus de membresía es obligatorio")
    private String membershipStatus; // Basic, Gold, Platinum

    @NotNull(message = "El peso del equipaje es obligatorio")
    @Min(value = 0, message = "El peso del equipaje no puede ser negativo")
    private double luggageWeight;

    private String seatPreference; // Any, Window, Aisle, Family

    @NotNull(message = "Debe indicar si viaja con niños")
    private boolean travelingWithChildren;

    private int loyaltyPoints;

    // Constructor vacío
    public Passenger() {
        this.loyaltyPoints = 0;
    }

    // Constructor con parámetros
    public Passenger(String name, int age, String membershipStatus,
                     double luggageWeight, String seatPreference,
                     boolean travelingWithChildren) {
        this.name = name;
        this.age = age;
        this.membershipStatus = membershipStatus;
        this.luggageWeight = luggageWeight;
        this.seatPreference = seatPreference;
        this.travelingWithChildren = travelingWithChildren;
        this.loyaltyPoints = 0;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(String membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    public double getLuggageWeight() {
        return luggageWeight;
    }

    public void setLuggageWeight(double luggageWeight) {
        this.luggageWeight = luggageWeight;
    }

    public String getSeatPreference() {
        return seatPreference;
    }

    public void setSeatPreference(String seatPreference) {
        this.seatPreference = seatPreference;
    }

    public boolean isTravelingWithChildren() {
        return travelingWithChildren;
    }

    public void setTravelingWithChildren(boolean travelingWithChildren) {
        this.travelingWithChildren = travelingWithChildren;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
}
