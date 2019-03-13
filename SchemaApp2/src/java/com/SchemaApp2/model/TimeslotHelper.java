/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SchemaApp2.model;

import com.SchemaApp2.view.TimeslotController;
import java.io.Serializable;
import java.time.YearMonth;
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
        int monday = now.get(Calendar.DATE) - dayOfWeek + 2;
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);

        YearMonth yearMonthObject = YearMonth.of(year, month + 1);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        int dayShift = 0;

        int weekShift = 0;
        for (int k = 0; k < 2; k++) {
            dayShift = 0;
            int[] weekdays = new int[7];
            int[] monthArr = new int[7];
            for (int j = 0; j < 7; j++) {
                if (monday + dayShift + 7 * weekShift <= daysInMonth) {
                    weekdays[j] = monday + dayShift + 7 * weekShift;
                    monthArr[j] = month;
                    dayShift += 1;

                } else {
                    weekShift = 0;
                    monday = -dayShift+1;
                    
                    month += 1;
                    if (month > 11) {
                        year += 1;
                        month = 0;
                    }
                    yearMonthObject = YearMonth.of(year, month + 1);
                    daysInMonth = yearMonthObject.lengthOfMonth();
                    weekdays[j] = monday + dayShift + 7 * weekShift;
                    monthArr[j] = month;
                    dayShift += 1;

                }
            }
            dayShift = 0;
            
            
            String [] times = new String[24];
            for(int i = 0; i<24;i++){
                if(i < 10){
                    times[i] = "0" + i + ":00:00";
                }else{
                times[i] = i + ":00:00";
                }
            }
            String[] monthStrings = new String[7];
            for ( int i = 0; i < monthArr.length; i++){
                if (monthArr[i] < 9){
                    monthStrings[i] = "0" + (monthArr[i]+1);
                } else {
                    monthStrings[i] = "" + (monthArr[i]+1);
                }
            }
            
            
            for (int i = 0; i < 24; i++) {
                List<Slot> week = new ArrayList<>();
                for (int j = 0; j < 7; j++) {
                    week.add(new Slot(times[i], weekdays[j] + "/" + monthStrings[j] + "/" + year, "Grupprum 1", false));
                }
                list.add(new WeekSlots(week.get(0), week.get(1), week.get(2),
                        week.get(3), week.get(4), week.get(5), week.get(6)));
 

            }
            weekShift += 1;
          

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
