package UI.Listeners.CRUD;

import Models.EventModel;
import UI.Panels.EventFormPanel;
import UI.Panels.EventListingPanel;
import UI.Windows.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectUpdateListener implements ActionListener {

    private EventListingPanel eventListingPanel;
    public SelectUpdateListener(EventListingPanel eventListingPanel) {
        this.eventListingPanel = eventListingPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JTable jTable = eventListingPanel.getEventsTable();
        int idEvent = (int)jTable.getValueAt(jTable.getSelectedRow(),0);

        EventModel eventUpdate =  MainWindow.getController().getEvent(idEvent);

        MainWindow.getMainWindow().setTitle("Event Gestion - Update event");
        MainWindow.getMainWindow().getFrameContainer().removeAll();
        MainWindow.getMainWindow().getFrameContainer().setLayout(new BorderLayout());
        MainWindow.getMainWindow().getFrameContainer().add(new EventFormPanel(eventUpdate), BorderLayout.CENTER);
        MainWindow.getMainWindow().repaint();
        MainWindow.getMainWindow().printAll( MainWindow.getMainWindow().getGraphics());
    }


}
