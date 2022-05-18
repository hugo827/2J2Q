package dataAccess.Interfaces;

import model.SearchPromotionModel;

import java.util.ArrayList;

public interface ISearchUserType {

    ArrayList<SearchPromotionModel> getSearchUsertype(int idUserType);
}
