package DataAccess;

import DataAccess.Interfaces.IBusinessTask;
import Models.BusinessTaskModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BusinessTaskDataAccess implements IBusinessTask {

    public BusinessTaskModel getDataEvent(int idEvent) {

        int nbParticipant = 0;
        double sumTotal = 0, sumTotalPromotion = 0, price =0;
        BusinessTaskModel res = null;

        try {
            Connection connectionDB = ConnectionDB.getInstance();
            String query = ("SELECT  COUNT(*), price, SUM(price) FROM event e " +
                    "INNER JOIN participation p ON e.idEvent = p.fk_event " +
                    "INNER JOIN user u ON p.fk_user = u.idUser " +
                    "INNER JOIN usertype ut ON u.fk_usertype = ut.idUserType " +
                    "WHERE e.idEvent = ? ;");

            PreparedStatement statement = connectionDB.prepareStatement(query);
            statement.setInt(1, idEvent);
            ResultSet data = statement.executeQuery();
            while (data.next()){
                 nbParticipant = data.getInt(1);
                 price = data.getDouble(2);
                 sumTotal = data.getDouble(3);
            }

            query = (" SELECT SUM(? * pr.reductionPourcent) FROM promotion pr WHERE pr.fk_event = ?;");
            statement = connectionDB.prepareStatement(query);
            statement.setDouble(1, price);
            statement.setInt(2, idEvent);
            data = statement.executeQuery();
            while (data.next()){
                sumTotalPromotion = data.getDouble(1);
            }

            res = new BusinessTaskModel(nbParticipant, sumTotal - sumTotalPromotion,sumTotal,sumTotalPromotion);

        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }
}
