package BusinessLogic;

import DataAccess.*;
import DataAccess.Interfaces.*;
import Exceptions.AddEventException;
import Exceptions.DataAccessException;
import Exceptions.SearchDateException;
import Models.*;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class EventsManagementBusiness {

    private IEvent eventDataAccess;
    private IUser userDataAccess;
    private IEventType eventTypeDataAccess;
    private IAddress addressDataAccess;
    private IBusinessTask businessTaskDataAccess;
    private ISearchDates searchByDatesDataAccess;
    private ISearchEventType searchEventTypeDataAccess;
    private ISearchUserType searchByUserTypeDataAccess;
    private IUserType userTypeDataAccess;


    private ArrayList<EventModel> events;
    private ArrayList<EventTypeModel> eventType;
    private ArrayList<UserModel> users;
    private ArrayList<UserTypeModel> userType;
    private ArrayList<AddressModel> address;

    public EventsManagementBusiness() {
        eventDataAccess = new EventDataAccess();
        userDataAccess = new UserDataAccess();
        eventTypeDataAccess = new EventTypeDataAccess();
        addressDataAccess = new AddressDataAccess();

        searchByDatesDataAccess = new SearchByDatesDataAccess();
        userTypeDataAccess = new UserTypeDataAccess();
        searchByUserTypeDataAccess = new SearchByUserTypeDataAccess();
        businessTaskDataAccess = new BusinessTaskDataAccess();

        searchEventTypeDataAccess = new SearchByEventTypeDataAccess();

        loadEventList();
        loadUserList();
        loadEventTypeList();
        loadAddressList();
        loadUserTypeList();
    }

    /* ---------------------- CRUD ----------------------*/
    public ArrayList<EventModel> getEvents() {
        return events;
    }
    public ArrayList<UserModel> getUsers() { return users; }
    public ArrayList<EventTypeModel> getEventType() { return eventType; }
    public ArrayList<AddressModel> getAddressList() { return address; }

    public void loadEventList() {
        events = eventDataAccess.getAllEvent();
    }
    public void loadUserList() { users = userDataAccess.getUsers(); }
    public void loadEventTypeList() { eventType = eventTypeDataAccess.getEventType();}
    public void loadAddressList() { address = addressDataAccess.getAddressList(); }

    public void deleteEvent(int idEvent) throws SQLException {
        eventDataAccess.deleteEvent(idEvent);
        events.removeIf(event -> event.getIdEvent() == idEvent);
    }
    public void updateEvent(EventModel event) {
        if(event == null) {
            System.out.println("Error");
        } else {
            eventDataAccess.updateEvent(event);
            loadEventList();
        }
    }

    public EventModel getEvent(int idEvent) {
        if(idEvent <= 0) {
            System.out.println("Error");
        }
        return eventDataAccess.getEvent(idEvent);
    }
    public void addEvent(EventModel event) throws AddEventException, DataAccessException {
        if(event == null){
           throw new DataAccessException("The object event can't be null");
        } else {
            eventDataAccess.addEvent(event);
            loadEventList();
        }
    }


    /*-------------------------- SEARCH EVENT TYPE -------------*/

    public ArrayList<SearchEventTypeModel> getSearchByEventType(int idEventType) {
        if(idEventType <= 0) {
            System.out.println("Error");
        }
        return  searchEventTypeDataAccess.getSearchByEventType(idEventType);
    }



    /*-------------------------- SEARCH by dates -------------*/

    public ArrayList<SearchDateModel> getSearchByDates(Date startDate, Date endDate) throws SearchDateException {
        if(startDate == null || endDate == null || endDate.before(startDate)) {
            throw new SearchDateException();
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedStartDate = simpleDateFormat.format(startDate);
            String formattedEndDate = simpleDateFormat.format(endDate);
            java.sql.Date startDateConvert = java.sql.Date.valueOf(formattedStartDate);
            java.sql.Date endDateConvert = java.sql.Date.valueOf(formattedEndDate);
            return  searchByDatesDataAccess.getSearchDates(startDateConvert, endDateConvert);
        }
    }


    /*-------------------------------- SEARCH promotion -------------------------------------*/

    public ArrayList<UserTypeModel> getUserType() {
        return userType;
    }
    public void loadUserTypeList() {
        userType = userTypeDataAccess.getUserTypeList();
    }

    public ArrayList<SearchPromotionModel> getSearchByUserType(int idUserType) throws DataAccessException {
        if(idUserType <= 0) {
            throw new DataAccessException("The value : " + idUserType + " isn't correct for find an user type");
        } else {
            return searchByUserTypeDataAccess.getSearchUsertype(idUserType);
        }
    }

    public ArrayList<EventModel> getUserEventsList(int idUser) throws DataAccessException {
        if(idUser <= 0) {
            throw new DataAccessException("This value " + idUser + " isn't correct for finding user's event");
        } else {

            ArrayList<EventModel> eventModelArrayList = new ArrayList<>();

            events.forEach(event -> { if(idUser == event.getIdEvent()) eventModelArrayList.add(event); });

            return eventModelArrayList;
        }
    }

    public String getInformationEvent(int idEvent) throws DataAccessException {
        if(idEvent <=  0) {
            throw new DataAccessException("This value " + idEvent + " isn't correct for finding an event");
        } else {
            BusinessTaskModel businessTaskModel = businessTaskDataAccess.getDataEvent(idEvent);

            return " - Nombre de participant : " + businessTaskModel.getNbParticipant() + "\n"
                    + " - Somme total : " + businessTaskModel.getSumTotalWithOutPromotion() + "\n"
                    + " - Somme total prommotion : " + businessTaskModel.getSumTotalPromotion() + "\n"
                    + " - Somme final : " + businessTaskModel.getSumFinal() + "\n";
        }
    }
}
