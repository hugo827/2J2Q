package dataAccess;

import dataAccess.Interfaces.IUserType;
import exception.DataAccessException;
import model.UserTypeModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserTypeDataAccess implements IUserType {

    public ArrayList<UserTypeModel> getUserTypeList() throws DataAccessException {

        ArrayList<UserTypeModel> userType = new ArrayList<>();

        try {
            Connection connectionDB = ConnectionDB.getInstance();
            String query = "SELECT * FROM userType ut ORDER BY ut.iduserType";
            PreparedStatement statement = connectionDB.prepareStatement(query);
            ResultSet data = statement.executeQuery();

            while (data.next()){
                Integer id = data.getInt(1);
                String userTypeName = data.getString(2);
                userType.add(new UserTypeModel(id, userTypeName));
            }

        } catch(SQLException throwable) {
            throw new DataAccessException(throwable.getMessage());
        }


        return userType;
    }
}
