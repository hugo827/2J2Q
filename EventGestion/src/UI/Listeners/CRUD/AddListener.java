package UI.Listeners.CRUD;

import Exceptions.AddEventException;
import Exceptions.EventException;
import Models.AddressModel;
import Models.EventModel;
import Models.EventTypeModel;
import Models.UserModel;
import UI.Panels.EventFormPanel;
import UI.Panels.EventListingPanel;
import UI.Windows.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AddListener implements ActionListener {

    private EventFormPanel eventFormPanel;
    private EventModel eventModel;

    public AddListener(EventFormPanel eventFormPanel) {
        this.eventFormPanel = eventFormPanel;
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
        if(startDate != null && startDate.before(new Date())) message += " - Start date can't be before today !\n";
        if(endDate != null && endDate.before(startDate)) message += " - End date can't be before start date\n";

        if(creator == null || eventType == null || address == null) {
            message += " - All combobox is required \n";
            eventFormPanel.setBorderObject('b');

        }



        if(!message.trim().isEmpty() )  JOptionPane.showMessageDialog(eventFormPanel, message, "Error", JOptionPane.ERROR_MESSAGE);
        else {
            double price = Double.parseDouble(priceSTR);
            int nbParticipant = Integer.parseInt(nbParticipantSTR);

            try {
                eventModel = new EventModel(title, description, additionalInformation, isImportant, startDate, endDate, price, nbParticipant, isPrivate, creator.getIduser(), eventType.getIdEventType(), address.getIdAddress());
                MainWindow.getController().addEvent(eventModel);

                //TODO : voir si on peut pas faire autrement le retour !
                //class callPanel(JPanel panel) => on appelle cette class qui removeall...)
                MainWindow.getMainWindow().getFrameContainer().removeAll();
                MainWindow.getMainWindow().getFrameContainer().setLayout(new BorderLayout());
                MainWindow.getMainWindow().getFrameContainer().add(new EventListingPanel(), BorderLayout.CENTER);
                MainWindow.getMainWindow().repaint();
                MainWindow.getMainWindow().printAll(MainWindow.getMainWindow().getGraphics());

            } catch (AddEventException ex) {
                JOptionPane.showMessageDialog(eventFormPanel, ex.getMessage(), "Error add event", JOptionPane.ERROR_MESSAGE);
            } catch (EventException ex) {
                JOptionPane.showMessageDialog(eventFormPanel, ex.getMessage(), ex.getTitleError(), JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
