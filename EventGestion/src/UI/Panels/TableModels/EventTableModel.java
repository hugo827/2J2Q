package UI.Panels.TableModels;

import Models.EventModel;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;

public class EventTableModel extends AbstractTableModel {

    private final String[] columnsName = {
            "Id", "Title", "Description", "additional information", "Important",
             "start date","end date", "Price", "max participant", "private", "fk_creator", "fk_eventtype", "fk_address"
    };
    private ArrayList<EventModel> contents;

    public EventTableModel(ArrayList<EventModel> eventModels) {
        setContents(eventModels);
    }

    private void setContents(ArrayList<EventModel> eventModels) {
        //TODO : verification ?
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
            case 10 -> contents.get(rowIndex).getFk_creator();
            case 11 -> contents.get(rowIndex).getFk_eventType();
            case 12 -> contents.get(rowIndex).getFk_address();
            default -> null;
        };
    }

    public Class getColumnClass (int column)
    { Class c;
        switch (column)
        {   case 0, 8,10,11,12: c = Integer.class;
                break;
            case 1, 2, 3: c = String.class;
                break;
            case 4, 9: c = Boolean.class;
                break;
            case 7: c = Float.class;
                break;
            case 5, 6: c = Date.class;
                break;
            default: c = String.class;
        }
        return c;
    }


}
