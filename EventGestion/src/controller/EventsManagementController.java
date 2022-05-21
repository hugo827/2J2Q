package controller;

import businessLogic.EventsManagementBusiness;
import exception.*;
import model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class EventsManagementController {

    private EventsManagementBusiness eventsManagementBusiness;

    public EventsManagementController() {
        eventsManagementBusiness = new EventsManagementBusiness();
    }

    /* -------------------CRUD-------------------- */
    public void addEvent(EventModel event) throws AddEventException, DataAccessException {
        eventsManagementBusiness.addEvent(event);
    }
    public ArrayList<EventModel> getEventList() {
        return eventsManagementBusiness.getEvents();
    }
    public ArrayList<UserModel> getUserList() { return eventsManagementBusiness.getUsers(); }
    public ArrayList<EventTypeModel> getEventTypeList() { return eventsManagementBusiness.getEventType(); }

    public ArrayList<AddressModel> getAddressList() { return eventsManagementBusiness.getAddressList(); }


    public void deleteEvent(int idEvent) throws SQLException, DataAccessException {
        eventsManagementBusiness.deleteEvent(idEvent);
    }

    public void updateEvent(EventModel event) throws DataAccessException, UpdateEventException {
        eventsManagementBusiness.updateEvent(event);
    }

    public EventModel getEvent(int idEvent) throws DataAccessException {
        return eventsManagementBusiness.getEvent(idEvent);
    }


    /*-------------------------- SEARCH EVENT TYPE -------------*/

    public ArrayList<SearchEventTypeModel> getSearchByEventType(int idEventType) throws DataAccessException {
        return  eventsManagementBusiness.getSearchByEventType(idEventType);
    }


    /*------------------------- SEARCH By Dates --------------*/

    public ArrayList<SearchDateModel> getSearchByDates(Date startDate, Date endDate) throws SearchDateException {
        return eventsManagementBusiness.getSearchByDates(startDate, endDate);
    }


    /* ------------------------SEARCH promotion------------------------ */

    public ArrayList<UserTypeModel> getUserTypeList() {
        return eventsManagementBusiness.getUserType();
    }

    public ArrayList<SearchPromotionModel> getSearchByUserType(int idUserType) throws DataAccessException {
        return eventsManagementBusiness.getSearchByUserType(idUserType);
    }


    /* ------------------------Business task------------------------------ */

    public ArrayList<EventModel> getUserEventList(int idUser) throws DataAccessException {
        return eventsManagementBusiness.getUserEventsList(idUser);
    }

    public String getInformationEvent(int idEvent) throws DataAccessException, SQLException {
        return eventsManagementBusiness.getInformationEvent( idEvent);
    }

    public BusinessTaskModel calculateReduction(int numberPerson, double price, ArrayList<ReductionModel> reductionModelArrayList) throws CalculateReductionException, ReductionBetweenException {
        return eventsManagementBusiness.calculateReduction(numberPerson, price, reductionModelArrayList);
    }
}
