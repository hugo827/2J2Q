package UI.Listeners.CRUD;

import UI.Panels.EventListingPanel;
import UI.Windows.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DeleteListener implements ActionListener {

    private EventListingPanel eventListingPanel;

    public DeleteListener(EventListingPanel eventListingPanel) {
        this.eventListingPanel = eventListingPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTable jTable = eventListingPanel.getEventsTable();
        int idEvent = (int)jTable.getValueAt(jTable.getSelectedRow(),0);

        try {
            MainWindow.getController().deleteEvent(idEvent);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        MainWindow.getMainWindow().repaint();
        MainWindow.getMainWindow().printAll(MainWindow.getMainWindow().getGraphics());
    }
}
