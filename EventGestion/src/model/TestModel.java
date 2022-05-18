package model;

public class TestModel {

    // Model qui va etre juste servir a la structures de nos données (!! un peu comme en C avec les structures )
    private Integer numberPerson;
    private Double reduc;

    public TestModel(Integer numberPerson, Double reduc) {
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
