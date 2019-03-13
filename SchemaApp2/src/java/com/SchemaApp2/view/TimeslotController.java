package com.SchemaApp2.view;

import com.SchemaApp2.model.Room;
import com.SchemaApp2.model.Slot;
import com.SchemaApp2.model.Timeslot;
import com.SchemaApp2.view.util.JsfUtil;
import com.SchemaApp2.view.util.PaginationHelper;
import com.SchemaApp2.model.TimeslotFacade;
import com.SchemaApp2.model.TimeslotHelper;
import com.SchemaApp2.model.TimeslotPK;
import com.SchemaApp2.model.Users;
import com.SchemaApp2.model.WeekSlots;

import java.io.Serializable;
import static java.lang.System.console;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Startup;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.view.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.persistence.Convert;
import javax.servlet.http.HttpSession;
import net.bootsfaces.component.dataTable.DataTable;

@Named("timeslotController")
@SessionScoped
@ManagedBean
public class TimeslotController implements Serializable {

    private Timeslot selected;
    private Slot selectedSlot;
    private DataModel items = null;
    @EJB
    private com.SchemaApp2.model.TimeslotFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private String selectedRoom;
    private List<Slot> bookedslots = new ArrayList<>();
    private List<Timeslot> timeslots = new ArrayList<Timeslot>();
    private static final Logger LOG = Logger.getLogger(TimeslotController.class.getName());
    private String[] header;

    public TimeslotController() {
    }
    
    public void getTimeSlotByUser(Users user){
        
        List<Timeslot> list = ejbFacade.filterTimeslotByUser(user);
        items.setWrappedData(list);
        
    }
    private List<WeekSlots> slots;
    
    @ManagedProperty("#{timeslotHelper}")
    private TimeslotHelper timeslotHelper;
    
    @PostConstruct
    public void init() {
        timeslotHelper = new TimeslotHelper();
        header = new String[5];
        slots = new ArrayList<>();
        slots = timeslotHelper.createWeek();
        System.out.println(slots.get(0).getMonday().getDate());
        System.out.println(slots.get(0).getTuesday().getDate());
        this.setHeader(slots.get(0).getMonday().getDate(), 0);
        this.setHeader(slots.get(0).getTuesday().getDate(), 1);
        this.setHeader(slots.get(0).getWednesday().getDate(), 2);
        this.setHeader(slots.get(0).getThursday().getDate(), 3);
        this.setHeader(slots.get(0).getFriday().getDate(), 4);
    }
    
    
    
    public String getHeader(int i){
        return header[i];
    }
    
    public void setHeader(String header, int i){
        this.header[i] = header;
        System.out.println(header +  i +  "OOOOMMMMMGGG");
    }
    
    public String newDateFormat(Date date){
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String dateString = simpleDateFormat.format(date);
        return dateString;
    }
    public String newTimeFormat(Date time){
        String pattern = "HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String timeString = simpleDateFormat.format(time);
        return timeString;
    }
        
    public boolean compare(Timeslot timeslot, Slot slot){
        TimeslotPK tpk = timeslot.getTimeslotPK();
        String timeslotDate = newDateFormat(tpk.getDate());
        String timeslotRoom = tpk.getRoom();
        String timeslotTime = newTimeFormat(tpk.getTime());
        
        System.out.println("Timeslot values " + timeslotDate + " " + timeslotRoom + " " + timeslotTime);
        System.out.println("Slot values " + slot.getDate() + " " + slot.getRoom() + " " + slot.getStartTime() );
        
        System.out.println("Equal date" + timeslotDate.equals(slot.getDate()));
        System.out.println("Equal time" + timeslotTime.equals(slot.getStartTime()));
        System.out.println("Equal room" + timeslotRoom.equals(slot.getRoom()));
        
        return(timeslotDate.equals(slot.getDate()) && (timeslotRoom.equals(slot.getRoom()) && timeslotTime.equals(slot.getStartTime())));
    }    
    
