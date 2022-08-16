package dataAccess;

import dataAccess.Interfaces.ISearchEndDates;
import exception.DataAccessException;
import model.SearchEndDatesModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class SearchByEndDatesDataAccess implements ISearchEndDates {

    public ArrayList<SearchEndDatesModel> getSearchEndDates(java.sql.Date endDate) throws DataAccessException {

        ArrayList<SearchEndDatesModel> searchByEndDateList = new ArrayList<>();

        try {
            Connection connectionDB = ConnectionDB.getInstance();
            String query = ("SELECT et.name, e.title, e.startDate, e.isImportant, u.lastName, u.firstName, ut.name "+
                    "FROM event e "+
                    "INNER JOIN eventtype et ON e.fk_eventType=et.idEventType "+
                    "INNER JOIN  user u ON e.fk_creator=u.iduser "+
                    "INNER JOIN usertype ut ON u.fk_userType=ut.idusertype "+
                    "WHERE endDate >= ? ORDER BY e.startDate");
            PreparedStatement statement = connectionDB.prepareStatement(query);
            statement.setDate(1, endDate);
            ResultSet data = statement.executeQuery();

            while (data.next()){
                String eventType = data.getString(1);
                String title = data.getString(2);
                Date startDate = data.getTimestamp(3);
                Boolean isImportant = data.getBoolean(4);
                String lastName = data.getString(5);
                String firstName = data.getString(6);
                String userType=data.getString(7);
                searchByEndDateList.add(new SearchEndDatesModel(eventType, title, startDate, isImportant, lastName, firstName, userType));
            }

        } catch(SQLException throwable) {
            throw new DataAccessException(throwable.getMessage());
        }
        return searchByEndDateList;
    }
}