
package com.SchemaApp2.model;

import com.SchemaApp2.controller.TimeslotController;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("timeslotHelper")
@ManagedBean
@ApplicationScoped
public class TimeslotHelper {

    
    List<WeekSlots> list = new ArrayList<>();
    private String[] header;
    public List<WeekSlots> getList(){
        return list;
    }

    /**
     * Creates a week and fills it with slots that a user can book
     * @return 
     */
    public List<WeekSlots> createWeek(){
        Calendar now = Calendar.getInstance();
        int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
        int monday = now.get(Calendar.DATE) - dayOfWeek + 1;
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);

        YearMonth yearMonthObject = YearMonth.of(year, month + 1);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        int dayShift = 0;

        // Creates the right day of the week and date
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
            
          // Fixes the format of the time  
            String [] times = new String[24];
            for(int i = 0; i<24;i++){
                if(i < 10){
                    times[i] = "0" + i + ":00:00";
                }else{
                times[i] = i + ":00:00";
                }
            }
            // Fixes the format of the month
            String[] monthStrings = new String[7];
            for ( int i = 0; i < monthArr.length; i++){
                if (monthArr[i] < 9){
                    monthStrings[i] = "0" + (monthArr[i]+1);
                } else {
                    monthStrings[i] = "" + (monthArr[i]+1);
                }
            }
            Calendar rightNow = Calendar.getInstance();
            int hour = rightNow.get(Calendar.HOUR_OF_DAY);
            // Creates a bookable slot for each hour of the day for a week
            for (int i = 0; i < 24; i++) {
                List<Slot> week = new ArrayList<>();
                for (int j = 0; j < 7; j++) {
                    if(weekdays[j] > LocalDate.now().getDayOfMonth()){
                        week.add(new Slot(times[i], weekdays[j] + "/" + monthStrings[j] + "/" + year, "Grupprum 1", false)); 
                        
                    }
                    else if(weekdays[j] < LocalDate.now().getDayOfMonth()){
                        week.add(new Slot(times[i], weekdays[j] + "/" + monthStrings[j] + "/" + year, "Grupprum 1", true));                            
                    }
                    else if(hour >= Integer.parseInt(times[i].split(":")[0])){
                        week.add(new Slot(times[i], weekdays[j] + "/" + monthStrings[j] + "/" + year, "Grupprum 1", true)); 
                    }else{
                        week.add(new Slot(times[i], weekdays[j] + "/" + monthStrings[j] + "/" + year, "Grupprum 1", false)); 

                    }
                }
                list.add(new WeekSlots(week.get(0), week.get(1), week.get(2),
                        week.get(3), week.get(4), week.get(5), week.get(6)));
 

            }
            weekShift += 1;
        }
        return list;
    }
    
    
    public void initHeaders(){
        header = new String[10];
        this.setHeader(list.get(0).getMonday().getDate(), 0);
        this.setHeader(list.get(0).getTuesday().getDate(), 1);
        this.setHeader(list.get(0).getWednesday().getDate(), 2);
        this.setHeader(list.get(0).getThursday().getDate(), 3);
        this.setHeader(list.get(0).getFriday().getDate(), 4);
        this.setHeader(list.get(24).getMonday().getDate(), 5);
        this.setHeader(list.get(24).getTuesday().getDate(), 6);
        this.setHeader(list.get(24).getWednesday().getDate(), 7);
        this.setHeader(list.get(24).getThursday().getDate(), 8);
        this.setHeader(list.get(24).getFriday().getDate(), 9);
    }
    
    public String getHeader(int i){
        return this.header[i];
    }
    
    public void setHeader(String date, int i){
        this.header[i] = date;
    }
    
    /**
     * Filters the rooms by the selected room 
     * @param room
     * @return 
     */
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
