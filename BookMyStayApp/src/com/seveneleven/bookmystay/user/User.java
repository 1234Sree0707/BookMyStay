package com.seveneleven.bookmystay.user;
import com.seveneleven.bookmystay.admin.HotelAdmin;
import com.seveneleven.bookmystay.service.InventoryService;
import com.seveneleven.bookmystay.service.Search;
public class User {
	public static void main(String[] args) {
    	InventoryService inventory = new InventoryService();
        HotelAdmin admin = new HotelAdmin(inventory);
        admin.setInventory();
        Search search = new Search(inventory);
        search.searchRoomDetails();
    }
}