package dataAccess.Interfaces;

import exception.DataAccessException;
import model.SearchDateModel;

import java.util.ArrayList;

public interface ISearchDates {

    ArrayList<SearchDateModel> getSearchDates(java.sql.Date startDate, java.sql.Date endDate) throws DataAccessException;
}
