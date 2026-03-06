package com.seveneleven.bookmystay.service;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
public class InventoryService {
	Map<String,Integer> typeCount;
	Map<String,Double> typePrice;
	HashSet<String> roomType;
	public InventoryService() {
		this.typeCount=new HashMap<>();
		this.typePrice=new HashMap<>();
		this.roomType=new HashSet<>();
		
	}
	public void setRoomType(String type) {
		roomType.add(type);
	}
	public void setRoomTypeCost(String type,double cost) {
		typePrice.put(type, cost);
	}
	public void setRoomTypeCount(String type,int count) {
		typeCount.put(type, count);
	}
	



}