    public List<Timeslot> getBookedTimeslots(){
        List<Timeslot> list = ejbFacade.getBookedTimeslots();
        System.out.println("Booked: " + list);
        return list;
    }    
    public List<WeekSlots> getSlots(){
        return slots;
    }
   /* public List<Timeslot> filter(){
        
    }*/
    public Timeslot convertSlotToTimeslot(Slot slot){
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
        String sDate = slot.getDate();
  
        String sTime = slot.getStartTime();
        
        Date date = new Date();
        Date time = new Date();
        try {
            date = format.parse(sDate);
            time = timeFormat.parse(sTime);
        } catch (ParseException ex) {
            Logger.getLogger(TimeslotController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        String room = slot.getRoom();
        System.out.println(room);
        Timeslot timeslot = new Timeslot(date, time, room);
        timeslot.setDescription("hej");
        return timeslot;      
    }
    
    public void bookTimeslot(){
        
        try {
            Timeslot timeslot = convertSlotToTimeslot(selectedSlot);
            timeslot.setDescription(selectedSlot.getDescription());
            bookedslots.add(selectedSlot);
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
            timeslot.setUsers((Users)session.getAttribute("user"));
            System.out.println((Users)session.getAttribute("users"));
            
            //selected.getTimeslotPK().setRoom(selected.getRoom1().getName());
            getFacade().create(timeslot);
            recreateModel();
            selectedItemIndex = -1;
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }

    }
    
    public Slot getSelectedSlot() {
        if (selectedSlot == null) {
            selectedSlot = new Slot();
            selectedItemIndex = -1;
        }
        return selectedSlot;
    }
    
    public void setSelectedSlot(Slot slot){
        selectedSlot = slot;
    }
    
    public void updateWeek(String room){
        /*for (int i = 0; i < (5*24); i++) {
            slots.get(i).getMonday().setRoom(room);
            slots.get(i).getTuesday().setRoom(room);
            slots.get(i).getWednesday().setRoom(room);
            slots.get(i).getThursday().setRoom(room);
            slots.get(i).getFriday().setRoom(room);
            slots.get(i).getSaturday().setRoom(room);
            slots.get(i).getSunday().setRoom(room);
            
        }
        */
        slots = timeslotHelper.reCreateWeek(room);
         List<Timeslot> bookedList = getBookedTimeslots();
        
        for(WeekSlots weekSlot: slots){
            if(!bookedList.isEmpty()){
                for(Timeslot ts: bookedList){
                    Slot mon = weekSlot.getMonday();
                    Slot tue = weekSlot.getTuesday();
                    Slot wed = weekSlot.getWednesday();
                    Slot thu = weekSlot.getThursday();
                    Slot fri = weekSlot.getFriday();
                    if(compare(ts,mon)){
                        mon.setBooked(true);
                    }else if(compare(ts,tue)){
                        tue.setBooked(true);
                    }else if(compare(ts,wed)){
                        wed.setBooked(true);
                    }else if(compare(ts,thu)){
                        thu.setBooked(true);
                    }else if(compare(ts,fri)){
                        fri.setBooked(true);
                    } 
                }
            }
        }
        //selectedRoom = room;
        //System.out.println(room);
        //recreateModel();
    }
    
    public Timeslot getSelected() {
        if (selected == null) {
            selected = new Timeslot();
            selected.setTimeslotPK(new com.SchemaApp2.model.TimeslotPK());
            selectedItemIndex = -1;
        }
        return selected;
    }
    
    public void setSelected(Timeslot timeslot){
        selected = timeslot;
    }
    public void page() {
        // Faces context hold all data relevant for this request
        DataTable dt = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent("bookedForm:bookedTable");
        LOG.log(Level.INFO, "Test {0}", dt.getJQueryEvents());
    }

    private TimeslotFacade getFacade() {
        return ejbFacade;
    }
   
    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        selected = (Timeslot) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        selected = new Timeslot();
        selected.setTimeslotPK(new com.SchemaApp2.model.TimeslotPK());
        timeslots.add(selected);
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
	            selected.getTimeslotPK().setRoom(selected.getRoom1().getName());
	            getFacade().create(selected);
	            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TimeslotCreated"));
	            return prepareCreate();
	        } catch (Exception e) {
	            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
	            return null;
	        }
        
    }

    public String prepareEdit() {
        selected = (Timeslot) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        System.out.println(selected);
        return "Edit";
    }
    
