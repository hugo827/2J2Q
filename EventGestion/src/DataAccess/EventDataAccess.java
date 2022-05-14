package DataAccess;

import DataAccess.Interfaces.IEvent;
import Exceptions.AddEventException;
import Exceptions.QueryException;
import Exceptions.EventException;
import Models.EventModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EventDataAccess implements IEvent {

    @Override
    public void addEvent(EventModel event) throws  QueryException {
        try {
            Connection connectionDB = ConnectionDB.getInstance();
            String query = ("INSERT INTO event(title, description, additionalInformation, isImportant, startDate, endDate, price, participantNbMax, isPrivate, fk_creator, fk_eventType, fk_address)" +
                    "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            PreparedStatement statement = connectionDB.prepareStatement(query);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = simpleDateFormat.format(event.getStartDate());
            java.sql.Date startDate = java.sql.Date.valueOf(formattedDate);


            statement.setString(1, event.getTitle());
            statement.setString(2, event.getDescription());
            statement.setString(3, event.getAdditionalInformation());
            statement.setBoolean(4, event.getImportant());
            statement.setDate(5, startDate);

            formattedDate = simpleDateFormat.format(event.getEndDate());
            java.sql.Date endDate = java.sql.Date.valueOf(formattedDate);
            statement.setDate(6, endDate);
            statement.setDouble(7, event.getPrice());
            statement.setInt(8, event.getParticipantNbMax());
            statement.setBoolean(9, event.getPrivate());
            statement.setInt(10, event.getFk_creator());
            statement.setInt(11, event.getFk_eventType());
            statement.setInt(12, event.getFk_address());

            statement.executeUpdate();

        } catch(SQLException throwable) {
            throw new QueryException(throwable.getMessage());
        }
    }

    public ArrayList<EventModel> getAllEvent() {

        ArrayList<EventModel> eventList = new ArrayList<>();

        try {
            Connection connectionDB = ConnectionDB.getInstance();
            String query = ("SELECT e.idEvent, e.title, e.description, e.additionalInformation, e.isImportant, e.startDate, e.endDate, e.price, e.participantNbMax, " +
                    "e.isPrivate,e.fk_creator, e.fk_eventtype, e.fk_address, et.name as `Event Type`, CONCAT(l.name,'(',l.zipCode,') - ', a.numberStreet) as `Address`," +
                    " CONCAT(u.firstName,' ', u.lastName) as `Creator Name` " +
                    "FROM eventgestiondb.event e INNER JOIN eventtype et ON e.fk_eventType = et.idEventType INNER JOIN address a ON e.fk_address = a.idaddress INNER " +
                    "JOIN locality l ON a.fk_locality = l.idlocality INNER JOIN user u ON e.fk_creator = u.iduser ");
            PreparedStatement statement = connectionDB.prepareStatement(query);
            ResultSet data = statement.executeQuery();

            while (data.next()){
                int id = data.getInt(1);
                String title = data.getString(2);
                String description = data.getString(3);
                String additionalInformation = data.getString(4);
                Boolean  isImportant = data.getBoolean(5);
                Date startDate = data.getDate(6);
                Date endDate = data.getDate(7);
                double price = data.getDouble(8);
                int participantNbMax = data.getInt(9);
                Boolean isPrivate = data.getBoolean(10);
                int fk_creator = data.getInt(11);
                int fk_eventtype = data.getInt(12);
                int fk_address = data.getInt(13);
                String eventType = data.getString(14);
                String address = data.getString(15);
                String creator = data.getString(16);

                eventList.add(new EventModel(id, title, description, additionalInformation, isImportant, startDate, endDate, price, participantNbMax, isPrivate, fk_creator, fk_eventtype, fk_address, creator, address, eventType));
            }

        } catch(SQLException throwable) {
            throwable.printStackTrace();
        } catch (EventException e) {
            throw new RuntimeException(e);
        }
        return eventList;
    }

    @Override
    public void updateEvent(EventModel event) {
        try {
            Connection connectionDB = ConnectionDB.getInstance();
            String query = ("UPDATE `event` SET `title` = ? , `description` = ? , `additionalInformation` = ? , `isImportant` = ? , `startDate` = ? , `endDate` = ? , `price` = ? ," +
                    "`participantNbMax` = ? , `isPrivate` = ? , `fk_creator` = ? , `fk_eventType` = ? , `fk_address` = ? " +
                    " WHERE `idEvent` = ? ");
            PreparedStatement statement = connectionDB.prepareStatement(query);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = simpleDateFormat.format(event.getStartDate());
            java.sql.Date startDate = java.sql.Date.valueOf(formattedDate);


            statement.setString(1, event.getTitle());
            statement.setString(2, event.getDescription());
            statement.setString(3, event.getAdditionalInformation());
            statement.setBoolean(4, event.getImportant());
            statement.setDate(5, startDate);
            formattedDate = simpleDateFormat.format(event.getEndDate());
            java.sql.Date endDate = java.sql.Date.valueOf(formattedDate);
            statement.setDate(6, endDate);
            statement.setDouble(7, event.getPrice());
            statement.setInt(8, event.getParticipantNbMax());
            statement.setBoolean(9, event.getPrivate());
            statement.setInt(10, event.getFk_creator());
            statement.setInt(11, event.getFk_eventType());
            statement.setInt(12, event.getFk_address());
            statement.setInt(13, event.getIdEvent());

            statement.executeUpdate();

        } catch(SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public EventModel getEvent(int idEvent) {
        EventModel event = null;

        try {
            Connection connectionDB = ConnectionDB.getInstance();
            String query = "SELECT * FROM `event` WHERE `idEvent` = ?";
            PreparedStatement statement = connectionDB.prepareStatement(query);
            statement.setInt(1, idEvent);
            ResultSet data = statement.executeQuery();


            while (data.next()) {
                int id = data.getInt(1);
                String title = data.getString(2);
                String description = data.getString(3);
                String additionalInformation = data.getString(4);
                Boolean isImportant = data.getBoolean(5);
                Date startDate = data.getDate(6);
                Date endDate = data.getDate(7);
                double price = data.getDouble(8);
                int participantNbMax = data.getInt(9);
                Boolean isPrivate = data.getBoolean(10);
                int fk_creator = data.getInt(11);
                int fk_eventtype = data.getInt(12);
                int fk_address = data.getInt(13);
                event = new EventModel(id, title, description, additionalInformation, isImportant, startDate, endDate, price, participantNbMax, isPrivate, fk_creator, fk_eventtype, fk_address);
            }

        } catch(SQLException throwable) {
            throwable.printStackTrace();
        } catch (EventException e) {
            throw new RuntimeException(e);
        }
        return event;
    }

    @Override
    public void deleteEvent(int idEvent) throws SQLException {
        Connection connectionDB = ConnectionDB.getInstance();
        try {
            connectionDB.setAutoCommit(false);

            String query1 = "DELETE FROM `promotion` WHERE `fk_event` = ?";
            String query2 = "DELETE FROM `participation` WHERE `fk_event` = ?";
            String query3 = "DELETE FROM `event` WHERE `idEvent` = ?";

            PreparedStatement statement1 = connectionDB.prepareStatement(query1);
            PreparedStatement statement2 = connectionDB.prepareStatement(query2);
            PreparedStatement statement3 = connectionDB.prepareStatement(query3);

            statement1.setInt(1, idEvent);
            statement2.setInt(1, idEvent);
            statement3.setInt(1, idEvent);

            statement1.executeUpdate();
            statement2.executeUpdate();
            statement3.executeUpdate();

            connectionDB.commit();

        } catch (SQLException throwable) {
            throwable.printStackTrace();
            connectionDB.rollback();
        }
    }


}
