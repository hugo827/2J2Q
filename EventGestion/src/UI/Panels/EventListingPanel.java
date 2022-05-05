package UI.Panels;

import DataAccess.EventListingDataAccess;
import DataAccess.TableModels.EventTableModel;
import Models.EventModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class EventListingPanel extends JPanel {

    private JLabel label;
    private JTable eventsList;
    private DefaultTableModel tableModel;

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
        panelSouth.add(btnUPD);
        panelSouth.add(btnDEL);
        this.add(label, BorderLayout.NORTH);
        this.add(panelSouth, BorderLayout.SOUTH);

    }
}
