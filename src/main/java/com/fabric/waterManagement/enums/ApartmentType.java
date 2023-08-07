package com.fabric.waterManagement.enums;

public enum ApartmentType {
    A(2),
    B(3);

    public int roomType;

    ApartmentType(int roomType){
        this.roomType = roomType;
    }

    public int getRoomType(){
        return roomType;
    }

}
