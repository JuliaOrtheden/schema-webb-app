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

    
    private String startTime;
    private String date;
    private String room;
    
    
    
    public Slot(String startTime, String date, String room){
        this.startTime = startTime;
        this.date = date;
        this.room = room;
    }
    
    public Slot(){}
    
     public void setStartTime(String time) {
        this.startTime = time;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    
}
