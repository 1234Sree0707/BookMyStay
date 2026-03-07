package com.seveneleven.bookmystay.user;

import com.seveneleven.bookmystay.admin.HotelAdmin;
import com.seveneleven.bookmystay.model.Reservation;
import com.seveneleven.bookmystay.service.BookingQueueService;
import com.seveneleven.bookmystay.service.InventoryService;
import com.seveneleven.bookmystay.service.Search;
import java.util.*;
public class User {

    public static void main(String[] args) {
    	String choice="";
    	Scanner sc=new Scanner(System.in);
    	InventoryService inventory = new InventoryService();

        HotelAdmin admin = new HotelAdmin(inventory);
        admin.setInventory();

        Search search = new Search(inventory);
        search.searchRoomDetails();
    	do {

        
        System.out.println("Enter your name:");
        String name=sc.nextLine();
        
        System.out.println("Enter the room type:");
        String typeRoom=sc.nextLine();

        BookingQueueService bookingService =
                new BookingQueueService(inventory);

        bookingService.addBookingRequest(
                new Reservation(name,typeRoom));

       

        bookingService.processBookings();
        System.out.println("Do you want to reserve another room(yes/no)");
        choice=sc.nextLine();
    	}while(choice.equalsIgnoreCase("yes"));
    	sc.close();
    }
}