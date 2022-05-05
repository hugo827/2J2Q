package BusinessLogic;

import DataAccess.EventListingDataAccess;
import Models.EventModel;

import java.util.ArrayList;

public class EventBusiness {

    private EventListingDataAccess eventListingDataAccess;
    private ArrayList<EventModel> events;


    public EventBusiness() {
        eventListingDataAccess = new EventListingDataAccess();
        loadEventList();
    }

    public ArrayList<EventModel> getEvents() {
        return events;
    }

    public void loadEventList() {
        events = eventListingDataAccess.getAllEvent();
    }
}
