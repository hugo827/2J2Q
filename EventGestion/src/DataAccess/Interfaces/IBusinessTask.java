package DataAccess.Interfaces;

import Models.BusinessTaskModel;

import java.sql.SQLException;

public interface IBusinessTask {

    BusinessTaskModel getDataEvent(int idEvent) throws SQLException;
}
