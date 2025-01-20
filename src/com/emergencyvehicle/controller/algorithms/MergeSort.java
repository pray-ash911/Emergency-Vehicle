package com.emergencyvehicle.controller.algorithms;

import com.emergencyvehicle.model.EmergencyVehicle;
import java.util.ArrayList;
import java.util.List;

/**
 * Prayash Rawal LMU ID: 23056551
 */
public class MergeSort {

    /**
     * Sorts a list of EmergencyVehicle objects by their type in ascending or
     * descending order.
     *
     * @param vehicleList the list of EmergencyVehicle objects to be sorted
     * @param descending specifies the sort order (true for descending, false
     * for ascending)
     * @return the sorted list of EmergencyVehicle objects
     */
    public static List<EmergencyVehicle> sortByType(List<EmergencyVehicle> vehicleList, boolean descending) {
        if (vehicleList.size() <= 1) {
            return vehicleList; // No need to sort if the list has 0 or 1 element
        }

        int mid = vehicleList.size() / 2;
        List<EmergencyVehicle> left = new ArrayList<>(vehicleList.subList(0, mid));
        List<EmergencyVehicle> right = new ArrayList<>(vehicleList.subList(mid, vehicleList.size()));

        left = sortByType(left, descending);
        right = sortByType(right, descending);

        return mergeByType(left, right, descending);
    }

    /**
     * Merges two sorted lists of EmergencyVehicle objects by their type.
     *
     * @param left the left sorted list
     * @param right the right sorted list
     * @param descending specifies the sort order (true for descending, false
     * for ascending)
     * @return the merged sorted list of EmergencyVehicle objects
     */
    private static List<EmergencyVehicle> mergeByType(List<EmergencyVehicle> left, List<EmergencyVehicle> right, boolean descending) {
        List<EmergencyVehicle> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            String leftType = left.get(i).getVehicleType();
            String rightType = right.get(j).getVehicleType();

            int comparison = descending ? rightType.compareToIgnoreCase(leftType) : leftType.compareToIgnoreCase(rightType);

            if (comparison <= 0) {
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }

        // Add remaining elements from left and right lists
        while (i < left.size()) {
            merged.add(left.get(i++));
        }
        while (j < right.size()) {
            merged.add(right.get(j++));
        }

        return merged;
    }

    /**
     * Sorts a list of EmergencyVehicle objects by their current location in
     * ascending or descending order.
     *
     * @param vehicleList the list of EmergencyVehicle objects to be sorted
     * @param descending specifies the sort order (true for descending, false
     * for ascending)
     * @return the sorted list of EmergencyVehicle objects
     */
    public static List<EmergencyVehicle> sortByLocation(List<EmergencyVehicle> vehicleList, boolean descending) {
        if (vehicleList.size() <= 1) {
            return vehicleList; // No need to sort if the list has 0 or 1 element
        }

        int mid = vehicleList.size() / 2;
        List<EmergencyVehicle> left = new ArrayList<>(vehicleList.subList(0, mid));
        List<EmergencyVehicle> right = new ArrayList<>(vehicleList.subList(mid, vehicleList.size()));

        left = sortByLocation(left, descending);
        right = sortByLocation(right, descending);

        return mergeByLocation(left, right, descending);
    }

    /**
     * Merges two sorted lists of EmergencyVehicle objects by their current
     * location.
     *
     * @param left the left sorted list
     * @param right the right sorted list
     * @param descending specifies the sort order (true for descending, false
     * for ascending)
     * @return the merged sorted list of EmergencyVehicle objects
     */
    private static List<EmergencyVehicle> mergeByLocation(List<EmergencyVehicle> left, List<EmergencyVehicle> right, boolean descending) {
        List<EmergencyVehicle> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            String leftLocation = left.get(i).getCurrentLocation();
            String rightLocation = right.get(j).getCurrentLocation();

            int comparison = descending ? rightLocation.compareToIgnoreCase(leftLocation) : leftLocation.compareToIgnoreCase(rightLocation);

            if (comparison <= 0) {
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }

        // Add remaining elements from left and right lists
        while (i < left.size()) {
            merged.add(left.get(i++));
        }
        while (j < right.size()) {
            merged.add(right.get(j++));
        }

        return merged;
    }

    /**
     * Sorts a list of EmergencyVehicle objects by their emergency vehicle name
     * in ascending or descending order.
     *
     * @param vehicleList the list of EmergencyVehicle objects to be sorted
     * @param descending specifies the sort order (true for descending, false
     * for ascending)
     * @return the sorted list of EmergencyVehicle objects
     */
    public static List<EmergencyVehicle> sortByVehicleName(List<EmergencyVehicle> vehicleList, boolean descending) {
        if (vehicleList.size() <= 1) {
            return vehicleList; // No need to sort if the list has 0 or 1 element
        }

        int mid = vehicleList.size() / 2;
        List<EmergencyVehicle> left = new ArrayList<>(vehicleList.subList(0, mid));
        List<EmergencyVehicle> right = new ArrayList<>(vehicleList.subList(mid, vehicleList.size()));

        left = sortByVehicleName(left, descending);
        right = sortByVehicleName(right, descending);

        return mergeByVehicleName(left, right, descending);
    }

    /**
     * Merges two sorted lists of EmergencyVehicle objects by their emergency
     * vehicle name.
     *
     * @param left the left sorted list
     * @param right the right sorted list
     * @param descending specifies the sort order (true for descending, false
     * for ascending)
     * @return the merged sorted list of EmergencyVehicle objects
     */
    private static List<EmergencyVehicle> mergeByVehicleName(List<EmergencyVehicle> left, List<EmergencyVehicle> right, boolean descending) {
        List<EmergencyVehicle> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            String leftName = left.get(i).getEmergencyVehicleName();
            String rightName = right.get(j).getEmergencyVehicleName();

            int comparison = descending ? rightName.compareToIgnoreCase(leftName) : leftName.compareToIgnoreCase(rightName);

            if (comparison <= 0) {
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }

        // Add remaining elements from left and right lists
        while (i < left.size()) {
            merged.add(left.get(i++));
        }
        while (j < right.size()) {
            merged.add(right.get(j++));
        }

        return merged;
    }
}
