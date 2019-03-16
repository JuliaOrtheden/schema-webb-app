package com.SchemaApp2.controller;

import com.SchemaApp2.model.Users;
import com.SchemaApp2.view.util.JsfUtil;
import com.SchemaApp2.view.util.PaginationHelper;
import com.SchemaApp2.model.UsersFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named("usersController")
@SessionScoped
public class UsersController implements Serializable {

    private Users current;
    private DataModel items = null;
    @EJB
    private com.SchemaApp2.model.UsersFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public UsersController() {
    }

    public Users getSelected() {
        if (current == null) {
            current = new Users();
            selectedItemIndex = -1;
        }
        return current;
    }

    private UsersFacade getFacade() {
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

  
    public String prepareRegister() {
        current = new Users();
        selectedItemIndex = -1;
        return "Welcome";
    }
    
     public String prepareCreate() {
        current = new Users();
        selectedItemIndex = -1;
        return "Create";
    }
    
    public String prepareWelcome(Users user){
        if(user.getUsertype().equals("admin")){
            return "AdminWelcomePage";
        }
        return "WelcomePage";
    }
    
    /**
     * Creates a new user
     * @return 
     */
    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UsersCreated"));
            Users user = getFacade().login(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UsersLogin"));
            current = user;
            FacesContext context2 = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);
            session.setAttribute("user", user);
            return prepareRegister();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("/Bundle").getString("UniqueRequirement"));
            return null;
        }
    }
    
     /**
     * Creates a new user
     * @return 
     */
    public String adminCreateUser() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UsersCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("/Bundle").getString("UniqueRequirement"));
            return null;
        }
    }
    
     /**
      * Uses http sessions to log a user in
      * @return 
      */
     public String login() {
        try {
            Users user = getFacade().login(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UsersLogin"));
            current = user;
            FacesContext context2 = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);
            session.setAttribute("user", user);
            return prepareWelcome(user);
        } catch (Exception e) {
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("/Bundle"). getString("WrongUser"));
                   
            return null;
        }
    }
     
     /**
      * Invalidates a session to log a user out
      * @return 
      */
     public void logout(){
         try{
             System.out.println("logout");
             FacesContext context = FacesContext.getCurrentInstance();
             HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
             context.getExternalContext().invalidateSession();
             current=null;
             context.getExternalContext().redirect(context.getExternalContext().getRequestContextPath() +"/faces/users/Login.xhtml");
         }catch (Exception e){
             JsfUtil.addErrorMessage(ResourceBundle.getBundle("/Bundle"). getString("Unsuccsesful logout"));
         }
     }

    public String prepareEditProfile() {
        current = (Users) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "EditProfile";
    }
    
      public String prepareEditUser() {
        current = (Users) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "EditUser";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UsersUpdated"));
            return "Profile";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("/Bundle").getString("UniqueRequirement"));
            return null;
        }
    }
    
    public String adminUpdate() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UsersUpdated"));
            return "EditUser";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("/Bundle").getString("UniqueRequirement"));
            return null;
        }
    }

    public String destroy() {
        current = (Users) getItems().getRowData();
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
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UsersDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("/Bundle").getString("CannotDelete"));
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
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
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

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Users getUsers(java.lang.String id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Users.class)
    public static class UsersControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UsersController controller = (UsersController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usersController");
            return controller.getUsers(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Users) {
                Users o = (Users) object;
                return getStringKey(o.getCid());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Users.class.getName());
            }
        }

    }

}
