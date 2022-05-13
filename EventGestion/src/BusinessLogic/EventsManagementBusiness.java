package BusinessLogic;

import DataAccess.*;
import DataAccess.Interfaces.*;
import Exceptions.AddEventException;
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
        searchEventTypeDataAccess = new SearchEventTypeDataAccess();
        searchByDatesDataAccess = new SearchByDatesDataAccess();
        userTypeDataAccess = new UserTypeDataAccess();
        searchByUserTypeDataAccess = new SearchByUserTypeDataAccess();
        businessTaskDataAccess = new BusinessTaskDataAccess();

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
        eventDataAccess.updateEvent(event);
        loadEventList();
    }
    public EventModel getEvent(int idEvent) { return eventDataAccess.getEvent(idEvent);}
    public void addEvent(EventModel event) throws AddEventException {
        eventDataAccess.addEvent(event);
        loadEventList();
    }


    /*-------------------------- SEARCH EVENT TYPE -------------*/

    public ArrayList<SearchEventTypeModel> getSearchByEventType(int idEventType) {
        return  searchEventTypeDataAccess.getSearchByEventType(idEventType);
    }



    /*-------------------------- SEARCH by dates -------------*/

    public ArrayList<SearchDateModel> getSearchByDates(Date startDate, Date endDate) throws SearchDateException {
        if(endDate.before(startDate)) {
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

    public ArrayList<SearchPromotionModel> getSearchByUserType(int idUserType) {
        return searchByUserTypeDataAccess.getSearchUsertype(idUserType);
    }

    public ArrayList<EventModel> getUserEventsList(int idUser) {
        ArrayList<EventModel> eventModelArrayList = new ArrayList<>();

        //TODO : je crois qu'on peut utiliser un -> avec un filter ...
        for(EventModel eventModel : events) {
            if(idUser == eventModel.getFk_creator()) eventModelArrayList.add(eventModel);
        }

        return eventModelArrayList;
    }

    public String getInformationEvent(int idEvent) {

        BusinessTaskModel businessTaskModel = businessTaskDataAccess.getDataEvent(idEvent);
        if(businessTaskModel == null ) businessTaskModel = new BusinessTaskModel(0, 0., 0.,0.);

        return  " - Nombre de participant : " + businessTaskModel.getNbParticipant() + "\n"
        + " - Somme total : " + businessTaskModel.getSumTotalWithOutPromotion() + "\n"
        + " - Somme total prommotion : "+ businessTaskModel.getSumTotalPromotion() +  "\n"
        + " - Somme final : "+ businessTaskModel.getSumFinal() + "\n";
    }
}
