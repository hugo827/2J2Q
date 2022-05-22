package UI.listener.CRUD;

import exception.DataAccessException;
import model.EventModel;
import UI.panel.EventFormPanel;
import UI.panel.EventListingPanel;
import UI.window.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectUpdateListener implements ActionListener {

    private EventListingPanel eventListingPanel;
    private MainWindow mainWindow;

    public SelectUpdateListener(EventListingPanel eventListingPanel, MainWindow mainWindow) {
        this.eventListingPanel = eventListingPanel;
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JTable jTable = eventListingPanel.getEventsTable();

        if (jTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(eventListingPanel, "Update an event by selecting it!", "Information Update", JOptionPane.ERROR_MESSAGE);
        } else {


            try {
                int idEvent = (int) jTable.getValueAt(jTable.getSelectedRow(), 0);
                EventModel eventUpdate =  mainWindow.getEventsManagementController().getEvent(idEvent);

                mainWindow.setTitle("Events Management - Update event");
                mainWindow.getFrameContainer().removeAll();
                mainWindow.getFrameContainer().add(new EventFormPanel(eventUpdate, mainWindow));
                mainWindow.printAll(mainWindow.getGraphics());


            } catch (DataAccessException ex) {
                JOptionPane.showMessageDialog(eventListingPanel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

       }
    }


}
