package UI.listener.CRUD;

import exception.DataAccessException;
import UI.panel.EventListingPanel;
import UI.window.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DeleteListener implements ActionListener {

    private EventListingPanel eventListingPanel;
    private MainWindow mainWindow;

    public DeleteListener(EventListingPanel eventListingPanel, MainWindow mainWindow) {
        this.eventListingPanel = eventListingPanel;
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTable jTable = eventListingPanel.getEventsTable();


        if (jTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(eventListingPanel, "Delete an event by selecting it!", "Information Delete", JOptionPane.ERROR_MESSAGE);
        } else {
            int idEvent = (int) jTable.getValueAt(jTable.getSelectedRow(), 0);
            int reply = JOptionPane.showConfirmDialog(eventListingPanel, "Confirm deleting the event", "Delete confirmation", JOptionPane.OK_CANCEL_OPTION);
            if(reply == 0) {
                try {
                    mainWindow.getEventsManagementController().deleteEvent(idEvent);
                    mainWindow.getFrameContainer().removeAll();
                    mainWindow.getFrameContainer().add(new EventListingPanel(mainWindow), BorderLayout.CENTER);
                    mainWindow.printAll(mainWindow.getGraphics());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (DataAccessException ex) {
                    JOptionPane.showMessageDialog(eventListingPanel,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }


            }
        }
    }
}
