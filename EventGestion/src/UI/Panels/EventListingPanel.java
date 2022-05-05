package UI.Panels;

import UI.Listeners.CRUD.deleteListener;
import UI.Listeners.CRUD.updateListener;
import UI.Panels.TableModels.EventTableModel;
import UI.Windows.MainWindow;

import javax.swing.*;
import java.awt.*;

public class EventListingPanel extends JPanel {

    private JLabel label;
    private JTable eventsTable;
    private EventTableModel eventTableModel;


    private JScrollPane jScrollPane;

    private JButton btnDEL, btnUPD;

    private JPanel panelSouth = new JPanel();

    public EventListingPanel() {
        this.setLayout(new BorderLayout());
        label = new JLabel("Event listing panel");
        label.setHorizontalAlignment(JLabel.CENTER);
        panelSouth.setLayout(new GridLayout());
        btnDEL = new JButton("Delete");
        btnUPD = new JButton("Update");
        btnDEL.addActionListener(new deleteListener(this));
        btnUPD.addActionListener(new updateListener(this));

        panelSouth.add(btnUPD);
        panelSouth.add(btnDEL);
        this.add(label, BorderLayout.NORTH);
        this.add(panelSouth, BorderLayout.SOUTH);

        eventTableModel = new EventTableModel(MainWindow.getController().getEventList());
        eventsTable = new JTable(eventTableModel);
        jScrollPane = new JScrollPane(eventsTable);

        eventsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        eventsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.add(jScrollPane, BorderLayout.CENTER);
    }


    public JTable getEventsTable() {
        return eventsTable;
    }
}
