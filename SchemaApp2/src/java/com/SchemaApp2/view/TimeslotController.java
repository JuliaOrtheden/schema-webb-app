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
    private List<Timeslot> timeslots = new ArrayList<Timeslot>();
    private static final Logger LOG = Logger.getLogger(TimeslotController.class.getName());


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
        System.out.println("sdfghjkjhgfghjklkjhgfghjklkjhgfghjk");
        timeslotHelper = new TimeslotHelper();
        slots = new ArrayList<>();
        slots = timeslotHelper.createWeek();
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
  
        Timeslot timeslot = convertSlotToTimeslot(selectedSlot);
        //selected.getTimeslotPK().setRoom(selected.getRoom1().getName());
        getFacade().create(timeslot);
        recreateModel();
        selectedItemIndex = -1;
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
    
    public void hej(){
        System.out.println("HEJ");
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
        /*try {
            System.out.println("Försöker 1");
            current.getTimeslotPK().setRoom(current.getRoom1().getName());
            System.out.println("Försöker 2");
            Timeslot current2 = new Timeslot();
            int num = 2;
            short numShort = (short) num;
            Room room = new Room("banan","Banan", numShort);
            Users user = new Users("a", "a", "a", "a", "a", "a","a");
            current2.setUsers(user);
            current2.setDescription("hjkl");
            TimeslotPK timeslotpk = new TimeslotPK();
            Date date = new Date();
            timeslotpk.setDate(date);
            timeslotpk.setRoom("Musikrummet");
            timeslotpk.setTime(date);
            current2.setTimeslotPK(timeslotpk);
            System.out.println("ojojojojoj");
            getFacade().create(current);
            System.out.println("Försöker 3");
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TimeslotCreated"));
            System.out.println("Försöker 4");
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }*/
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
        return "Edit";
    }
    
    public String prepareEdit2(){
        selected = (Timeslot) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "MyBookings";
    }

    public String update() {
        try {
            selected.getTimeslotPK().setRoom(selected.getRoom1().getName());
            getFacade().edit(selected);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TimeslotUpdated"));
            return "View";
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
        return "List";
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
