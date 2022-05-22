package dataAccess;

import dataAccess.Interfaces.IUser;
import exception.DataAccessException;
import model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDataAccess implements IUser {

    @Override
    public ArrayList<UserModel> getUsers() throws DataAccessException {
        ArrayList<UserModel> UserList = new ArrayList<>();

        try {
            Connection connectionDB = ConnectionDB.getInstance();
            String query = "SELECT * FROM `user` ORDER BY user.iduser";
            PreparedStatement statement = connectionDB.prepareStatement(query);
            ResultSet data = statement.executeQuery();

            while (data.next()){
                Integer id = data.getInt(1);
                String firstname = data.getString(2);
                String lastname = data.getString(3);
                UserList.add(new UserModel(id,firstname, lastname));
            }

        } catch(SQLException throwable) {
           throw new DataAccessException(throwable.getMessage());
        }

        return UserList;
    }
}
