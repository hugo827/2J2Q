package UI.Panels;

import UI.Listeners.CRUD.DeleteListener;
import UI.Listeners.CRUD.UpdateListener;
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
        btnDEL.addActionListener(new DeleteListener(this));
        btnUPD.addActionListener(new UpdateListener(this));

        panelSouth.add(btnUPD);
        panelSouth.add(btnDEL);
        this.add(label, BorderLayout.NORTH);
        this.add(panelSouth, BorderLayout.SOUTH);

        eventTableModel = new EventTableModel(MainWindow.getController().getEventList());
        eventsTable = new JTable(eventTableModel);
        jScrollPane = new JScrollPane(eventsTable);

        eventsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        eventsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        eventsTable.getTableHeader().setReorderingAllowed(false);

        this.add(jScrollPane, BorderLayout.CENTER);
    }


    public JTable getEventsTable() {
        return eventsTable;
    }
}
