package DataAccess.Interfaces;

import Models.EventModel;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IEvent {
     void addEvent(EventModel eventModel); // CREATE
     ArrayList<EventModel> getAllEvent(); // READ
     void updateEvent(EventModel event); // UPDATE
     void deleteEvent(int idEvent) throws SQLException; // DELETE
}
