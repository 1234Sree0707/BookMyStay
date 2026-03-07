package com.seveneleven.bookmystay.service;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;

import com.seveneleven.bookmystay.model.Reservation;

public class BookingQueueService {

    Queue<Reservation> bookingQueue;
    InventoryService inventory;

    public BookingQueueService(InventoryService inventory) {
        this.inventory = inventory;
        bookingQueue = new LinkedList<>();
    }

    // Step 1: Accept Booking Request
    public void addBookingRequest(Reservation reservation) {

        bookingQueue.offer(reservation);

        System.out.println(reservation.getGuestName() +" request added to booking queue for " + reservation.getRoomType());
    }

    public void processBookings() {

        Map<String,Integer> typeCount = inventory.getTypeCountMap();

        while(!bookingQueue.isEmpty()) {

            Reservation r = bookingQueue.poll();

            String roomType = r.getRoomType();
            int available = typeCount.getOrDefault(roomType,0);

            System.out.println("\nProcessing booking for " + r.getGuestName());

            if(available > 0) {

                typeCount.put(roomType, available - 1);

                System.out.println("Booking Confirmed → " +roomType +" room allocated");

            } else {

                System.out.println("Booking Failed → No rooms available for " +roomType);
            }
        }
    }
}
