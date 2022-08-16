package dataAccess.Interfaces;

import exception.AddUserException;
import exception.DataAccessException;
import model.UserModel;

import java.util.ArrayList;

public interface IUser {

    ArrayList<UserModel> getUsers() throws DataAccessException;
    void addUser(UserModel userModel) throws AddUserException; // CREATE

    UserModel getUser(int idUser) throws DataAccessException; //READ
}
