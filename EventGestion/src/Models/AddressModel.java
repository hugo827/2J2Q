package Models;

public class AddressModel {

    private Integer idaddress, zipCode;
    private String  numberStreet, name;

    public AddressModel(Integer idaddress, Integer zipCode, String numberStreet, String name) {
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
