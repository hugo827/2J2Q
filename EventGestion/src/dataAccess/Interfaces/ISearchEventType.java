package dataAccess.Interfaces;

import model.SearchEventTypeModel;

import java.util.ArrayList;

public interface ISearchEventType {
    ArrayList<SearchEventTypeModel> getSearchByEventType(int idEventType);

}
