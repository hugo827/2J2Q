package model;

import java.util.Date;

import exception.EventException;

public class UserModel {

    private Integer iduser;
    private String firstName, lastName;
    private Date birthDate;
    private Boolean isPMR;
    private String profession;
    private Integer nbChildren;
    private Integer fk_userType;
    private String userType;

    public UserModel(String firstName, String lastName, Date birthDate, Boolean isPMR, String profession, Integer nbChildren, Integer fk_userType) throws EventException{
        setFirstName(firstName);
        setLastName(lastName);
        setBirthDate(birthDate);
        setIsPMR(isPMR);
        setProfession(profession);
        setNbChildren(nbChildren);
        setFk_userType(fk_userType);
    }

    public UserModel(Integer iduser,String firstName, String lastName, Date birthDate, Boolean isPMR, String profession, Integer nbChildren, Integer fk_userType)throws EventException{
        this(firstName, lastName, birthDate, isPMR, profession, nbChildren, fk_userType);
        setIduser(iduser);
    }

    public UserModel(Integer iduser,String firstName, String lastName, Date birthDate, Boolean isPMR, String profession, Integer nbChildren, Integer fk_userType, String userType)throws EventException{
        this(iduser, firstName, lastName, birthDate, isPMR, profession, nbChildren, fk_userType);
        setUserType(userType);
    }

    public Integer getIduser() {return iduser; }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {return lastName; }
    public Date getBirthDate(){return birthDate; }
    public Boolean getIsPMR(){return isPMR;}
    public String getProfession(){return profession;}
    public Integer getNbChildren(){return nbChildren;}
    public Integer getFk_userType(){return fk_userType;}
    public void setIduser(Integer iduser){this.iduser=iduser;}

    public void setFirstName(String firstName){this.firstName=firstName;}
    public void setLastName(String lastName){this.lastName=lastName;}
    public void setBirthDate(Date birthDate){this.birthDate=birthDate;}
    public void setIsPMR(Boolean isPMR){this.isPMR=isPMR;}
    public void setProfession(String profession){this.profession=profession;}
    public void setNbChildren(Integer nbChildren){
        if(nbChildren<0){
            this.nbChildren=0;
        }
        else{
            this.nbChildren=nbChildren;
        }
    }

    public void setFk_userType(int fk_userType) throws EventException {
        if(fk_userType <= 0) {
            throw new EventException("User type is required", "Error event");
        } else {
            this.fk_userType = fk_userType;
        }
    }

    private void setUserType(String userType){
        this.userType = userType;
    }

    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}
