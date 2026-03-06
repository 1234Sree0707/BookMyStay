package com.seveneleven.bookmystay.admin;
import com.seveneleven.bookmystay.service.InventoryService;
public class HotelAdmin {
	public void setInventory() {
		InventoryService s=new InventoryService();
		s.setRoomType("SINGLE");
		s.setRoomType("DOUBLE");
		s.setRoomType("SUITE");
		s.setRoomTypeCount("SINGLE",50);
		s.setRoomTypeCount("DOUBLE",100);
		s.setRoomTypeCount("SUITE",25);
		s.setRoomTypeCost("SINGLE", 19000.0);
		s.setRoomTypeCost("DOUBLE",24000.0);
		s.setRoomTypeCost("SUITE", 35000.0);
	}
	

}
