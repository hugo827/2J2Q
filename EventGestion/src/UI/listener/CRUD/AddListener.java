package UI.listener.CRUD;

import exception.AddEventException;
import exception.DataAccessException;
import exception.EventException;
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

public class AddListener implements ActionListener {

    private EventFormPanel eventFormPanel;
    private EventModel eventModel;

    private MainWindow mainWindow;

    public AddListener(EventFormPanel eventFormPanel, MainWindow mainWindow) {
        this.eventFormPanel = eventFormPanel;
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String message = "";
        Boolean isImportant = eventFormPanel.getIsImportant();
        Boolean isPrivate = eventFormPanel.getIsPrivate();
        String title = eventFormPanel.getTitleTF();
        String description = eventFormPanel.getDescriptionTF();
        String additionalInformation = eventFormPanel.getAiTF();
        String priceSTR = eventFormPanel.getPriceTF();
        String nbParticipantSTR = eventFormPanel.getNbParticipantTF();
        Date startDate = eventFormPanel.getStartDate();
        Date endDate = eventFormPanel.getEndDate();
        UserModel creator = eventFormPanel.getCreator();
        EventTypeModel eventType = eventFormPanel.getEventType();
        AddressModel address = eventFormPanel.getAddress();

        if(title.trim().isEmpty()) {
            message += " - Title is required\n";
            eventFormPanel.setBorderObject('t');
        }
        if(description.trim().isEmpty()) {
            message += " - Description is required \n";
            eventFormPanel.setBorderObject('d');
        }
        if(priceSTR.trim().isEmpty() || priceSTR.trim().equals("-1")) {
            message += " - Price is required \n";
            eventFormPanel.setBorderObject('p');
        }
        if(nbParticipantSTR.trim().isEmpty() || nbParticipantSTR.trim().equals("-1")) {
            message += " - Number max of participant is required \n";
            eventFormPanel.setBorderObject('n');
        }
        if(startDate == null || endDate == null) {
            message += " - Start Date and End Date is required \n";
            if(startDate == null) eventFormPanel.setBorderObject('s');
            if(endDate == null) eventFormPanel.setBorderObject('e');
        }

        if(startDate != null) {
            if(startDate.before(new Date() )) message += " - Start date can't be before today !\n";
            if (endDate != null) {
                if (endDate.before(startDate)) message += " - End date can't be before start date\n";
                if (endDate.equals(startDate)) {
                   if(eventFormPanel.getStartHour() >= eventFormPanel.getEndHour() && eventFormPanel.getStartMinutes() >= eventFormPanel.getEndMinutes())
                       message += " - Start hour can't be before end hour or equals\n";
                   if(eventFormPanel.getStartHour() == eventFormPanel.getEndHour() && (eventFormPanel.getEndMinutes() - eventFormPanel.getStartMinutes()) < 15 )
                       message += " 15 minutes behind the start date and end hour to add event\n";
                }



            }
        }
        if(creator == null || eventType == null || address == null) {
            message += " - All comboboxes are required \n";
            eventFormPanel.setBorderObject('c');
        }



        if(!message.trim().isEmpty() )  JOptionPane.showMessageDialog(eventFormPanel, message, "Error", JOptionPane.ERROR_MESSAGE);
        else {
            double price = Double.parseDouble(priceSTR);
            int nbParticipant = Integer.parseInt(nbParticipantSTR);
            startDate.setHours(eventFormPanel.getStartHour());
            startDate.setMinutes(eventFormPanel.getStartMinutes());
            endDate.setHours(eventFormPanel.getEndHour());
            endDate.setMinutes(eventFormPanel.getEndMinutes());

            try {
                eventModel = new EventModel(title, description, additionalInformation, isImportant, startDate, endDate, price, nbParticipant, isPrivate, creator.getIduser(), eventType.getIdEventType(), address.getIdAddress());
                mainWindow.getEventsManagementController().addEvent(eventModel);

                mainWindow.getFrameContainer().removeAll();
                mainWindow.getFrameContainer().add(new EventListingPanel(mainWindow), BorderLayout.CENTER);
                mainWindow.repaint();
                mainWindow.printAll(mainWindow.getGraphics());

            } catch (AddEventException | DataAccessException | EventException ex) {
                JOptionPane.showMessageDialog(eventFormPanel, ex.getMessage(), "Error add event", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
