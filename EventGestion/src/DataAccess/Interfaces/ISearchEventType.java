package DataAccess.Interfaces;

import Models.SearchEventTypeModel;

import java.util.ArrayList;

public interface ISearchEventType {
    ArrayList<SearchEventTypeModel> getSearchByEventType(int idEventType);

}
