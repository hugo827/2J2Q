package UI.Panels.TableModels;

import Models.UserModel;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class UserNameTableModel extends AbstractTableModel {

    //TODO trouver une facons de ne pas afficher l'id ( idee : hashmap)
    private final String[] columnsName = {
            "User Name", "Id"
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
            case 1 -> contents.get(rowIndex).getIduser();
            default -> null;
        };
    }

    public Class getColumnClass (int column)
    {
        Class c;
        switch (column)
        {
            case 0 : c = String.class;
                break;
            case 1 : c = Integer.class;
                break;
            default: c = String.class;
        }
        return c;
    }

}
