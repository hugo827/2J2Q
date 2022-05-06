package DataAccess;

import Models.UserModel;
import Models.UserTypeModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserTypeDataAccess {

    public ArrayList<UserTypeModel> getUserTypeList() {

        ArrayList<UserTypeModel> userType = new ArrayList<>();

        try {
            Connection connectionDB = ConnectionDB.getInstance();
            String query = "SELECT * FROM `userType`";
            PreparedStatement statement = connectionDB.prepareStatement(query);
            ResultSet data = statement.executeQuery();

            while (data.next()){
                int id = data.getInt(1);
                String userTypeName = data.getString(2);
                userType.add(new UserTypeModel(id, userTypeName));
            }

        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }


        return userType;
    }
}
