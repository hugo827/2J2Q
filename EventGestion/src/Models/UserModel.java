package Models;

public class UserModel {

    private Integer iduser;

    private String firstName, lastName;

    public UserModel(Integer iduser, String firstName, String lastName) {
        this.iduser = iduser;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getIduser() {return iduser; }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return getFirstName() + " " + getLastName();
    }

}
