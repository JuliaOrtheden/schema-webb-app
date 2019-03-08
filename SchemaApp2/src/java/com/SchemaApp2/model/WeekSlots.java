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
public class WeekSlots {

    public Slot getMonday() {
        return monday;
    }

    public void setMonday(Slot monday) {
        this.monday = monday;
    }

    public Slot getTuesday() {
        return tuesday;
    }

    public void setTuesday(Slot tuesday) {
        this.tuesday = tuesday;
    }

    public Slot getWednesday() {
        return wednesday;
    }

    public void setWednesday(Slot wednesday) {
        this.wednesday = wednesday;
    }

    public Slot getThursday() {
        return thursday;
    }

    public void setThursday(Slot thursday) {
        this.thursday = thursday;
    }

    public Slot getFriday() {
        return friday;
    }

    public void setFriday(Slot friday) {
        this.friday = friday;
    }

    public Slot getSaturday() {
        return saturday;
    }

    public void setSaturday(Slot saturday) {
        this.saturday = saturday;
    }

    public Slot getSunday() {
        return sunday;
    }

    public void setSunday(Slot sunday) {
        this.sunday = sunday;
    }
    private Slot monday; 
    private Slot tuesday;
    private Slot wednesday;
    private Slot thursday;
    private Slot friday;
    private Slot saturday;
    private Slot sunday;
    
    public WeekSlots(Slot monday, Slot tuesday, Slot wednesday, Slot thursday, Slot friday, Slot saturday, Slot sunday){
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }
}
