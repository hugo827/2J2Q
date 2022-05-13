package DataAccess;


import DataAccess.Interfaces.ISearchEventType;
import Models.SearchEventTypeModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class SearchEventTypeDataAccess implements ISearchEventType {

    public ArrayList<SearchEventTypeModel> getSearchByEventType(int idEventType) {

        ArrayList<SearchEventTypeModel> searchByEventTypeList = new ArrayList<>();

        try {
            Connection connectionDB = ConnectionDB.getInstance();
            String query = ("SELECT e.title, e.startDate, e.endDate, u.firstName, u.lastName, ut.Name FROM event e INNER JOIN user u ON e.fk_creator = u.idUser INNER JOIN usertype ut ON u.fk_userType = ut.idUserType WHERE fk_eventType = ?");
            PreparedStatement statement = connectionDB.prepareStatement(query);
            statement.setInt(1, idEventType);
            ResultSet data = statement.executeQuery();

            while (data.next()){
                String title = data.getString(1);
                Date startDate = data.getDate(2);
                Date endDate = data.getDate(3);
                String firstname = data.getString(4);
                String lastname = data.getString(5);
                String userTypeName = data.getString(6);
                searchByEventTypeList.add(new SearchEventTypeModel(title,startDate, endDate, firstname, lastname, userTypeName));
            }

        } catch(SQLException throwable) {
            throwable.printStackTrace();
        }
        return searchByEventTypeList;
    }
}
