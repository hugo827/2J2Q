package UI.Panels.TableModels;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class GenerationTableModel extends AbstractTableModel {


    private ArrayList<String> nameColumns = new ArrayList<String>();
    private ArrayList<Object> contents = new ArrayList<Object>();
    private ArrayList<Object> objectsType = new ArrayList<Object>();

    public GenerationTableModel(ArrayList<String> nameColumns, ArrayList<Object> contents, ArrayList<Object> objectsType) {
        this.nameColumns = nameColumns;
        this.contents = contents;
        this.objectsType = objectsType;
    }

    @Override
    public int getRowCount() {
        return contents.size();
    }

    @Override
    public int getColumnCount() {
        return nameColumns.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return ((ArrayList) contents.get(rowIndex)).get(columnIndex);
    }

    public Class getColumnClass (int column) {
        return (objectsType.get(column)).getClass();
    }

}
