package DataAccess;

import DataAccess.Interfaces.IEvent;
import Models.EventModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class EventDataAccess implements IEvent {

    @Override
    public void addEvent() {

    }

    public ArrayList<EventModel> getAllEvent() {

        ArrayList<EventModel> eventList = new ArrayList<EventModel>();

        try {
            Connection connectionDB = ConnectionDB.getInstance();
            String query = ("SELECT * FROM event");
            PreparedStatement statement = connectionDB.prepareStatement(query);
            ResultSet data = statement.executeQuery();

            while (data.next()){
                int id = data.getInt(1);
                String title = data.getString(2);
                String description = data.getString(3);
                String additionnalInformation = data.getString(4);
                Boolean  isImportant = data.getBoolean(5);
                Date startDate = data.getDate(6);
                Date endDate = data.getDate(7);
                Double price = data.getDouble(8);
                int participantNbMax = data.getInt(9);
                Boolean isPrivate = data.getBoolean(10);
                eventList.add(new EventModel(id, title, description, additionnalInformation, isImportant, startDate, endDate, price, participantNbMax, isPrivate));
            }

        } catch(SQLException throwables) {
            throwables.printStackTrace();

        }
        return eventList;
    }

    @Override
    public void updateEvent() {

    }

    public EventModel getEvent(int idEvent) {
        EventModel event = null;
        System.out.println(idEvent);
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
                String additionnalInformation = data.getString(4);
                Boolean isImportant = data.getBoolean(5);
                Date startDate = data.getDate(6);
                Date endDate = data.getDate(7);
                Double price = data.getDouble(8);
                int participantNbMax = data.getInt(9);
                Boolean isPrivate = data.getBoolean(10);
                event = new EventModel(id, title, description, additionnalInformation, isImportant, startDate, endDate, price, participantNbMax, isPrivate);
            }

        } catch(SQLException throwables) {
            throwables.printStackTrace();

        }
        return event;
    }

    @Override
    public void deleteEvent(int idEvent) {
        try {
            Connection connectionDB = ConnectionDB.getInstance();
            // TODO : Voir si on peut le faire en une requete ! des gas disent que non mais bon ca me semble bizarre !
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

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
