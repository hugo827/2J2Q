package Models;

public class EventTypeModel {

    private int idEventType;
    private String name;

    public EventTypeModel(int idEventType, String name) {
        this.idEventType = idEventType;
        this.name = name;
    }

    public int getIdEventType() {
        return idEventType;
    }

    public String getName() {
        return name;
    }

    public String toString() { return getName(); }
}
