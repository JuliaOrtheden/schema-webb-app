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
    
    
    public List<Slot> createWeek(){       
        List<Slot> list = new ArrayList<>();
        String[] weekDays = {"M", "T", "O", "TO", "F", "L", "S"};
        int j = 0;
        Calendar now = Calendar.getInstance();
        for (String weekDay:weekDays){
            j++;
            for (int i = 1; i < 25; i++){
                
                list.add(new Slot( (i+ ":00:00"), (i+1 +":00:00"), now.get(Calendar.DATE) + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR), "Grupprum 1", weekDay));
            
            }
           
        }
         return list;
    }

}