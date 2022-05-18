package UI.panel;

import UI.listener.Search.SearchDatesListener;
import UI.panel.TableModels.SearchDatesTableModel;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class SearchDatesPanel extends JPanel {
    private JLabel label, startDateLabel, endDateLabel;

    private JPanel searchPanel, datesPanel;

    private JXDatePicker startDate, endDate;
    private JButton validate;
    private JTable jTable;
    private JScrollPane jScrollPane;

    public SearchDatesPanel() {
        this.setLayout(new BorderLayout());
        label = new JLabel("Search dates panel");
        label.setHorizontalAlignment(JLabel.CENTER);
        this.add(label, BorderLayout.NORTH);

        searchPanel = new JPanel();
        datesPanel = new JPanel();
        searchPanel.setLayout(new BorderLayout());
        datesPanel.setLayout(new GridLayout(1,5,5,5));
        startDateLabel = new JLabel("Select start date : ");
        startDate = new JXDatePicker();
        endDateLabel = new JLabel("Select end date :");
        endDate = new JXDatePicker();
        validate = new JButton("Search");
        validate.addActionListener(new SearchDatesListener(this));

        datesPanel.add(startDateLabel);
        datesPanel.add(startDate);
        datesPanel.add(endDateLabel);
        datesPanel.add(endDate);
        datesPanel.add(validate);
        searchPanel.add(datesPanel, BorderLayout.NORTH);


        jTable = new JTable();
        jScrollPane = new JScrollPane(jTable);
        searchPanel.add(jScrollPane, BorderLayout.CENTER);


        this.add(searchPanel, BorderLayout.CENTER);
    }

    public Date getStartDate() {
        return startDate.getDate();
    }
    public Date getEndDate() {
        return endDate.getDate();
    }

    public void setTable(SearchDatesTableModel searchDatesTableModel) {
        jTable = new JTable(searchDatesTableModel);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.setRowHeight(30);
        jScrollPane.setViewportView(jTable);
    }
}
