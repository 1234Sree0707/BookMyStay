package com.seveneleven.bookmystay.service;

import java.util.HashSet;
import java.util.Map;

public class Search {

    InventoryService inventory;

    public Search(InventoryService inventory) {
        this.inventory = inventory;
    }

    public void searchRoomDetails() {

        Map<String,Integer> typeCount = inventory.getTypeCountMap();
        Map<String,Double> typePrice = inventory.getTypeCostMap();
        HashSet<String> roomType = inventory.getType();

        System.out.println("Available Rooms:\n");

        for(String type : roomType) {

            int count = typeCount.getOrDefault(type,0);
            double price = typePrice.getOrDefault(type,0.0);

            // Availability Validation
            if(count > 0) {

                System.out.println("Room Type : " + type);
                System.out.println("Price     : ₹" + price);
                System.out.println("Available : " + count);
                System.out.println("======================");
            }
        }
    }
}
