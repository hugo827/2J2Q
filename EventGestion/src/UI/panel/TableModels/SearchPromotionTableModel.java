package UI.panel.TableModels;

import model.SearchPromotionModel;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;

public class SearchPromotionTableModel extends AbstractTableModel {

    private final String[] columnsName = {
            "Title", "Start date","End date",
            "Reduction (%)", "Final price", "Event type"
    };

    private ArrayList<SearchPromotionModel> contents;

    public SearchPromotionTableModel(ArrayList<SearchPromotionModel> contents) {
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> contents.get(rowIndex).getTitle();
            case 1 -> contents.get(rowIndex).getStartDate();
            case 2 -> contents.get(rowIndex).getEndDate();
            case 3 -> contents.get(rowIndex).getReduction();
            case 4 -> contents.get(rowIndex).getFinalPrice();
            case 5 -> contents.get(rowIndex).getEventTypeName();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnsName[column];
    }


    public Class getColumnClass (int column) {
        Class c = switch (column) {
            case 0, 5 -> String.class;
            case 1, 2 -> Date.class;
            case 3, 4 -> Double.class;
            default -> String.class;
        };
        return c;
    }
}
