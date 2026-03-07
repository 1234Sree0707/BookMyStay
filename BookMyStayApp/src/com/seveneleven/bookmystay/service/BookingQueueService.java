package com.seveneleven.bookmystay.service;

import java.util.*;

import com.seveneleven.bookmystay.model.Reservation;

public class BookingQueueService {

    Queue<Reservation> bookingQueue;
    InventoryService inventory;

    public BookingQueueService(InventoryService inventory) {
        this.inventory = inventory;
        bookingQueue = new LinkedList<>();
    }

    public void addBookingRequest(Reservation reservation) {

        bookingQueue.offer(reservation);

<<<<<<< HEAD
        System.out.println(
                reservation.getGuestName() +
                " added to booking queue for " +
                reservation.getRoomType());
=======
        System.out.println(reservation.getGuestName() +" request added to booking queue for " + reservation.getRoomType());
>>>>>>> 2cf6d3771647def2e4ca6406521465e296c4f230
    }

    public void processBookings() {

        Map<String,Integer> typeCount = inventory.getTypeCountMap();
        Set<String> bookedRooms = inventory.getBookedRooms();
        Map<String,Set<String>> allocatedRooms = inventory.getAllocatedRooms();

        while(!bookingQueue.isEmpty()) {

            Reservation r = bookingQueue.poll();
            String type = r.getRoomType();

            int available = typeCount.getOrDefault(type,0);

            System.out.println("\nProcessing booking for " + r.getGuestName());

            if(available > 0) {

                String roomId = generateRoomId(type, bookedRooms);

<<<<<<< HEAD
                bookedRooms.add(roomId);

                allocatedRooms
                        .computeIfAbsent(type, k -> new HashSet<>())
                        .add(roomId);

                typeCount.put(type, available - 1);

                System.out.println("Booking Confirmed");
                System.out.println("Room ID : " + roomId);

            } else {

                System.out.println("Booking Failed → No rooms available");
            }
        }
    }

    private String generateRoomId(String type, Set<String> bookedRooms) {

        int number = 1;

        while(true) {

            String roomId = type + "-" + number;

            if(!bookedRooms.contains(roomId)) {
                return roomId;
            }

            number++;
        }
    }
}
=======
                System.out.println("Booking Confirmed → " +roomType +" room allocated");

            } else {

                System.out.println("Booking Failed → No rooms available for " +roomType);
            }
        }
    }
}
>>>>>>> 2cf6d3771647def2e4ca6406521465e296c4f230
