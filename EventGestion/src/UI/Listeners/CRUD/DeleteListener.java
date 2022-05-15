package UI.Listeners.CRUD;

import Exceptions.DataAccessException;
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


        if (jTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(eventListingPanel, "To deleted an event, you need to select him !", "Information Delete", JOptionPane.ERROR_MESSAGE);
        } else {
            int idEvent = (int) jTable.getValueAt(jTable.getSelectedRow(), 0);
            int reply = JOptionPane.showConfirmDialog(eventListingPanel, "Confirm deleting event", "Delete confirmation", JOptionPane.OK_CANCEL_OPTION);
            if(reply == 0) {
                try {
                    MainWindow.getController().deleteEvent(idEvent);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (DataAccessException ex) {
                    JOptionPane.showMessageDialog(eventListingPanel,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

                MainWindow.getMainWindow().repaint();
                MainWindow.getMainWindow().printAll(MainWindow.getMainWindow().getGraphics());
            }
        }
    }
}
