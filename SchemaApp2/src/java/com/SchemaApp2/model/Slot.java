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

    public String getEndTime() {
        return endTime;
    }

    public String getDate() {
        return date;
    }

    public String getRoom() {
        return room;
    }

    public String getDay() {
        return day;
    }
    
    private String startTime;
    private String endTime;
    private String date;
    private String room;
    private String day;
    
    
    
    public Slot(String startTime, String endTime, String date, String room, String day){
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.room = room;
        this.day = day;
    }
    
    public Slot(){}
    
     public void setStartTime(String time) {
        this.startTime = time;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setDay(String day) {
       this.day = day;
    }
    
}
