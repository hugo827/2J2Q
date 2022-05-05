package DataAccess;

import DataAccess.Interfaces.IEvent;
import Models.EventModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class EventListingDataAccess implements IEvent {

    @Override
    public void addEvent() {

    }

    public ArrayList<EventModel> getAllEvent() {

        ArrayList<EventModel> eventList = new ArrayList<EventModel>();

        try {
            Connection connectionDB = ConnectionDB.getInstance();
            String query = ("SELECT * FROM event");
            PreparedStatement statement = connectionDB.prepareStatement(query);
            ResultSet data = statement.executeQuery(query);

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

    @Override
    public void deleteEvent(String idEvent) {
        try {

            Connection connectionDB = ConnectionDB.getInstance();
            String query = "DELETE FROM `event` WHERE idEvent = ?";
            PreparedStatement statement = connectionDB.prepareStatement(query);
            statement.setString(1, idEvent);
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
