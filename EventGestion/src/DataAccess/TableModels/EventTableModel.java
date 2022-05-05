package DataAccess.TableModels;

import Models.EventModel;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class EventTableModel extends AbstractTableModel {

    private final String[] columnsName = {
            "Id", "Title", "Description", "additional information", "Important",
            "start date", "start date","end date", "Price", "max participant", "private"
    };
    private ArrayList<EventModel> contents;

    public EventTableModel(ArrayList<EventModel> eventModels) {
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
            case 3 -> contents.get(rowIndex).getAdditionnalInformation();
            case 4 -> contents.get(rowIndex).getImportant();
            case 5 -> contents.get(rowIndex).getStartDate();
            case 6 -> contents.get(rowIndex).getEndDate();
            case 7 -> contents.get(rowIndex).getPrice();
            case 8 -> contents.get(rowIndex).getParticipantNbMax();
            case 9 -> contents.get(rowIndex).getPrivate();
            default -> null;
        };
    }

}