    public void prepareEdit2(){
        System.out.println(selected);
        selected = (Timeslot) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
    }

    public String update() {
        try {
            //selected.getTimeslotPK().setRoom(selected.getRoom1().getName());
            getFacade().edit(selected);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TimeslotUpdated"));
            return "MyBookings";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }
      
    public String destroy() {
        System.out.println("destroy");
        selected = (Timeslot) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "MyBookings";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            System.out.println("Förstör");
            getFacade().remove(selected);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TimeslotDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            selected = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }
    
    public List<Timeslot> getTimeSlots(){
        return timeslots;
    } 
    
    public List<Slot> getBookedSlots(){
        System.out.println(bookedslots.size());
        return bookedslots;
    }

    public DataModel getItemsByUser(Users user){
        DataModel allItems = getItems();
        getTimeSlotByUser(user);
        return allItems;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }
    
    public List<String> getDate(){
        Date n = new Date();
        List<String> dates = new ArrayList<>();
        int m = Calendar.MONTH + 1;
        int date = Calendar.DATE;
        int d = Calendar.DAY_OF_MONTH;
        int weekDay = Calendar.DAY_OF_WEEK;
        for (int i = 1; i < 8; i++) {
            dates.add((weekDay-d+i)+"/" + m + "/");
        }
        return dates;
    }
    
    
    public List<Timeslot> todoList(){
        List<Timeslot> list = new ArrayList<>();
        Date date = new Date();
        list.add(new Timeslot(new TimeslotPK(date, date, "Grupprum 1")));
        list.add(new Timeslot(new TimeslotPK(new Date(), new Date(), "Grupprum 2")));
        list.add(new Timeslot(new TimeslotPK(new Date(), new Date(), "Grupprum 2")));
        list.add(new Timeslot(new TimeslotPK(new Date(), new Date(), "Grupprum 2")));
        list.add(new Timeslot(new TimeslotPK(new Date(), new Date(), "Grupprum 3")));
        list.add(new Timeslot(new TimeslotPK(new Date(), new Date(), "Grupprum 3")));
        list.add(new Timeslot(new TimeslotPK(new Date(), new Date(), "Grupprum 3")));
        list.add(new Timeslot(new TimeslotPK(new Date(), new Date(), "Grupprum 3")));
        list.add(new Timeslot(new TimeslotPK(date, date, "Grupprum 1")));
        list.add(new Timeslot(new TimeslotPK(new Date(), new Date(), "Grupprum 2")));
        list.add(new Timeslot(new TimeslotPK(new Date(), new Date(), "Grupprum 2")));
        list.add(new Timeslot(new TimeslotPK(new Date(), new Date(), "Grupprum 2")));
        list.add(new Timeslot(new TimeslotPK(new Date(), new Date(), "Grupprum 3")));
        list.add(new Timeslot(new TimeslotPK(new Date(), new Date(), "Grupprum 3")));
        list.add(new Timeslot(new TimeslotPK(new Date(), new Date(), "Grupprum 3")));
        list.add(new Timeslot(new TimeslotPK(new Date(), new Date(), "Grupprum 3")));
        return list;
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Timeslot getTimeslot(com.SchemaApp2.model.TimeslotPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Timeslot.class)
    public static class TimeslotControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TimeslotController controller = (TimeslotController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "timeslotController");
            return controller.getTimeslot(getKey(value));
        }

        com.SchemaApp2.model.TimeslotPK getKey(String value) {
            com.SchemaApp2.model.TimeslotPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.SchemaApp2.model.TimeslotPK();
            key.setDate(java.sql.Date.valueOf(values[0]));
            key.setTime(java.sql.Date.valueOf(values[1]));
            key.setRoom(values[2]);
            return key;
        }

        String getStringKey(com.SchemaApp2.model.TimeslotPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getDate());
            sb.append(SEPARATOR);
            sb.append(value.getTime());
            sb.append(SEPARATOR);
            sb.append(value.getRoom());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Timeslot) {
                Timeslot o = (Timeslot) object;
                return getStringKey(o.getTimeslotPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Timeslot.class.getName());
            }
        }

    }

}
