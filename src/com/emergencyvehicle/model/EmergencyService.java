package com.emergencyvehicle.model;

import com.emergencyvehicle.controller.datastructure.CustomQueue;

/**
 * Prayash Rawal LMU ID: 23056551
 */
/**
 * Emergency Service class for managing service requests using a custom queue.
 */
public class EmergencyService {

    private static CustomQueue<String> serviceRequests = new CustomQueue<>();

    static {
        // Pre-populate with initial service requests
        serviceRequests.enqueue("Engine check #A100");
        serviceRequests.enqueue("Refuel #A150");
        serviceRequests.enqueue("Dispatch to Thamel");
        serviceRequests.enqueue("Maintenance At 12");
        serviceRequests.enqueue("Check Sequipment");
    }

    /**
     * Adds a new service request to the queue.
     *
     * @param request the service request to be added
     */
    public void addServiceRequest(String request) {
        serviceRequests.enqueue(request);
    }

    /**
     * Dispatches and returns the first service request from the queue.
     *
     * @return the dispatched service request
     */
    public String dispatchServiceRequest() {
        return serviceRequests.dequeue();
    }

    /**
     * Gets the current queue of service requests.
     *
     * @return the custom queue of service requests
     */
    public CustomQueue<String> getServiceRequests() {
        return serviceRequests;
    }
}
