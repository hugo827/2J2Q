package Models;

public class UserModel {

    private int iduser;

    private String firstName, lastName;

    public UserModel(int iduser, String firstName, String lastName) {
        this.iduser = iduser;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getIduser() {return iduser; }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return firstName + " " + lastName;
    }

}
