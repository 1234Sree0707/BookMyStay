package com.seveneleven.bookmystay.user;

import com.seveneleven.bookmystay.admin.HotelAdmin;
import com.seveneleven.bookmystay.model.Reservation;
import com.seveneleven.bookmystay.model.Service;
import com.seveneleven.bookmystay.service.*;

import java.util.*;

public class User {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String choice = "";

        // Inventory setup
        InventoryService inventory = new InventoryService();
        HotelAdmin admin = new HotelAdmin(inventory);
        admin.setInventory();

        // Services initialization
        Search search = new Search(inventory);
        ServiceManagement serviceModule = new ServiceManagement();
        BookingHistoryService historyService = new BookingHistoryService();
        BookingQueueService bookingService =
                new BookingQueueService(inventory, historyService);

        System.out.println("\n======= Welcome to BookMyStay =======\n");

        do {

            // Show available rooms
            search.searchRoomDetails();

            System.out.println("\nEnter your name:");
            String name = sc.nextLine();

            System.out.println("Enter the room type:");
            String typeRoom = sc.nextLine().toUpperCase();

            // Validate room type
            if(!inventory.getType().contains(typeRoom)) {
                System.out.println("Invalid room type. Please choose from available rooms.\n");
                continue;
            }

            Reservation reservation = new Reservation(name, typeRoom);

            // Add booking request
            bookingService.addBookingRequest(reservation);
            bookingService.processBookings();

            String reservationId = reservation.getReservationId();

            if(reservationId != null) {

                System.out.println("\nSelect Add-On Services");
                System.out.println("1 Breakfast (₹500)");
                System.out.println("2 Spa (₹2000)");
                System.out.println("3 Airport Pickup (₹1200)");
                System.out.println("0 Finish");

                while(true) {

                    System.out.println("Enter the service you want to add:");

                    int option;

                    try {
                        option = Integer.parseInt(sc.nextLine());
                    } catch(NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                        continue;
                    }

                    if(option == 0)
                        break;

                    switch(option) {

                        case 1:
                            serviceModule.addService(
                                    reservationId,
                                    new Service("Breakfast",500));
                            break;

                        case 2:
                            serviceModule.addService(
                                    reservationId,
                                    new Service("Spa",2000));
                            break;

                        case 3:
                            serviceModule.addService(
                                    reservationId,
                                    new Service("Airport Pickup",1200));
                            break;

                        default:
                            System.out.println("Invalid option.");
                    }
                }

                // Display services
                serviceModule.displayServices(reservationId);

                // Billing
                double roomPrice = inventory.getTypeCostMap().get(typeRoom);
                double serviceCost = serviceModule.getServiceTotal(reservationId);
                double totalBill = roomPrice + serviceCost;

                System.out.println("\n========== FINAL BILL ==========");
                System.out.println("Room Type   : " + typeRoom);
                System.out.println("Room Cost   : ₹" + roomPrice);
                System.out.println("Service Cost: ₹" + serviceCost);
                System.out.println("-------------------------------");
                System.out.println("Total Bill  : ₹" + totalBill);
                System.out.println("================================");
            }

            System.out.println("\nDo you want to reserve another room? (yes/no)");
            choice = sc.nextLine();

        } while(choice.equalsIgnoreCase("yes"));

        // Show booking history report
        System.out.println("\n====== BOOKING HISTORY REPORT ======");
        historyService.displayBookingHistory();

        System.out.println("\nThank you for using BookMyStay!");

        sc.close();
    }
}