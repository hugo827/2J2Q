package UI.panel;

import UI.listener.CRUD.DeleteListener;
import UI.listener.CRUD.SelectUpdateListener;
import UI.panel.TableModels.EventTableModel;
import UI.window.MainWindow;

import javax.swing.*;
import java.awt.*;

public class EventListingPanel extends JPanel {

    private JLabel label;
    private JTable eventsTable;
    private EventTableModel eventTableModel;

    private JScrollPane jScrollPane;

    private JButton btnDEL, btnUPD;

    private JPanel panelSouth = new JPanel();


    public EventListingPanel(MainWindow mainWindow) {
        this.setLayout(new BorderLayout());
        label = new JLabel("Event listing panel");
        label.setHorizontalAlignment(JLabel.CENTER);
        panelSouth.setLayout(new GridLayout());
        btnDEL = new JButton("Delete");
        btnUPD = new JButton("Update");
        btnDEL.addActionListener(new DeleteListener(this, mainWindow));
        btnUPD.addActionListener(new SelectUpdateListener(this, mainWindow));

        panelSouth.add(btnUPD);
        panelSouth.add(btnDEL);
        this.add(label, BorderLayout.NORTH);
        this.add(panelSouth, BorderLayout.SOUTH);

        eventTableModel = new EventTableModel(mainWindow.getEventsManagementController().getEventList());
        eventsTable = new JTable(eventTableModel);
        jScrollPane = new JScrollPane(eventsTable);


        eventsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        eventsTable.getTableHeader().setReorderingAllowed(false);
        eventsTable.getTableHeader().setResizingAllowed(true);
        eventsTable.setRowHeight(30);

        this.add(jScrollPane, BorderLayout.CENTER);
    }


    public JTable getEventsTable() {
        return eventsTable;
    }
}
