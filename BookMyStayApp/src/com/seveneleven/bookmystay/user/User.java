package com.seveneleven.bookmystay.user;
import  com.seveneleven.bookmystay.admin.HotelAdmin;
import  com.seveneleven.bookmystay.service.InventoryService;


public class User {
	public static void main(String[] args) {
		HotelAdmin administrator=new HotelAdmin();
		administrator.setInventory();
		
	}
}
