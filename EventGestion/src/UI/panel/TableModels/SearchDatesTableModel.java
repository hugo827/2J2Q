package UI.panel.TableModels;

import model.SearchDateModel;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;

public class SearchDatesTableModel extends AbstractTableModel {

    private final String[] columnsName = {
            "Title", "Start date",
            "Is private", "Address"
    };

    private ArrayList<SearchDateModel> contents;

    public SearchDatesTableModel(ArrayList<SearchDateModel> contents) {
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
            case 0 -> contents.get(rowIndex).getTitle();
            case 1 -> contents.get(rowIndex).getStartDate();
            case 2 -> contents.get(rowIndex).getPrivate();
            case 3 -> contents.get(rowIndex).getFullAddress();
            default -> null;
        };
    }

    public Class getColumnClass (int column)
    {
        Class c = switch (column) {
            case 0, 3 -> String.class;
            case 1 -> Date.class;
            case 2 -> Boolean.class;
            default -> String.class;
        };
        return c;
    }
}
