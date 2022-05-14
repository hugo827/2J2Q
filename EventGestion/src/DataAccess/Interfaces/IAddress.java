package DataAccess.Interfaces;

import Exceptions.DataAccessException;
import Models.AddressModel;

import java.util.ArrayList;

public interface IAddress {
    ArrayList<AddressModel> getAddressList();
}
