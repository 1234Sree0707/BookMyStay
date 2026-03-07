package com.seveneleven.bookmystay.service;

import com.seveneleven.bookmystay.model.Reservation;
import java.util.*;

public class BookingHistoryService {

    private List<Reservation> bookingHistory;

    public BookingHistoryService() {
        bookingHistory = new ArrayList<>();
    }

    // store confirmed booking
    public void addReservation(Reservation r) {
        bookingHistory.add(r);
    }

    // cancel reservation
    public void cancelReservation(String reservationId) {

        for(Reservation r : bookingHistory) {

            if(r.getReservationId().equals(reservationId)) {

                r.setStatus("CANCELLED");
                System.out.println("Reservation " + reservationId + " cancelled");
                return;
            }
        }

        System.out.println("Reservation not found");
    }

    // show booking history
    public void displayBookingHistory() {

        System.out.println("\n====== BOOKING HISTORY ======");

        for(Reservation r : bookingHistory) {

            System.out.println("Guest Name : " + r.getGuestName());
            System.out.println("Room Type  : " + r.getRoomType());
            System.out.println("Reservation ID : " + r.getReservationId());
            System.out.println("Status : " + r.getStatus());
            System.out.println("------------------------------");
        }
    }
}