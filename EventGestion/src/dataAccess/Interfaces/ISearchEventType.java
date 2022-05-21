package dataAccess.Interfaces;

import exception.DataAccessException;
import model.SearchEventTypeModel;

import java.util.ArrayList;

public interface ISearchEventType {
    ArrayList<SearchEventTypeModel> getSearchByEventType(int idEventType) throws DataAccessException;

}
