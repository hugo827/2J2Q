package UI.panel.TableModels;

import model.EventModel;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class EventTableModel extends AbstractTableModel {

    private final String[] columnsName = {
            "Id", "Title", "Description", "additional information", "Important",
             "Start date","End date", "Price", "Max participant", "Private", "Creator", "Address", "Event type"
    };
    private ArrayList<EventModel> contents;

    public EventTableModel(ArrayList<EventModel> eventModels) {
        setContents(eventModels);
    }

    private void setContents(ArrayList<EventModel> eventModels) {
        this.contents = eventModels;
    }

    @Override
    public int getRowCount() {
        return contents.size( );
    }

    @Override
    public int getColumnCount() {
        return columnsName.length;
    }


    @Override
    public String getColumnName(int column) {
        return columnsName[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> contents.get(rowIndex).getIdEvent();
            case 1 -> contents.get(rowIndex).getTitle();
            case 2 -> contents.get(rowIndex).getDescription();
            case 3 -> contents.get(rowIndex).getAdditionalInformation();
            case 4 -> contents.get(rowIndex).getImportant();
            case 5 -> contents.get(rowIndex).getStartDateSTR();
            case 6 -> contents.get(rowIndex).getEndDateSTR();
            case 7 -> contents.get(rowIndex).getPrice();
            case 8 -> contents.get(rowIndex).getParticipantNbMax();
            case 9 -> contents.get(rowIndex).getPrivate();
            case 10 -> contents.get(rowIndex).getCreator();
            case 11 -> contents.get(rowIndex).getAddress();
            case 12 -> contents.get(rowIndex).getEventtype();
            default -> null;
        };
    }

    public Class getColumnClass (int column)
    {
       return  switch (column) {
            case 0, 8 -> Integer.class;
            case 1, 2, 3, 10, 11, 12, 5, 6 -> String.class;
            case 4, 9 -> Boolean.class;
            case 7 -> Float.class;
            default -> String.class;
        };
    }


}
