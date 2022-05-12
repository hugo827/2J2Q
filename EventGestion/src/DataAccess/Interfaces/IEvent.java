package DataAccess.Interfaces;

import Exceptions.AddEventException;
import Models.EventModel;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IEvent {
     void addEvent(EventModel eventModel) throws AddEventException; // CREATE
     ArrayList<EventModel> getAllEvent(); // READ
     EventModel getEvent(int idEvent); //READ
     void updateEvent(EventModel event); // UPDATE
     void deleteEvent(int idEvent) throws SQLException; // DELETE
}
