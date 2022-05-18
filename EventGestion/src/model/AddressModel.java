package model;

public class AddressModel {

    private Integer idAddress, zipCode;
    private String  numberStreet, name;

    public AddressModel(Integer idAddress, Integer zipCode, String numberStreet, String name) {
        this.idAddress = idAddress;
        this.zipCode = zipCode;
        this.numberStreet = numberStreet;
        this.name = name;
    }

    public Integer getIdAddress() {
        return idAddress;
    }

    public Integer getZipCode() {
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
