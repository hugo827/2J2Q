package Models;

public class customerModel {

    private int iduser;
    private String firstName;
    private String lastName;

    public customerModel(int iduser, String firstName, String lastName) {
        this.iduser = iduser;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
