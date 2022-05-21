package dataAccess.Interfaces;

import exception.DataAccessException;
import model.UserModel;

import java.util.ArrayList;

public interface IUser {

    ArrayList<UserModel> getUsers() throws DataAccessException;

}
