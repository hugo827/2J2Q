package model;

public class ReductionModel {

    private Integer numberPerson;
    private Double reduc;

    public ReductionModel(Integer numberPerson, Double reduc) {
        setNumberPerson(numberPerson);
        setReduc(reduc);
    }

    public Integer getNumberPerson() {
        return numberPerson;
    }

    public void setNumberPerson(Integer numberPerson) {
        this.numberPerson = numberPerson;
    }

    public Double getReduc() {
        return reduc;
    }

    public void setReduc(Double reduc) {
        this.reduc = reduc;
    }
}
