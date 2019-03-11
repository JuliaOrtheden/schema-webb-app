/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SchemaApp2.model;

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
    
    

    public List<WeekSlots> createWeek(){
        List<WeekSlots> list = new ArrayList<>();
        Calendar now = Calendar.getInstance();
        
        int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
        int monday = now.get(Calendar.DATE)-dayOfWeek+2;
        System.out.println(monday);
        System.out.println(dayOfWeek);
                        for(int j = 0 ; j< 5; j++){

            for (int i = 0; i < 24; i++){
                list.add(new WeekSlots(
                new Slot((i+ ":00:00"), monday+j*7 + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR), "Grupprum 1"),
                new Slot((i+ ":00:00"), monday+1+j*7 + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR), "Grupprum 1"),
                new Slot((i+ ":00:00"), monday+2+j*7 + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR), "Grupprum 1"),
                new Slot((i+ ":00:00"), monday+3+j*7 + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR), "Grupprum 1"),
                new Slot((i+ ":00:00"), monday+4+j*7 + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR), "Grupprum 1"),
                new Slot((i+ ":00:00"), monday+5+j*7 + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR), "Grupprum 1"),
                new Slot((i+ ":00:00"), monday+6+j*7 + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR), "Grupprum 1")));
                }
                
            }
         return list;
    }

}