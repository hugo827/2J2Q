package dataAccess.Interfaces;

import exception.DataAccessException;
import model.SearchEndDatesModel;

import java.util.ArrayList;

public interface ISearchEndDates {

    ArrayList<SearchEndDatesModel> getSearchEndDates( java.sql.Date endDate) throws DataAccessException;
}