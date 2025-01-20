package com.emergencyvehicle.controller.algorithms;

import com.emergencyvehicle.model.EmergencyVehicle;
import java.util.List;

/**
 * Prayash Rawal 
 * LMU ID: 23056551
 */
public class SelectionSort {

    /**
     * Sorts a list of EmergencyVehicle objects by their serial number in
     * ascending order.
     *
     * @param vehicleList the list of EmergencyVehicle objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return the sorted list
     * @throws IllegalArgumentException if the vehicle list is null or empty
     */
    public static List<EmergencyVehicle> sortBySerialNumber(List<EmergencyVehicle> vehicleList, boolean isDesc) {
        if (vehicleList == null || vehicleList.isEmpty()) {
            throw new IllegalArgumentException("Emergency vehicle list cannot be null or empty.");
        }

        int n = vehicleList.size();
        for (int i = 0; i < n - 1; i++) {
            int extremumIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (shouldSwap(vehicleList.get(j).getSerialNumber(), vehicleList.get(extremumIndex).getSerialNumber(), isDesc)) {
                    extremumIndex = j;
                }
            }

            if (i != extremumIndex) {
                swap(vehicleList, i, extremumIndex);
            }
        }

        return vehicleList;
    }

    /**
     * Determines whether the current value should replace the current extremum
     * based on sort order.
     *
     * @param current the current value
     * @param extremum the current extremum value
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return true if the current value should replace the extremum; false
     * otherwise
     */
    private static boolean shouldSwap(int current, int extremum, boolean isDesc) {
        return isDesc ? current > extremum : current < extremum;
    }

    /**
     * Swaps two elements in the list.
     *
     * @param vehicleList the list of EmergencyVehicle objects
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private static void swap(List<EmergencyVehicle> vehicleList, int i, int j) {
        EmergencyVehicle temp = vehicleList.get(i);
        vehicleList.set(i, vehicleList.get(j));
        vehicleList.set(j, temp);
    }
}
