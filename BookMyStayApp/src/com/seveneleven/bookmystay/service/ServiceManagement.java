package com.seveneleven.bookmystay.service;

import java.util.*;

import com.seveneleven.bookmystay.model.Service;

public class ServiceManagement {

    // reservationId → services
    Map<String, List<Service>> reservationServices;

    public ServiceManagement() {
        reservationServices = new HashMap<>();
    }

    // Attach service to reservation
    public void addService(String reservationId, Service service) {

        reservationServices
            .computeIfAbsent(reservationId, k -> new ArrayList<>())
            .add(service);

        System.out.println(service.getName() +
                " added to reservation " + reservationId);
    }

    // Calculate total cost of services
    public double calculateServiceCost(String reservationId) {

        List<Service> services = reservationServices.get(reservationId);

        if (services == null)
            return 0;

        double total = 0;

        for(Service s : services) {
            total += s.getPrice();
        }

        return total;
    }

    // Display services
    public void displayServices(String reservationId) {

        List<Service> services = reservationServices.get(reservationId);

        if(services == null) {
            System.out.println("No services selected");
            return;
        }

        System.out.println("\nServices for reservation " + reservationId);

        for(Service s : services) {
            System.out.println(s.getName() + " : ₹" + s.getPrice());
        }

        System.out.println("Total Service Cost : ₹" +
                calculateServiceCost(reservationId));
    }
    public double getServiceTotal(String reservationId) {

        List<Service> services = reservationServices.get(reservationId);

        if(services == null)
            return 0;

        double total = 0;

        for(Service s : services) {
            total += s.getPrice();
        }

        return total;
    }
}