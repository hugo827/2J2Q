package BusinessLogic;

import DataAccess.AddressDataAccess;
import DataAccess.EventDataAccess;
import DataAccess.EventTypeDataAccess;
import DataAccess.UserDataAccess;
import Models.AddressModel;
import Models.UserModel;
import Models.EventTypeModel;
import Models.EventModel;

import java.util.ArrayList;


public class EventBusiness {

    private EventDataAccess eventDataAccess;
    private UserDataAccess userDataAccess;
    private EventTypeDataAccess eventTypeDataAccess;
    private AddressDataAccess addressDataAccess;

    private ArrayList<EventModel> events;
    private ArrayList<EventTypeModel> eventType;
    private ArrayList<UserModel> users;

    private ArrayList<AddressModel> addressModels;

    public EventBusiness() {
        eventDataAccess = new EventDataAccess();
        userDataAccess = new UserDataAccess();
        eventTypeDataAccess = new EventTypeDataAccess();
        addressDataAccess = new AddressDataAccess();


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
        eventDataAccess.addEvent();
    }

    /*----------------------------------------------------*/

}
