package UI.panel;

import UI.listener.Search.SearchEndDatesListener;
import UI.panel.TableModels.SearchEndDatesTableModel;
import UI.window.MainWindow;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class SearchEndDatesPanel extends JPanel {
    private JLabel label, endDateLabel;

    private JPanel searchPanel, datesPanel;

    private JXDatePicker endDate;
    private JButton validate;
    private JTable jTable;
    private JScrollPane jScrollPane;

    public SearchEndDatesPanel(MainWindow mainWindow) {
        this.setLayout(new BorderLayout());
        label = new JLabel("Search dates panel");
        label.setHorizontalAlignment(JLabel.CENTER);
        this.add(label, BorderLayout.NORTH);

        searchPanel = new JPanel();
        datesPanel = new JPanel();
        searchPanel.setLayout(new BorderLayout());
        datesPanel.setLayout(new GridLayout(1,5,5,5));
        endDateLabel = new JLabel("Select end date :");
        endDate = new JXDatePicker();
        validate = new JButton("Search");
        validate.addActionListener(new SearchEndDatesListener(this, mainWindow));

        datesPanel.add(endDateLabel);
        datesPanel.add(endDate);
        datesPanel.add(validate);
        searchPanel.add(datesPanel, BorderLayout.NORTH);


        jTable = new JTable();
        jScrollPane = new JScrollPane(jTable);
        searchPanel.add(jScrollPane, BorderLayout.CENTER);


        this.add(searchPanel, BorderLayout.CENTER);
    }
    public Date getEndDate() {
        return endDate.getDate();
    }

    public void setTable(SearchEndDatesTableModel searchEndDatesTableModel) {
        jTable = new JTable(searchEndDatesTableModel);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.setRowHeight(30);
        jScrollPane.setViewportView(jTable);
    }
}
