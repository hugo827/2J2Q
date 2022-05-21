package dataAccess.Interfaces;

import exception.DataAccessException;
import model.SearchPromotionModel;

import java.util.ArrayList;

public interface ISearchUserType {

    ArrayList<SearchPromotionModel> getSearchUsertype(int idUserType) throws DataAccessException;
}
