package com.udea.drools_airline.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class BookingRequest {
    @NotNull(message = "El pasajero es obligatorio")
    @Valid
    private Passenger passenger;

    @NotNull(message = "El vuelo es obligatorio")
    @Valid
    private Flight flight;

    // Constructor vacío
    public BookingRequest() {}

    // Constructor con parámetros
    public BookingRequest(Passenger passenger, Flight flight) {
        this.passenger = passenger;
        this.flight = flight;
    }

    // Getters y Setters
    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}