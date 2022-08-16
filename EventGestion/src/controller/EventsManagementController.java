package controller;

import businessLogic.EventsManagementBusiness;
import exception.*;
import model.*;

import java.util.ArrayList;
import java.util.Date;

public class EventsManagementController {

    private EventsManagementBusiness eventsManagementBusiness;

    public EventsManagementController() {
        eventsManagementBusiness = new EventsManagementBusiness();
    }

    /* -------------------CRUD-------------------- */

    public ArrayList<EventModel> getEventList() throws DataAccessException { return eventsManagementBusiness.getEvents(); }
    public ArrayList<UserModel> getUserList() throws DataAccessException { return eventsManagementBusiness.getUsers(); }
    public ArrayList<EventTypeModel> getEventTypeList() throws DataAccessException { return eventsManagementBusiness.getEventType(); }
    public ArrayList<AddressModel> getAddressList() throws DataAccessException { return eventsManagementBusiness.getAddressList(); }

    public void addEvent(EventModel event) throws AddEventException, DataAccessException {
        eventsManagementBusiness.addEvent(event);
    }
    public void addUser(UserModel user) throws AddUserException, DataAccessException {
        eventsManagementBusiness.addUser(user);
    }
    public void deleteEvent(int idEvent) throws  DataAccessException {
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

    public ArrayList<SearchDateModel> getSearchByDates(Date startDate, Date endDate) throws SearchDateException, DataAccessException {
        return eventsManagementBusiness.getSearchByDates(startDate, endDate);
    }

    public ArrayList<SearchEndDatesModel> getSearchByEndDates(Date endDate) throws DataAccessException {
        return eventsManagementBusiness.getSearchEndDates(endDate);
    }

    /* ------------------------SEARCH promotion------------------------ */

    public ArrayList<UserTypeModel> getUserTypeList() throws DataAccessException {
        return eventsManagementBusiness.getUserType();
    }

    public ArrayList<SearchPromotionModel> getSearchByUserType(int idUserType) throws DataAccessException {
        return eventsManagementBusiness.getSearchByUserType(idUserType);
    }


    /* ------------------------Business task------------------------------ */

    public ArrayList<EventModel> getUserEventList(int idUser) throws DataAccessException {
        return eventsManagementBusiness.getUserEventsList(idUser);
    }

    public String getInformationEvent(int idEvent) throws DataAccessException {
        return eventsManagementBusiness.getInformationEvent( idEvent);
    }

    public BusinessTaskModel calculateReduction(int numberPerson, double price, ArrayList<ReductionModel> reductionModelArrayList) throws CalculateReductionException, ReductionBetweenException, NumberPersonException {
        return eventsManagementBusiness.calculateReduction(numberPerson, price, reductionModelArrayList);
    }
}
