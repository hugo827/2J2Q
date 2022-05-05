package BusinessLogic;

import DataAccess.EventDataAccess;
import Models.EventModel;

import java.util.ArrayList;


public class EventBusiness {

    private EventDataAccess eventDataAccess;
    private ArrayList<EventModel> events;


    public EventBusiness() {
        eventDataAccess = new EventDataAccess();
        loadEventList();
    }

    /* ---------------------- CRUD ----------------------*/
    public ArrayList<EventModel> getEvents() {
        return events;
    }

    public void loadEventList() {
        events = eventDataAccess.getAllEvent();
    }
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
