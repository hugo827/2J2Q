package BusinessLogic;

import DataAccess.*;
import Models.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class EventBusiness {

    private EventDataAccess eventDataAccess;
    private UserDataAccess userDataAccess;
    private EventTypeDataAccess eventTypeDataAccess;
    private AddressDataAccess addressDataAccess;

    private SearchEventTypeDataAcces searchEventTypeDataAcces;
    private SearchByDatesDataAccess searchByDatesDataAccess;


    private ArrayList<EventModel> events;
    private ArrayList<EventTypeModel> eventType;
    private ArrayList<UserModel> users;

    private ArrayList<AddressModel> addressModels;

    public EventBusiness() {
        eventDataAccess = new EventDataAccess();
        userDataAccess = new UserDataAccess();
        eventTypeDataAccess = new EventTypeDataAccess();
        addressDataAccess = new AddressDataAccess();
        searchEventTypeDataAcces = new SearchEventTypeDataAcces();
        searchByDatesDataAccess = new SearchByDatesDataAccess();

        loadEventList();
        loadUserList();
        loadEventTypeList();
        loadAddressList();
    }

    /* ---------------------- CRUD ----------------------*/
    public ArrayList<EventModel> getEvents() {
        return events;
    }
    public ArrayList<UserModel> getUsers() { return users; }
    public ArrayList<EventTypeModel> getEventType() { return eventType; }
    public ArrayList<AddressModel> getAddressList() { return addressModels; }

    public void loadEventList() {
        events = eventDataAccess.getAllEvent();
    }
    public void loadUserList() { users = userDataAccess.getUsers(); }
    public void loadEventTypeList() { eventType = eventTypeDataAccess.getEventType();}

    public void loadAddressList() { addressModels = addressDataAccess.getAddressList(); }

    public void deleteEvent(int idEvent) {
        eventDataAccess.deleteEvent(idEvent);
        events.removeIf(event -> event.getIdEvent() == idEvent);
    }
    public void updateEvent(EventModel event) {
        eventDataAccess.updateEvent();
    }
    public EventModel getEvent(int idEvent) { return eventDataAccess.getEvent(idEvent);}
    public void addEvent(EventModel event) {

        eventDataAccess.addEvent(event);
    }

    /*----------------------------------------------------*/


    /*-------------------------- SEARCH EVENT TYPE -------------*/

    public ArrayList<SearchEventTypeModel> getSearchByEventType(int idEventType) {
        return  searchEventTypeDataAcces.getSearchByEventType(idEventType);
    }

    /*-------------------------------------------------*/

    /*-------------------------- SEARCH by dates -------------*/

    public ArrayList<SearchDateModel> getSearchByDates(Date startDate, Date endDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedStartDate = simpleDateFormat.format(startDate);
        String formattedEndDate = simpleDateFormat.format(endDate);
        java.sql.Date startDateConvert = java.sql.Date.valueOf(formattedStartDate);
        java.sql.Date endDateConvert = java.sql.Date.valueOf(formattedEndDate);

        return  searchByDatesDataAccess.getSearchDates(startDateConvert, endDateConvert);
    }

    /*-------------------------------------------------*/


}
