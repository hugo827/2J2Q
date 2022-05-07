package UI.Panels;

import Models.EventTypeModel;
import UI.Listeners.Search.SelectEventTypeListener;
import UI.Panels.TableModels.SearchEventTypeTableModel;
import UI.Windows.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SearchEventTypePanel extends JPanel {

    private JLabel label, eventtypeLabel;

    private JPanel searchPanel, eventTypePanel;
    private JComboBox eventTypes;

    private ArrayList<EventTypeModel> eventTypeModelArrayList;

    private JTable jTable;
    private JScrollPane jScrollPane;
    private SearchEventTypeTableModel searchEventTypeTableModel;

    public SearchEventTypePanel() {
        this.setLayout(new BorderLayout());
        label = new JLabel("Search event type panel");
        label.setHorizontalAlignment(JLabel.CENTER);
        this.add(label, BorderLayout.NORTH);


        searchPanel = new JPanel();
        eventTypePanel = new JPanel();
        searchPanel.setLayout(new BorderLayout());
        eventTypePanel.setLayout(new GridLayout(1,2,5,5));
        eventtypeLabel = new JLabel("Select event types : ");
        eventTypePanel.add(eventtypeLabel);

        eventTypeModelArrayList = MainWindow.getController().getEventTypeList();
        eventTypes = new JComboBox(eventTypeModelArrayList.toArray());
        eventTypes.addActionListener(new SelectEventTypeListener(this));
        eventTypePanel.add(eventTypes);
        searchPanel.add(eventTypePanel, BorderLayout.NORTH);

        jTable = new JTable(searchEventTypeTableModel);
        jScrollPane = new JScrollPane(jTable);
        searchPanel.add(jScrollPane, BorderLayout.CENTER);

        this.add(searchPanel, BorderLayout.CENTER);
    }

    public ArrayList<EventTypeModel> getEventTypeModelArrayList() { return eventTypeModelArrayList; }
    public JComboBox getEventTypes() { return eventTypes; }
    public void setJTable(SearchEventTypeTableModel searchEventTypeTableModel) {
        jTable = new JTable(searchEventTypeTableModel);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane.setViewportView(jTable);
    }

}
