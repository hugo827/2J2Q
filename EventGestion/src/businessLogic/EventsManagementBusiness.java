package businessLogic;

import dataAccess.*;
import dataAccess.Interfaces.*;
import exception.*;
import model.*;
import UI.panel.ReductionPanel;


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


    private ArrayList<EventTypeModel> eventType;
    private ArrayList<UserModel> users;
    private ArrayList<UserTypeModel> userType;
    private ArrayList<AddressModel> address;

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

        //TODO : supprimer c'est ligne -> faire appelle direct a la  base de données ...

        loadUserList();
        loadEventTypeList();
        loadAddressList();
        loadUserTypeList();


    }

    /* ---------------------- CRUD ----------------------*/
    public ArrayList<EventModel> getEvents() {
        return eventDataAccess.getAllEvent();
    }
    public ArrayList<UserModel> getUsers() { return users; }
    public ArrayList<EventTypeModel> getEventType() { return eventType; }
    public ArrayList<AddressModel> getAddressList() { return address; }


    public void loadUserList() { users = userDataAccess.getUsers(); }
    public void loadEventTypeList() { eventType = eventTypeDataAccess.getEventType();}
    public void loadAddressList() { address = addressDataAccess.getAddressList(); }

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

    public ArrayList<SearchDateModel> getSearchByDates(Date startDate, Date endDate) throws SearchDateException {
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

    public ArrayList<UserTypeModel> getUserType() {
        return userType;
    }
    public void loadUserTypeList(){
        userType = userTypeDataAccess.getUserTypeList();
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

    public BusinessTaskModel calculateReduction(int numberPerson, double price, ArrayList<ReductionPanel> listPanel) throws CalculateReductionException, ReductionBetweenException {
        BusinessTaskModel businessTaskModel = null;
        double totalPromotion = 0;
        double totalWithoutPromotion = numberPerson * price;
        int totalPersonHavePromotion = 0;

        for(ReductionPanel p : listPanel) {
            if((p.getReducField() == null || p.getReducField().trim().isEmpty())){
                throw new CalculateReductionException();
            } else {
                if(Double.parseDouble(p.getReducField()) > 100 || Double.parseDouble(p.getReducField()) <= 0) {
                    throw  new ReductionBetweenException();
                } else {
                    if (p.getNumberPersonField() != null && !p.getNumberPersonField().trim().isEmpty() && !(Integer.parseInt(p.getNumberPersonField()) == 0)) {
                        totalPromotion += (price * Double.parseDouble(p.getReducField()) / 100) * Double.parseDouble(p.getNumberPersonField());
                        totalPersonHavePromotion += Integer.parseInt(p.getNumberPersonField());
                    }
                }
            }
        }

        double total = totalWithoutPromotion - totalPromotion;

        businessTaskModel = new BusinessTaskModel(numberPerson, total, totalWithoutPromotion, totalPromotion, totalPersonHavePromotion);

        return businessTaskModel;
    }
}
