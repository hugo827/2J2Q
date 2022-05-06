package DataAccess.Interfaces;

import Models.EventModel;

import java.util.ArrayList;

public interface IEvent {
     void addEvent(EventModel eventModel); // CREATE
     ArrayList<EventModel> getAllEvent(); // READ
     void updateEvent(); // UPDATE
     void deleteEvent(int idEvent); // DELETE
}
