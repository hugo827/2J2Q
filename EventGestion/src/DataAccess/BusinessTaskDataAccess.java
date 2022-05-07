package DataAccess;

import Models.BusinessTaskModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BusinessTaskDataAccess {

    public BusinessTaskModel getDataEvent(int idEvent) {

        BusinessTaskModel res = null;
        try {
            Connection connectionDB = ConnectionDB.getInstance();
            String query = ("SELECT COUNT(*) , SUM(e.price) , SUM(e.price * pr.reductionPourcent) , SUM(e.price * (1-pr.reductionPourcent))" +
                    " FROM event e INNER JOIN participation p ON e.idEvent = p.fk_event INNER JOIN user u ON p.fk_user = u.idUser" +
                    " INNER JOIN usertype ut ON u.fk_usertype = ut.idUserType INNER JOIN promotion pr ON ut.idusertype = pr.fk_userType WHERE e.idEvent = ?");
            PreparedStatement statement = connectionDB.prepareStatement(query);
            statement.setInt(1, idEvent);
            ResultSet data = statement.executeQuery();

            while (data.next()){
                int nbParticipant = data.getInt(1);
                double sumTotal = data.getDouble(2);
                double sumTotalPromotion = data.getDouble(3);
                Double sumFinal = data.getDouble(4);
                res = new BusinessTaskModel(nbParticipant, sumFinal,sumTotal,sumTotalPromotion);
            }

        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }
}
