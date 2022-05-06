package Controllers;

import BusinessLogic.EventBusiness;
import Models.AddressModel;
import Models.EventModel;
import Models.EventTypeModel;
import Models.UserModel;

import java.util.ArrayList;

public class EventController {

    private EventBusiness eventBusiness;

    public EventController() {
        eventBusiness = new EventBusiness();
    }

    /* -------------------CRUD-------------------- */
    public void addEvent(EventModel event) {
        eventBusiness.addEvent(event);
    }
    public ArrayList<EventModel> getEventList() {
        return eventBusiness.getEvents();
    }
    public ArrayList<UserModel> getUserList() { return eventBusiness.getUsers(); }
    public ArrayList<EventTypeModel> getEventTypeList() { return eventBusiness.getEventType(); }

    public ArrayList<AddressModel> getAddressList() { return eventBusiness.getAddressList(); }


    public void deleteEvent(int idEvent) {
        eventBusiness.deleteEvent(idEvent);
    }

    public void updateEvent(EventModel event) {
        eventBusiness.updateEvent(event);
    }

    public EventModel getEvent(int idEvent) {
        return eventBusiness.getEvent(idEvent);
    }

    /*-------------------------------------------------*/
}
