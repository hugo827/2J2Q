package DataAccess;

import DataAccess.Interfaces.ISearchDates;
import Models.SearchDateModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class SearchByDatesDataAccess implements ISearchDates {

    public ArrayList<SearchDateModel> getSearchDates(java.sql.Date startDate,java.sql.Date endDate)  {

        ArrayList<SearchDateModel> searchDateList = new ArrayList<>();

        try {
            Connection connectionDB = ConnectionDB.getInstance();
            String query = ("SELECT e.title, e.startDate, e.isPrivate, CONCAT(l.name,'(',l.zipCode,') - ', a.numberStreet) as `Address` " +
                    "FROM event e INNER JOIN address a ON e.fk_address = a.idAddress INNER JOIN locality l ON a.fk_locality = l.idLocality" +
                    " WHERE startDate >= ? AND endDate <= ? ORDER BY e.startDate");
            PreparedStatement statement = connectionDB.prepareStatement(query);
            statement.setDate(1, startDate);
            statement.setDate(2, endDate);
            ResultSet data = statement.executeQuery();

            while (data.next()){
                String title = data.getString(1);
                Date startDateRec = data.getDate(2);
                Boolean isPrivate = data.getBoolean(3);
                String address = data.getString(4);
                searchDateList.add(new SearchDateModel(title, startDateRec, isPrivate, address));
            }

        } catch(SQLException throwable) {
            throwable.printStackTrace();
        }
        return searchDateList;
    }
}
