package businessLogic;

import dataAccess.*;
import dataAccess.Interfaces.*;
import exception.*;
import model.*;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class EventsManagementBusiness {

    private IEvent eventDataAccess;
    private IUser userDataAccess;
    private IEventType eventTypeDataAccess;
    private IAddress addressDataAccess;
    private IBusinessTask businessTaskDataAccess;
    private ISearchDates searchByDatesDataAccess;
    private ISearchEventType searchEventTypeDataAccess;
    private ISearchUserType searchByUserTypeDataAccess;
    private IUserType userTypeDataAccess;



    public EventsManagementBusiness() {
        eventDataAccess = new EventDataAccess();
        userDataAccess = new UserDataAccess();
        eventTypeDataAccess = new EventTypeDataAccess();
        addressDataAccess = new AddressDataAccess();

        searchByDatesDataAccess = new SearchByDatesDataAccess();
        userTypeDataAccess = new UserTypeDataAccess();
        searchByUserTypeDataAccess = new SearchByUserTypeDataAccess();
        businessTaskDataAccess = new BusinessTaskDataAccess();

        searchEventTypeDataAccess = new SearchByEventTypeDataAccess();

    }

    /* ---------------------- CRUD ----------------------*/
    public ArrayList<EventModel> getEvents() {
        return eventDataAccess.getAllEvent();
    }
    public ArrayList<UserModel> getUsers() throws DataAccessException { return userDataAccess.getUsers(); }
    public ArrayList<EventTypeModel> getEventType() throws DataAccessException { return eventTypeDataAccess.getEventType(); }
    public ArrayList<AddressModel> getAddressList() throws DataAccessException { return addressDataAccess.getAddressList(); }



    public void deleteEvent(int idEvent) throws SQLException, DataAccessException {
        if(idEvent <= 0) {
            throw new DataAccessException("The value '" + idEvent + "' isn't correct !");
        } else {
            eventDataAccess.deleteEvent(idEvent);
        }
    }
    public void updateEvent(EventModel event) throws DataAccessException, UpdateEventException {
        if(event == null) {
            throw new DataAccessException("The object event can't be null");
        } else {
            eventDataAccess.updateEvent(event);
        }
    }

    public EventModel getEvent(int idEvent) throws DataAccessException {
        if(idEvent <= 0) {
            throw new DataAccessException("The value '" + idEvent + "' isn't correct !");
        }
        return eventDataAccess.getEvent(idEvent);
    }
    public void addEvent(EventModel event) throws AddEventException, DataAccessException {
        if(event == null){
           throw new DataAccessException("The object event can't be null");
        } else {
            eventDataAccess.addEvent(event);
        }
    }


    /*-------------------------- SEARCH EVENT TYPE -------------*/

    public ArrayList<SearchEventTypeModel> getSearchByEventType(int idEventType) throws DataAccessException {
        if(idEventType <= 0) {
            throw new DataAccessException("The value '" + idEventType + "' isn't correct !");
        }
        return  searchEventTypeDataAccess.getSearchByEventType(idEventType);
    }



    /*-------------------------- SEARCH by dates -------------*/

    public ArrayList<SearchDateModel> getSearchByDates(Date startDate, Date endDate) throws SearchDateException, DataAccessException {
        if(startDate == null || endDate == null || endDate.before(startDate)) {
            throw new SearchDateException(startDate, endDate);
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedStartDate = simpleDateFormat.format(startDate);
            String formattedEndDate = simpleDateFormat.format(endDate);
            java.sql.Date startDateConvert = java.sql.Date.valueOf(formattedStartDate);
            java.sql.Date endDateConvert = java.sql.Date.valueOf(formattedEndDate);
            return  searchByDatesDataAccess.getSearchDates(startDateConvert, endDateConvert);
        }
    }


    /*-------------------------------- SEARCH promotion -------------------------------------*/

    public ArrayList<UserTypeModel> getUserType() throws DataAccessException {
        return userTypeDataAccess.getUserTypeList();
    }


    public ArrayList<SearchPromotionModel> getSearchByUserType(int idUserType) throws DataAccessException {
        if(idUserType <= 0) {
            throw new DataAccessException("The value '" + idUserType + "' isn't correct for find an user type");
        } else {
            return searchByUserTypeDataAccess.getSearchUsertype(idUserType);
        }
    }

    public ArrayList<EventModel> getUserEventsList(int idUser) throws DataAccessException {
        if(idUser <= 0) {
            throw new DataAccessException("The value '" + idUser + "' isn't correct for finding user's event");
        } else {
            return  eventDataAccess.getUserEventsList(idUser);
        }
    }

    public String getInformationEvent(int idEvent) throws DataAccessException, SQLException {
        if(idEvent <=  0) {
            throw new DataAccessException("The value '" + idEvent + "' isn't correct for finding an event");
        } else {
            BusinessTaskModel businessTaskModel = businessTaskDataAccess.getDataEvent(idEvent);

            return " - Nombre de participant : " + businessTaskModel.getNbParticipant() + "\n"
                    + " - Somme total : " + businessTaskModel.getSumTotalWithOutPromotion() + "\n"
                    + " - Somme total prommotion : " + businessTaskModel.getSumTotalPromotion() + "\n"
                    + " - Somme final : " + businessTaskModel.getSumFinal() + "\n";
        }
    }

    public BusinessTaskModel calculateReduction(int numberPerson, double price, ArrayList<ReductionModel> reductionModelArrayList) throws CalculateReductionException, ReductionBetweenException, NumberPersonException {
        BusinessTaskModel businessTaskModel = null;
        double totalPromotion = 0;
        double totalWithoutPromotion = numberPerson * price;
        int totalPersonHavePromotion = 0;

        for(ReductionModel p : reductionModelArrayList) {
            if(p.getReduc() == null) {
                throw new CalculateReductionException();
            } else {
                if(p.getReduc() > 100 || p.getReduc() <= 0) {
                    throw  new ReductionBetweenException();
                } else {
                    if (p.getNumberPerson() != null  && p.getNumberPerson() > 0) {
                        totalPromotion += ((price * p.getReduc() / 100) * p.getNumberPerson());
                        totalPersonHavePromotion += p.getNumberPerson();
                    }
                }
            }
        }
        if(numberPerson < totalPersonHavePromotion) {
            throw new NumberPersonException(numberPerson, totalPersonHavePromotion);
        }
        double total = totalWithoutPromotion - totalPromotion;

        businessTaskModel = new BusinessTaskModel(numberPerson, total, totalWithoutPromotion, totalPromotion, totalPersonHavePromotion);

        return businessTaskModel;
    }
}
