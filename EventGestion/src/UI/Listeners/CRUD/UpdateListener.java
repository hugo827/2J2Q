package UI.Listeners.CRUD;

import Models.EventModel;
import UI.Panels.EventListingPanel;
import UI.Windows.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateListener implements ActionListener {

    private EventListingPanel eventListingPanel;

    public UpdateListener(EventListingPanel eventListingPanel) {
        this.eventListingPanel = eventListingPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JTable jTable = eventListingPanel.getEventsTable();
        int idEvent = (int)jTable.getValueAt(jTable.getSelectedRow(), 0);
        EventModel eventModel = (EventModel) MainWindow.getController().getEvent(idEvent);


        MainWindow.getMainWindow().repaint();
        MainWindow.getMainWindow().printAll(MainWindow.getMainWindow().getGraphics());
    }
}
