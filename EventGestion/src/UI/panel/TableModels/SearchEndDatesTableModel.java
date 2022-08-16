package UI.panel.TableModels;

import model.SearchEndDatesModel;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;

public class SearchEndDatesTableModel extends AbstractTableModel {

    private final String[] columnsName = {
            "Event Type", "Title", "Start date", "Is important",
            "Orga. Name", "Orga. Lastname", "User Type"
    };

    private ArrayList<SearchEndDatesModel> contents;

    public SearchEndDatesTableModel(ArrayList<SearchEndDatesModel> contents) {
        this.contents = contents;
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
            case 0 -> contents.get(rowIndex).getEventType();
            case 1 -> contents.get(rowIndex).getTitle();
            case 2 -> contents.get(rowIndex).getStartDate();
            case 3 -> contents.get(rowIndex).getIsImportant();
            case 4 -> contents.get(rowIndex).getLastName();
            case 5 -> contents.get(rowIndex).getFirstName();
            case 6 -> contents.get(rowIndex).getUserType();
            default -> null;
        };
    }

    public Class getColumnClass (int column)
    {
        Class c = switch (column) {
            case 0, 1, 4, 5, 6 -> String.class;
            case 2 -> Date.class;
            case 3 -> Boolean.class;
            default -> String.class;
        };
        return c;
    }
}
