package UI.panel.TableModels;

import model.SearchEventTypeModel;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class SearchEventTypeTableModel extends AbstractTableModel  {

    private final String[] columnsName = {
            "Title", "Start date","End date",
            "Firstname", "Lastname", "Type of user"
    };

    private ArrayList<SearchEventTypeModel> contents;

    public SearchEventTypeTableModel(ArrayList<SearchEventTypeModel> contents) {
        setContents(contents);
    }
    private void setContents(ArrayList<SearchEventTypeModel> searchEventTypeModels) {
        this.contents = searchEventTypeModels;
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
            case 1 -> contents.get(rowIndex).getStartDateSTR();
            case 2 -> contents.get(rowIndex).getEndDateSTR();
            case 3 -> contents.get(rowIndex).getFirstName();
            case 4 -> contents.get(rowIndex).getLastName();
            case 5 -> contents.get(rowIndex).getName();
            default -> null;
        };
    }


    public Class getColumnClass (int column) {
       return String.class;
    }
}
