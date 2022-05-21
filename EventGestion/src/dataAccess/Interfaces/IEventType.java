package dataAccess.Interfaces;

import exception.DataAccessException;
import model.EventTypeModel;

import java.util.ArrayList;

public interface IEventType {
    ArrayList<EventTypeModel> getEventType() throws DataAccessException;
}
