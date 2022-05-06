package Controllers;

import BusinessLogic.EventBusiness;
import Models.*;

import java.util.ArrayList;
import java.util.Date;

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


    /*-------------------------- SEARCH EVENT TYPE -------------*/

    public ArrayList<SearchEventTypeModel> getSearchByEventType(int idEventType) {
        return  eventBusiness.getSearchByEventType(idEventType);
    }

    /*-------------------------------------------------*/

    /*------------------------- SEARCH By Dates --------------*/

    public ArrayList<SearchDateModel> getSearchByDates(Date startDate, Date endDate) {
        return eventBusiness.getSearchByDates(startDate, endDate);
    }

    /* ---------------------------------------------------------*/
}
