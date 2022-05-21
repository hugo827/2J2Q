package dataAccess.Interfaces;

import exception.DataAccessException;
import model.AddressModel;

import java.util.ArrayList;

public interface IAddress {
    ArrayList<AddressModel> getAddressList() throws DataAccessException;
}
