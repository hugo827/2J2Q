package dataAccess.Interfaces;

import exception.DataAccessException;
import model.UserTypeModel;

import java.util.ArrayList;

public interface IUserType {

    ArrayList<UserTypeModel> getUserTypeList() throws DataAccessException;
}
