package DataAccess;


import Models.SearchPromotionModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class SearchByUserTypeDataAccess {

    public ArrayList<SearchPromotionModel> getSearchUsertype(int idUserType) {

        ArrayList<SearchPromotionModel> searchPromotionList = new ArrayList<>();
        try {
            Connection connectionDB = ConnectionDB.getInstance();
            String query = ("SELECT e.title, e.startDate, e.endDate, p.reductionPourcent * 100, e.price*(1-p.reductionPourcent) ,et.name FROM promotion p INNER JOIN event e " +
                    "ON p.fk_event = e.idEvent INNER JOIN usertype ut ON p.fk_userType = ut.idUserType INNER JOIN eventtype et ON e.fk_eventType = et.idEventType" +
                    " WHERE p.fk_userType = ?");
            PreparedStatement statement = connectionDB.prepareStatement(query);
            statement.setInt(1, idUserType);
            ResultSet data = statement.executeQuery();

            while (data.next()){
                String title = data.getString(1);
                Date startDate = data.getDate(2);
                Date endDate = data.getDate(3);
                double reduction = data.getDouble(4);
                double finalPrice = data.getDouble(5);
                String eventType = data.getString(6);
                searchPromotionList.add(new SearchPromotionModel(reduction, title, startDate, endDate, finalPrice, eventType ));
            }

        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }
        return searchPromotionList;
    }
}
