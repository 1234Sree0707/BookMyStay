package com.seveneleven.bookmystay.service;

import java.util.*;

public class InventoryService {

    Map<String,Integer> typeCount;
    Map<String,Double> typePrice;
    HashSet<String> roomType;

    // UC4 structures
    Set<String> bookedRoomIds;
    Map<String, Set<String>> allocatedRooms;

    public InventoryService() {

        typeCount = new HashMap<>();
        typePrice = new HashMap<>();
        roomType = new HashSet<>();

        bookedRoomIds = new HashSet<>();
        allocatedRooms = new HashMap<>();
    }

    public Map<String,Integer> getTypeCountMap(){
        return typeCount;
    }

    public Map<String,Double> getTypeCostMap(){
        return typePrice;
    }

    public HashSet<String> getType(){
        return roomType;
    }

    public Set<String> getBookedRooms(){
        return bookedRoomIds;
    }

    public Map<String,Set<String>> getAllocatedRooms(){
        return allocatedRooms;
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