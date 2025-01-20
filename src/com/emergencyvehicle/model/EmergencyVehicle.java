package com.emergencyvehicle.model;

/**
 * * Prayash Rawal 
 *   LMU ID: 23056551
 */
public class EmergencyVehicle {

    private int serialNumber;
    private String modelNumber;
    private String emergencyVehicleName;
    private String vehicleType;
    private String availabilityStatus;
    private String currentLocation;
    private int price;

    private boolean isDispatched; // Indicates if the vehicle is dispatched
    private boolean hasServiceRequest; // Indicates if there's a pending service request

    // Constructor
    public EmergencyVehicle(int serialNumber, String modelNumber, String emergencyVehicleName, String vehicleType, String availabilityStatus, String currentLocation, int price, boolean isDispatched) {
        this.serialNumber = serialNumber;
        this.modelNumber = modelNumber;
        this.emergencyVehicleName = emergencyVehicleName;
        this.vehicleType = vehicleType;
        this.availabilityStatus = availabilityStatus;
        this.currentLocation = currentLocation;
        this.price = price;
        this.isDispatched = isDispatched;  // Set dispatch status in constructor
        this.hasServiceRequest = false;  // Initially, no service request
    }

    // Getters and Setters
    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getEmergencyVehicleName() {
        return emergencyVehicleName;
    }

    public void setEmergencyVehicleName(String emergencyVehicleName) {
        this.emergencyVehicleName = emergencyVehicleName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isDispatched() {
        return isDispatched;
    }

    public void setDispatched(boolean dispatched) {
        isDispatched = dispatched;
    }

    public boolean hasServiceRequest() {
        return hasServiceRequest;
    }

    public void setServiceRequest(boolean serviceRequest) {
        hasServiceRequest = serviceRequest;
    }

    // Methods for Dispatch and Service Request Handling
    public void dispatchVehicle() {
        if (!isDispatched) {
            isDispatched = true;
            // Set availability status to 'Unavailable' when dispatched
            setAvailabilityStatus("Unavailable");
        }
    }

    public void returnVehicleFromDispatch() {
        if (isDispatched) {
            isDispatched = false;
            // Set availability status back to 'Available' when the vehicle returns
            setAvailabilityStatus("Available");
        }
    }

    public void createServiceRequest() {
        if (!hasServiceRequest) {
            hasServiceRequest = true;
        }
    }

    public void completeServiceRequest() {
        if (hasServiceRequest) {
            hasServiceRequest = false;
        }
    }

    // Override toString for display
    @Override
    public String toString() {
        return "EmergencyVehicle{"
                + "serialNumber=" + serialNumber
                + ", emergencyVehicleName='" + emergencyVehicleName + '\''
                + ", modelNumber='" + modelNumber + '\''
                + ", vehicleType='" + vehicleType + '\''
                + ", availabilityStatus='" + availabilityStatus + '\''
                + ", currentLocation='" + currentLocation + '\''
                + ", price=" + price
                + ", isDispatched=" + isDispatched
                + ", hasServiceRequest=" + hasServiceRequest
                + '}';
    }
}
