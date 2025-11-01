package com.udea.drools_airline.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Flight {
    @NotBlank(message = "El número de vuelo es obligatorio")
    private String flightNumber;

    @NotNull(message = "La duración del vuelo es obligatoria")
    @Min(value = 0, message = "La duración no puede ser negativa")
    private int durationInHours;

    @NotNull(message = "El retraso debe ser especificado")
    @Min(value = 0, message = "El retraso no puede ser negativo")
    private int delayInMinutes;

    private boolean emergencyExitSeatAvailable;

    // Constructor vacío
    public Flight() {
        this.emergencyExitSeatAvailable = true;
    }

    // Constructor con parámetros
    public Flight(String flightNumber, int durationInHours, int delayInMinutes) {
        this.flightNumber = flightNumber;
        this.durationInHours = durationInHours;
        this.delayInMinutes = delayInMinutes;
        this.emergencyExitSeatAvailable = true;
    }

    // Getters y Setters
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getDurationInHours() {
        return durationInHours;
    }

    public void setDurationInHours(int durationInHours) {
        this.durationInHours = durationInHours;
    }

    public int getDelayInMinutes() {
        return delayInMinutes;
    }

    public void setDelayInMinutes(int delayInMinutes) {
        this.delayInMinutes = delayInMinutes;
    }

    public boolean isEmergencyExitSeatAvailable() {
        return emergencyExitSeatAvailable;
    }

    public void setEmergencyExitSeatAvailable(boolean emergencyExitSeatAvailable) {
        this.emergencyExitSeatAvailable = emergencyExitSeatAvailable;
    }
}