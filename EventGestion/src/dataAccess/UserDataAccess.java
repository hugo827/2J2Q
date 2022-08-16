package dataAccess;

import dataAccess.Interfaces.IUser;
import exception.AddUserException;
import exception.DataAccessException;
import exception.EventException;
import model.UserModel;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UserDataAccess implements IUser {

    @Override
    public void addUser(UserModel user) throws AddUserException {
        try {
            Connection connectionDB = ConnectionDB.getInstance();
            String query = ("INSERT INTO user(firstName, lastName, birthDate, isPMR, profession, nbChildren, fk_userType)" +
                    "VALUES(?,?,?,?,?,?,?)");
            PreparedStatement statement = connectionDB.prepareStatement(query);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate=simpleDateFormat.format(user.getBirthDate());
            Date birthDate=java.sql.Date.valueOf(formattedDate);

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setDate(3, (java.sql.Date) birthDate);
            statement.setBoolean(4, user.getIsPMR());
            statement.setString(5, user.getProfession());
            statement.setInt(6, user.getNbChildren());
            statement.setInt(7, user.getFk_userType());

            statement.executeUpdate();

        } catch(SQLException throwable) {
            throw new AddUserException();
        }
    }

    @Override
    public ArrayList<UserModel> getUsers() throws DataAccessException {
        ArrayList<UserModel> UserList = new ArrayList<>();

        try {
            Connection connectionDB = ConnectionDB.getInstance();
            String query = "SELECT * FROM `user` ORDER BY user.iduser";
            PreparedStatement statement = connectionDB.prepareStatement(query);
            ResultSet data = statement.executeQuery();

            while (data.next()){
                Integer idUser = data.getInt(1);
                String firstname = data.getString(2);
                String lastname = data.getString(3);
                Date birthDate=data.getDate(4);
                Boolean isPMR=data.getBoolean(5);
                String profession=data.getString(6);
                Integer nbChildren=data.getInt(7);
                Integer fk_userType=data.getInt(8);
                UserList.add(new UserModel(idUser,firstname,lastname,birthDate,isPMR,profession,nbChildren,fk_userType));
            }

        } catch(SQLException | EventException throwable) {
           throw new DataAccessException(throwable.getMessage());
        }

        return UserList;
    }
    public UserModel getUser(int idUser) throws DataAccessException{
        UserModel user=null;

        try {
            Connection connectionDB = ConnectionDB.getInstance();
            String query = "SELECT * FROM `user` WHERE 'iduser'=?";
            PreparedStatement statement = connectionDB.prepareStatement(query);
            statement.setInt(1, idUser);
            ResultSet data = statement.executeQuery();

            while (data.next()){
                Integer id = data.getInt(1);
                String firstname = data.getString(2);
                String lastname = data.getString(3);
                Date birthDate=data.getDate(4);
                Boolean isPMR=data.getBoolean(5);
                String profession=data.getString(6);
                Integer nbChildren=data.getInt(7);
                Integer fk_userType=data.getInt(8);
                user=new UserModel(id,firstname,lastname,birthDate,isPMR,profession,nbChildren,fk_userType);
            }

        } catch(SQLException  | EventException throwable) {
            throw new DataAccessException(throwable.getMessage());
        }
        return user;
    }
}
