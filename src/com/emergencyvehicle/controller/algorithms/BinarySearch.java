package com.emergencyvehicle.controller.algorithms;

import com.emergencyvehicle.model.EmergencyVehicle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Prayash Rawal LMU ID: 23056551
 */
public class BinarySearch {

    /**
     * Searches for EmergencyVehicle objects by their type using binary search.
     *
     * @param searchValue the vehicle type to search for
     * @param vehicleList the list of EmergencyVehicle objects to search within
     * @param left the left index of the search range
     * @param right the right index of the search range
     * @return a list of EmergencyVehicle objects that match the search value
     */
    public List<EmergencyVehicle> searchByType(String searchValue, List<EmergencyVehicle> vehicleList, int left, int right) {
        List<EmergencyVehicle> results = new ArrayList<>();
        if (left > right) {
            return results; // Base case: no more elements to search
        }

        int mid = (left + right) / 2;
        String midVehicleType = vehicleList.get(mid).getVehicleType();
        int cmp = searchValue.compareToIgnoreCase(midVehicleType);

        System.out.println("Searching for: " + searchValue + " at index: " + mid + " with vehicle type: " + midVehicleType);

        if (cmp == 0) {
            results.add(vehicleList.get(mid));
            results.addAll(searchByType(searchValue, vehicleList, left, mid - 1)); // Search left
            results.addAll(searchByType(searchValue, vehicleList, mid + 1, right)); // Search right
        } else if (cmp < 0) {
            return searchByType(searchValue, vehicleList, left, mid - 1); // Search left
        } else {
            return searchByType(searchValue, vehicleList, mid + 1, right); // Search right
        }

        return removeDuplicates(results); // Remove duplicates from the results
    }

    /**
     * Searches for EmergencyVehicle objects by their current location using
     * binary search.
     *
     * @param searchValue the location to search for
     * @param vehicleList the list of EmergencyVehicle objects to search within
     * @param left the left index of the search range
     * @param right the right index of the search range
     * @return a list of EmergencyVehicle objects that match the search value
     */
    public List<EmergencyVehicle> searchByLocation(String searchValue, List<EmergencyVehicle> vehicleList, int left, int right) {
        List<EmergencyVehicle> results = new ArrayList<>();
        if (left > right) {
            return results; // Base case: no more elements to search
        }

        int mid = (left + right) / 2;
        String midLocation = vehicleList.get(mid).getCurrentLocation();
        int cmp = searchValue.compareToIgnoreCase(midLocation);

        System.out.println("Searching for: " + searchValue + " at index: " + mid + " with location: " + midLocation);

        if (cmp == 0) {
            results.add(vehicleList.get(mid));
            results.addAll(searchByLocation(searchValue, vehicleList, left, mid - 1)); // Search left
            results.addAll(searchByLocation(searchValue, vehicleList, mid + 1, right)); // Search right
        } else if (cmp < 0) {
            return searchByLocation(searchValue, vehicleList, left, mid - 1); // Search left
        } else {
            return searchByLocation(searchValue, vehicleList, mid + 1, right); // Search right
        }

        return removeDuplicates(results); // Remove duplicates from the results
    }

    /**
     * Removes duplicate EmergencyVehicle objects from the results based on
     * their serial numbers.
     *
     * @param results the list of EmergencyVehicle objects to filter for
     * duplicates
     * @return a list of unique EmergencyVehicle objects
     */
    private List<EmergencyVehicle> removeDuplicates(List<EmergencyVehicle> results) {
        Set<Integer> seen = new HashSet<>(); // Use a Set to track seen serial numbers
        List<EmergencyVehicle> uniqueResults = new ArrayList<>();
        for (EmergencyVehicle vehicle : results) {
            if (seen.add(vehicle.getSerialNumber())) { // Use serial number to check for duplicates
                uniqueResults.add(vehicle);
            }
        }
        return uniqueResults; // Return the list of unique EmergencyVehicle objects
    }
}
