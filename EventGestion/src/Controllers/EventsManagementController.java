package Controllers;

import BusinessLogic.EventsManagementBusiness;
import Exceptions.AddEventException;
import Exceptions.QueryException;
import Exceptions.SearchDateException;
import Models.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class EventsManagementController {

    private final EventsManagementBusiness eventsManagementBusiness;

    public EventsManagementController() {
        eventsManagementBusiness = new EventsManagementBusiness();
    }

    /* -------------------CRUD-------------------- */
    public void addEvent(EventModel event) throws AddEventException, QueryException {
        eventsManagementBusiness.addEvent(event);
    }
    public ArrayList<EventModel> getEventList() {
        return eventsManagementBusiness.getEvents();
    }
    public ArrayList<UserModel> getUserList() { return eventsManagementBusiness.getUsers(); }
    public ArrayList<EventTypeModel> getEventTypeList() { return eventsManagementBusiness.getEventType(); }

    public ArrayList<AddressModel> getAddressList() { return eventsManagementBusiness.getAddressList(); }


    public void deleteEvent(int idEvent) throws SQLException {
        eventsManagementBusiness.deleteEvent(idEvent);
    }

    public void updateEvent(EventModel event) {
        eventsManagementBusiness.updateEvent(event);
    }

    public EventModel getEvent(int idEvent) {
        return eventsManagementBusiness.getEvent(idEvent);
    }

    /*-------------------------------------------------*/


    /*-------------------------- SEARCH EVENT TYPE -------------*/

    public ArrayList<SearchEventTypeModel> getSearchByEventType(int idEventType) {
        return  eventsManagementBusiness.getSearchByEventType(idEventType);
    }

    /*-------------------------------------------------*/

    /*------------------------- SEARCH By Dates --------------*/

    public ArrayList<SearchDateModel> getSearchByDates(Date startDate, Date endDate) throws SearchDateException {
        return eventsManagementBusiness.getSearchByDates(startDate, endDate);
    }

    /* ---------------------------------------------------------*/

    /* SEARCH promotion */

    public ArrayList<UserTypeModel> getUserTypeList() {
        return eventsManagementBusiness.getUserType();
    }

    public ArrayList<SearchPromotionModel> getSearchByUserType(int idUserType) {
        return eventsManagementBusiness.getSearchByUserType(idUserType);
    }


    /* Business task */

    public ArrayList<EventModel> getUserEventList(int idUser) {
        return eventsManagementBusiness.getUserEventsList(idUser);
    }

    public String getInformationEvent(int idEvent) {
        return eventsManagementBusiness.getInformationEvent( idEvent);
    }
}
