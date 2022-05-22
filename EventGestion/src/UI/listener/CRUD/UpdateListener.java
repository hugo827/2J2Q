package UI.listener.CRUD;

import exception.DataAccessException;
import exception.EventException;
import exception.UpdateEventException;
import model.AddressModel;
import model.EventModel;
import model.EventTypeModel;
import model.UserModel;
import UI.panel.EventFormPanel;
import UI.panel.EventListingPanel;
import UI.window.MainWindow;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class UpdateListener implements ActionListener {

    private EventFormPanel eventFormPanel;

    private EventModel event;
    private MainWindow mainWindow;

    public UpdateListener(EventFormPanel eventFormPanel, EventModel event,MainWindow mainWindow) {
        this.eventFormPanel = eventFormPanel;
        this.event = event;
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Date startDate = eventFormPanel.getStartDate();
            startDate.setHours(eventFormPanel.getStartHour());
            startDate.setMinutes(eventFormPanel.getStartMinutes());
            Date endDate = eventFormPanel.getEndDate();
            endDate.setHours(eventFormPanel.getEndHour());
            endDate.setMinutes(eventFormPanel.getEndMinutes());


            event.setImportant(eventFormPanel.getIsImportant());
            event.setPrivate(eventFormPanel.getIsPrivate());
            event.setTitle(eventFormPanel.getTitleTF());
            event.setDescription(eventFormPanel.getDescriptionTF());
            event.setAdditionalInformation(eventFormPanel.getAiTF());
            event.setPrice(eventFormPanel.getPriceTF());
            event.setParticipantNbMax(eventFormPanel.getNbParticipantTF());
            event.setStartDate(startDate);
            event.setEndDate(endDate);

            UserModel creator = eventFormPanel.getCreator();
            EventTypeModel eventType = eventFormPanel.getEventType();
            AddressModel address = eventFormPanel.getAddress();

            event.setFk_eventType(eventType.getIdEventType());
            event.setFk_address(address.getIdAddress());
            event.setFk_creator(creator.getIduser());

           mainWindow.getEventsManagementController().updateEvent(event);


            mainWindow.setTitle("Events Management - Listing Event");
            mainWindow.getFrameContainer().removeAll();
            mainWindow.getFrameContainer().add(new EventListingPanel(mainWindow), BorderLayout.CENTER);
            mainWindow.printAll(mainWindow.getGraphics());

        } catch (EventException ex) {
            JOptionPane.showMessageDialog(eventFormPanel,ex.getMessage(), ex.getTitleError(),JOptionPane.ERROR_MESSAGE);
        } catch (DataAccessException ex) {
            throw new RuntimeException(ex);
        } catch (UpdateEventException ex) {
            JOptionPane.showMessageDialog(eventFormPanel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
