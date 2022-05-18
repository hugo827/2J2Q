package UI.panel.TableModels;

import model.UserModel;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class UserNameTableModel extends AbstractTableModel {

    private final String[] columnsName = {
            "User Name"
    };
    private ArrayList<UserModel> contents;

    public UserNameTableModel(ArrayList<UserModel> contents) {
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
            case 0 -> contents.get(rowIndex);
            default -> null;
        };
    }

    public Class getColumnClass (int column)
    {
        return String.class;
    }

}
