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
    private UserTypeDataAccess userTypeDataAccess;
    private SearchByUserTypeDataAccess searchByUserTypeDataAccess;
    private BusinessTaskDataAccess businessTaskDataAccess;


    private ArrayList<EventModel> events;
    private ArrayList<EventTypeModel> eventType;
    private ArrayList<UserModel> users;
    private ArrayList<UserTypeModel> userType;

    private ArrayList<AddressModel> addressModels;

    public EventBusiness() {
        eventDataAccess = new EventDataAccess();
        userDataAccess = new UserDataAccess();
        eventTypeDataAccess = new EventTypeDataAccess();
        addressDataAccess = new AddressDataAccess();
        searchEventTypeDataAcces = new SearchEventTypeDataAcces();
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


    /* SEARCH promotiion */

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

        // TODO : je crois qu'on peut utiliser un -> avec un filter ...
        for(EventModel eventModel : events) {
            if(idUser == eventModel.getFk_creator()) eventModelArrayList.add(eventModel);
        }

        return eventModelArrayList;
    }

    public String getInformationEvent(int idEvent) {

        BusinessTaskModel businessTaskModel = businessTaskDataAccess.getDataEvent(idEvent);
        if(businessTaskModel == null ) businessTaskModel = new BusinessTaskModel(0,0,0,0);

        return  " - Nombre de participant : " + businessTaskModel.getNbParticpant() + "\n"
        + " - Somme total : " + businessTaskModel.getSumTotalWithOutPromotion() + "\n"
        + " - Somme total prommotion : "+ businessTaskModel.getSumTotalPromotion() +  "\n"
        + " - Somme final : "+ businessTaskModel.getSumFinal() + "\n";
    }
}
