package Controllers;

import BusinessLogic.EventBusiness;
import Models.EventModel;

import java.util.ArrayList;

public class EventController {

    private EventBusiness eventBusiness;

    public EventController() {
        eventBusiness = new EventBusiness();
    }

    public ArrayList<EventModel> getEventList() {
        return eventBusiness.getEvents();
    }
}
