package dataAccess.Interfaces;

import exception.AddEventException;
import exception.DataAccessException;
import exception.UpdateEventException;
import model.EventModel;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IEvent {
     void addEvent(EventModel eventModel) throws AddEventException; // CREATE
     ArrayList<EventModel> getAllEvent(); // READ
     EventModel getEvent(int idEvent); //READ
     void updateEvent(EventModel event) throws UpdateEventException; // UPDATE
     void deleteEvent(int idEvent) throws SQLException; // DELETE

     ArrayList<EventModel> getUserEventsList(int idUser) throws DataAccessException;
}
