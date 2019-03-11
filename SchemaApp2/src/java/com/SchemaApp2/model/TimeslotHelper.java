/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SchemaApp2.model;

import com.SchemaApp2.view.TimeslotController;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Johan Wennerbeck
 */
@Named("timeslotHelper")
@ManagedBean
@ApplicationScoped
public class TimeslotHelper {
    

    
    List<WeekSlots> list = new ArrayList<>();
    
    public List<WeekSlots> getList(){
        return list;
    }


    public List<WeekSlots> createWeek(){
        Calendar now = Calendar.getInstance();
        
        int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
        int monday = now.get(Calendar.DATE)-dayOfWeek+2;

            for (int i = 0; i < 24; i++){
                list.add(new WeekSlots(
                new Slot((i+ ":00:00"), monday + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR), "Grupprum 1", false),
                new Slot((i+ ":00:00"), monday+1 + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR), "Grupprum 1", false),
                new Slot((i+ ":00:00"), monday+2 + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR), "Grupprum 1", false),
                new Slot((i+ ":00:00"), monday+3 + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR), "Grupprum 1", false),
                new Slot((i+ ":00:00"), monday+4 + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR), "Grupprum 1", false),
                new Slot((i+ ":00:00"), monday+5 + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR), "Grupprum 1", false),
                new Slot((i+ ":00:00"), monday+6 + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR), "Grupprum 1", false)));
            

                
            }
         return list;
    }
    
    public List<WeekSlots> reCreateWeek(String room){
        for (int i = 0; i < list.size();i++) {
            list.get(i).getMonday().setRoom(room);
            list.get(i).getTuesday().setRoom(room);
            list.get(i).getWednesday().setRoom(room);
            list.get(i).getThursday().setRoom(room);
            list.get(i).getFriday().setRoom(room);
            list.get(i).getSaturday().setRoom(room);
            list.get(i).getSunday().setRoom(room);
        }
         return list;
    }

}