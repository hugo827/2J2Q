package DataAccess.Interfaces;

import Models.SearchPromotionModel;

import java.util.ArrayList;

public interface ISearchUserType {

    ArrayList<SearchPromotionModel> getSearchUsertype(int idUserType);
}
