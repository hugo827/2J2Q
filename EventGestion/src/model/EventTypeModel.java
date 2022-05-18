package model;

public class EventTypeModel {

    private Integer idEventType;
    private String name;

    public EventTypeModel(Integer idEventType, String name) {
        this.idEventType = idEventType;
        this.name = name;
    }

    public Integer getIdEventType() {
        return idEventType;
    }

    public String getName() {
        return name;
    }

    public String toString() { return getName(); }
}
