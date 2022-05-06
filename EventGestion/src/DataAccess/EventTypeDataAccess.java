package DataAccess;

import DataAccess.Interfaces.IEventType;
import Models.EventTypeModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventTypeDataAccess implements IEventType {

    @Override
    public ArrayList<EventTypeModel> getEventType() {

        ArrayList<EventTypeModel> eventTypeList = new ArrayList<>();

        try {
            Connection connectionDB = ConnectionDB.getInstance();
            String query = "SELECT * FROM `eventtype`";
            PreparedStatement statement = connectionDB.prepareStatement(query);
            ResultSet data = statement.executeQuery();

            while (data.next()){
                int id = data.getInt(1);
                String name = data.getString(2);
                eventTypeList.add(new EventTypeModel(id,name));
            }

        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }
        return eventTypeList;
    }
}
