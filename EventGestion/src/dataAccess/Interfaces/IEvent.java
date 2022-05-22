package dataAccess.Interfaces;

import exception.AddEventException;
import exception.DataAccessException;
import exception.UpdateEventException;
import model.EventModel;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IEvent {
     void addEvent(EventModel eventModel) throws AddEventException; // CREATE
     ArrayList<EventModel> getAllEvent() throws DataAccessException; // READ
     EventModel getEvent(int idEvent) throws DataAccessException; //READ
     void updateEvent(EventModel event) throws UpdateEventException; // UPDATE
     void deleteEvent(int idEvent) throws DataAccessException; // DELETE

     ArrayList<EventModel> getUserEventsList(int idUser) throws DataAccessException;
}
