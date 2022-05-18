package dataAccess.Interfaces;

import model.BusinessTaskModel;

import java.sql.SQLException;

public interface IBusinessTask {

    BusinessTaskModel getDataEvent(int idEvent) throws SQLException;
}
