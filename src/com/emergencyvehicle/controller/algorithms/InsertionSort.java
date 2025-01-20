package com.emergencyvehicle.controller.algorithms;

import com.emergencyvehicle.model.EmergencyVehicle;
import java.util.List;

/*
 * Prayash Rawal
 * LMU ID: 23056551
 */

public class InsertionSort {

    /**
     * Sorts a list of EmergencyVehicle objects based on model name in ascending
     *
     * @param vehicleList the list of EmergencyVehicle objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @param fieldName the name of the field to sort by
     * ("emergencyVehicleName")
     * @return the sorted list
     * @throws IllegalArgumentException if the vehicle list is null or empty
     */
    public static List<EmergencyVehicle> sortByString(List<EmergencyVehicle> vehicleList, boolean isDesc, String fieldName) {
        if (vehicleList == null || vehicleList.isEmpty()) {
            throw new IllegalArgumentException("Vehicle list cannot be null or empty.");
        }

        for (int i = 1; i < vehicleList.size(); i++) {
            EmergencyVehicle key = vehicleList.get(i);
            int j = i - 1;

            // Compare based on the specified field (e.g., emergencyVehicleName)
            while (j >= 0 && shouldSwap(vehicleList.get(j), key, isDesc, fieldName)) {
                vehicleList.set(j + 1, vehicleList.get(j));
                j--;
            }
            vehicleList.set(j + 1, key);
        }

        return vehicleList;
    }

    /**
     * Determines whether two EmergencyVehicle objects should be swapped based
     * on the specified field and sort order.
     *
     * @param current the current EmergencyVehicle object
     * @param key the key EmergencyVehicle object
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @param fieldName the name of the field to compare
     * @return true if the current object should be swapped with the key; false
     * otherwise
     */
    private static boolean shouldSwap(EmergencyVehicle current, EmergencyVehicle key, boolean isDesc, String fieldName) {
        String currentField = getFieldValue(current, fieldName);
        String keyField = getFieldValue(key, fieldName);

        return isDesc ? currentField.compareToIgnoreCase(keyField) < 0 : currentField.compareToIgnoreCase(keyField) > 0;
    }

    /**
     * Retrieves the value of the specified field from an EmergencyVehicle
     * object.
     *
     * @param vehicle the EmergencyVehicle object
     * @param fieldName the name of the field to retrieve
     * @return the value of the field as a string
     * @throws IllegalArgumentException if the field name is invalid
     */
    private static String getFieldValue(EmergencyVehicle vehicle, String fieldName) {
        switch (fieldName) {
            case "emergencyVehicleName":
                return vehicle.getEmergencyVehicleName();
            case "modelNumber":
                return vehicle.getModelNumber();
            case "vehicleType":
                return vehicle.getVehicleType();
            default:
                throw new IllegalArgumentException("Invalid field name: " + fieldName);
        }
    }
}
