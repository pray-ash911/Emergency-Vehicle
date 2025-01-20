package com.emergencyvehicle.controller.datastructure;

import com.emergencyvehicle.model.EmergencyVehicle;
import com.emergencyvehicle.controller.algorithms.MergeSort;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Prayash Rawal 
 * LMU ID: 23056551
 */
/**
 * * VehicleManager class for managing emergency vehicles, dispatch records,
 * dispatched vehicles, and service requests.
 */
public class VehicleManager {

    // Data structures for managing emergency vehicles
    private static ArrayList<EmergencyVehicle> emergencyVehicles = new ArrayList<>();
    private static LinkedList<String> dispatchRecords = new LinkedList<>();
    private static Stack<EmergencyVehicle> dispatchedVehicles = new Stack<>();
    private static Queue<String> serviceRequests = new LinkedList<>();

    static {
        // Pre-populate with 5 vehicles
        emergencyVehicles.add(new EmergencyVehicle(1, "A100", "Ambulance Model X", "Ambulance", "Available", "Manamaiju", 5000, false));
        emergencyVehicles.add(new EmergencyVehicle(2, "A150", "Ambulance Model A", "Ambulance", "Unavailable", "Kamalpokhari", 7500, true));
        emergencyVehicles.add(new EmergencyVehicle(3, "F250", "Fire Truck Model B ", "Fire Truck", "Available", "Baneshwor", 3000, false));
        emergencyVehicles.add(new EmergencyVehicle(4, "P350", "Police Car Model Z", "Police Car", "Available", "Ratnapark", 5200, true));
        emergencyVehicles.add(new EmergencyVehicle(5, "P300", "Police Car Model Z", "Police Car", "Unavailable", "Thamel", 8000, false));
    }

    /**
     * Getter for emergency vehicles
     *
     * @return the list of emergency vehicles
     */
    public static ArrayList<EmergencyVehicle> getEmergencyVehicles() {
        return emergencyVehicles;
    }

    /**
     * Setter for emergency vehicles
     *
     * @param updatedList the updated list of emergency vehicles
     */
    public static void setEmergencyVehicles(ArrayList<EmergencyVehicle> updatedList) {
        emergencyVehicles = updatedList;
    }

    /**
     * Method to add a vehicle
     *
     * @param vehicle the emergency vehicle to be added
     */
    public static void addVehicle(EmergencyVehicle vehicle) {
        emergencyVehicles.add(vehicle);
        // Sort the list by vehicle type after adding a new vehicle
        emergencyVehicles = new ArrayList<>(MergeSort.sortByType(emergencyVehicles, false));
        // Update the emergencyVehicles list
        setEmergencyVehicles(emergencyVehicles);
    }

    /**
     * Method to delete a vehicle by serial number
     *
     * @param serialNumber the serial number of the vehicle to be deleted
     * @return true if the vehicle was found and removed, false otherwise
     */
    public static boolean deleteVehicle(int serialNumber) {
        return emergencyVehicles.removeIf(vehicle -> vehicle.getSerialNumber() == serialNumber);
    }

    /**
     * Method to update an existing vehicle's details
     *
     * @param updatedVehicle the emergency vehicle with updated details
     * @return true if the vehicle was found and updated, false otherwise
     */
    public static boolean updateVehicle(EmergencyVehicle updatedVehicle) {
        for (int i = 0; i < emergencyVehicles.size(); i++) {
            if (emergencyVehicles.get(i).getSerialNumber() == updatedVehicle.getSerialNumber()) {
                emergencyVehicles.set(i, updatedVehicle);
                return true;
            }
        }
        return false; // Vehicle not found
    }

    /**
     * Method to find a vehicle by serial number
     *
     * @param serialNumber the serial number of the vehicle to be found
     * @return the emergency vehicle with the specified serial number, or null
     * if not found
     */
    public static EmergencyVehicle findVehicleBySerialNumber(int serialNumber) {
        for (EmergencyVehicle vehicle : emergencyVehicles) {
            if (vehicle.getSerialNumber() == serialNumber) {
                return vehicle;
            }
        }
        return null; // Vehicle not found
    }

    /**
     * Method to find vehicles by name (case-insensitive)
     *
     * @param vehicleName the name of the vehicle to be found
     * @return the list of matching emergency vehicles
     */
    public static ArrayList<EmergencyVehicle> findVehicleByName(String vehicleName) {
        ArrayList<EmergencyVehicle> matchingVehicles = new ArrayList<>();
        for (EmergencyVehicle vehicle : emergencyVehicles) {
            if (vehicle.getEmergencyVehicleName().equalsIgnoreCase(vehicleName)) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    /**
     * Method to add dispatch record
     *
     * @param record the dispatch record to be added
     */
    public static void addDispatchRecord(String record) {
        dispatchRecords.add(record);
    }

    /**
     * Method to dispatch a vehicle
     *
     * @param vehicle the emergency vehicle to be dispatched
     */
    public static void dispatchVehicle(EmergencyVehicle vehicle) {
        dispatchedVehicles.push(vehicle);
    }

    /**
     * Method to add a service request
     *
     * @param request the service request to be added
     */
    public static void addServiceRequest(String request) {
        serviceRequests.add(request);
    }
}
