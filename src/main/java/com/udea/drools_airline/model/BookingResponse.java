package com.udea.drools_airline.model;

public class BookingResponse {
    private String passengerName;
    private String flightNumber;
    private boolean upgradedToBusinessClass;
    private boolean priorityCheckIn;
    private double discountApplied;
    private boolean eligibleForUpgrade;
    private String assignedSeat;
    private double compensation;
    private int loyaltyPointsAdded;
    private boolean luggageAllowed;
    private boolean vipLoungeAccess;
    private String message;

    // Constructor vacío
    public BookingResponse() {
        this.eligibleForUpgrade = true;
        this.luggageAllowed = true;
    }

    // Constructor con parámetros
    public BookingResponse(String passengerName, String flightNumber) {
        this.passengerName = passengerName;
        this.flightNumber = flightNumber;
        this.eligibleForUpgrade = true;
        this.luggageAllowed = true;
    }

    // Getters y Setters
    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public boolean isUpgradedToBusinessClass() {
        return upgradedToBusinessClass;
    }

    public void setUpgradedToBusinessClass(boolean upgradedToBusinessClass) {
        this.upgradedToBusinessClass = upgradedToBusinessClass;
    }

    public boolean isPriorityCheckIn() {
        return priorityCheckIn;
    }

    public void setPriorityCheckIn(boolean priorityCheckIn) {
        this.priorityCheckIn = priorityCheckIn;
    }

    public double getDiscountApplied() {
        return discountApplied;
    }

    public void setDiscountApplied(double discountApplied) {
        this.discountApplied = discountApplied;
    }

    public boolean isEligibleForUpgrade() {
        return eligibleForUpgrade;
    }

    public void setEligibleForUpgrade(boolean eligibleForUpgrade) {
        this.eligibleForUpgrade = eligibleForUpgrade;
    }

    public String getAssignedSeat() {
        return assignedSeat;
    }

    public void setAssignedSeat(String assignedSeat) {
        this.assignedSeat = assignedSeat;
    }

    public double getCompensation() {
        return compensation;
    }

    public void setCompensation(double compensation) {
        this.compensation = compensation;
    }

    public int getLoyaltyPointsAdded() {
        return loyaltyPointsAdded;
    }

    public void setLoyaltyPointsAdded(int loyaltyPointsAdded) {
        this.loyaltyPointsAdded = loyaltyPointsAdded;
    }

    public boolean isLuggageAllowed() {
        return luggageAllowed;
    }

    public void setLuggageAllowed(boolean luggageAllowed) {
        this.luggageAllowed = luggageAllowed;
    }

    public boolean isVipLoungeAccess() {
        return vipLoungeAccess;
    }

    public void setVipLoungeAccess(boolean vipLoungeAccess) {
        this.vipLoungeAccess = vipLoungeAccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}