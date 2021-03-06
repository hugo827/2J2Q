package dataAccess;

import dataAccess.Interfaces.IAddress;
import exception.DataAccessException;
import model.AddressModel;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddressDataAccess implements IAddress {
    @Override
    public ArrayList<AddressModel> getAddressList() throws DataAccessException {
        ArrayList<AddressModel> addressList = new ArrayList<>();

        try {
            Connection connectionDB = ConnectionDB.getInstance();
            String query = ("SELECT a.idaddress, a.numberStreet, l.zipCode, l.name FROM address a inner join locality l ON a.fk_locality = l.idlocality ORDER BY a.idaddress");
            PreparedStatement statement = connectionDB.prepareStatement(query);
            ResultSet data = statement.executeQuery();

            while (data.next()){
                Integer id = data.getInt(1);
                String numberStreet = data.getString(2);
                Integer zipcode = data.getInt(3);
                String name = data.getString(4);
                addressList.add(new AddressModel(id,zipcode, numberStreet, name));
            }

        } catch(SQLException throwable) {
            throw new DataAccessException(throwable.getMessage());
        }

        return addressList;
    }
}
