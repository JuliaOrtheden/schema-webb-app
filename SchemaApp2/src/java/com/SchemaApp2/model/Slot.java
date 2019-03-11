/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SchemaApp2.model;

/**
 *
 * @author Johan Wennerbeck
 */
public class Slot {

    public String getStartTime() {
        return startTime;
    }


    public String getDate() {
        return date;
    }

    public String getRoom() {
        return room;
    }
    
    public boolean getBooked(){
        return booked;
    }
    
    public String getDescription(){
        return description;
    }

    
    private String startTime;
    private String date;
    private String room;
    private boolean booked;
    private String description;
    
    
    public Slot(String startTime, String date, String room, boolean booked){
        this.startTime = startTime;
        this.date = date;
        this.room = room;
        this.booked = booked;
    }
    
    public Slot(){}
    
     public void setStartTime(String time) {
        this.startTime = time;
    }
     
    public void setBooked(boolean booked){
        this.booked = booked;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public void setRoom(String room) {
        this.room = room;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    

    
}
