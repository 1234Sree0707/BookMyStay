package com.seveneleven.bookmystay.admin;

import com.seveneleven.bookmystay.service.InventoryService;

public class HotelAdmin {

    InventoryService inventory;

    public HotelAdmin(InventoryService inventory) {
        this.inventory = inventory;
    }

    public void setInventory() {

        inventory.setRoomType("SINGLE");
        inventory.setRoomType("DOUBLE");
        inventory.setRoomType("SUITE");

        inventory.setRoomTypeCount("SINGLE",50);
        inventory.setRoomTypeCount("DOUBLE",100);
        inventory.setRoomTypeCount("SUITE",25);

        inventory.setRoomTypeCost("SINGLE",19000.0);
        inventory.setRoomTypeCost("DOUBLE",24000.0);
        inventory.setRoomTypeCost("SUITE",35000.0);
    }
}