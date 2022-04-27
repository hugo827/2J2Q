package UI.Panels;

import DataAccess.EventListingDataAccess;
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

    private JButton btnDEL, btnUPD;

    private String[] columns = {
            "Id", "Title", "Description", "additional information", "Important",
        "start date", "start date","end date", "Price", "max participant", "private"
    };

    public EventListingPanel() {
        this.setLayout(new BorderLayout());
        label = new JLabel("Event listing panel");
        label.setHorizontalAlignment(JLabel.CENTER);


        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columns);

        EventListingDataAccess eventListingDataAccess = new EventListingDataAccess();
        ArrayList<EventModel> list = eventListingDataAccess.getAllEvent();
        for(EventModel eventModel : list) {

            int id = eventModel.getIdEvent();
            String title = eventModel.getTitle();
            String description = eventModel.getDescription();
            String additionnalInformation = eventModel.getAdditionnalInformation();
            Boolean  isImportant = eventModel.getImportant();
            Date startDate = eventModel.getStartDate();
            Date endDate = eventModel.getEndDate();
            Double price = eventModel.getPrice();
            int participantNbMax = eventModel.getParticipantNbMax();
            Boolean isPrivate = eventModel.getPrivate();

            Object[] data = { id, title, description, additionnalInformation, isImportant, startDate, endDate, price, participantNbMax, isPrivate };
            tableModel.addRow(data);
        }

        eventsList = new JTable(tableModel);

        btnDEL = new JButton("Delete");
        btnUPD = new JButton("Update");

        this.add(label, BorderLayout.NORTH);
        this.add(new JScrollPane(eventsList), BorderLayout.CENTER);
        this.add(btnDEL, BorderLayout.SOUTH);
    }
}
