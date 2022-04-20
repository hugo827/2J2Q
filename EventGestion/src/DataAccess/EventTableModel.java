package DataAccess;

import Models.EventModel;
import org.w3c.dom.events.Event;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class EventTableModel extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<EventModel> contents;

    public EventTableModel(ArrayList<EventModel> eventModels) {
        columnNames = new ArrayList<>();
        columnNames.add("Id");
        columnNames.add("Title");
        columnNames.add("Description");
        columnNames.add("additional information");
        columnNames.add("Important");
        columnNames.add("start date");
        columnNames.add("start date");
        columnNames.add("end date");
        columnNames.add("Price");
        columnNames.add("max participant");
        columnNames.add("private");
        this.contents = eventModels;
    }
    public String getColumnName(int column) { return columnNames.get(column); }

    @Override
    public int getRowCount() {
        return contents.size( );
    }

    @Override
    public int getColumnCount() {
        return columnNames.size( );
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        return null;

    }
}
