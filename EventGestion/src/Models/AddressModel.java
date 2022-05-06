package Models;

public class AddressModel {

    private int idaddress, zipCode;
    private String  numberStreet, name;

    public AddressModel(int idaddress, int zipCode, String numberStreet, String name) {
        this.idaddress = idaddress;
        this.zipCode = zipCode;
        this.numberStreet = numberStreet;
        this.name = name;
    }

    public int getIdaddress() {
        return idaddress;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getNumberStreet() {
        return numberStreet;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return getName() + "(" + getZipCode() + ") - " + getNumberStreet();
    }
}
