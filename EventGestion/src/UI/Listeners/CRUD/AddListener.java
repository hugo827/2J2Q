package UI.Listeners.CRUD;

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
        String additionnalInformation = eventFormPanel.getAiTF();
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
        if(priceSTR.trim().isEmpty()) {
            message += " - Price is required \n";
            eventFormPanel.setBorderObject('p');
        }
        if(nbParticipantSTR.trim().isEmpty()) {
            message += " - Number max of participant is required \n";
            eventFormPanel.setBorderObject('n');
        }
        if(startDate == null || endDate == null) {
            message += " - Start Date and End Date is required \n";
            if(startDate == null) eventFormPanel.setBorderObject('s');
            if(endDate == null) eventFormPanel.setBorderObject('e');
        }
        if(creator == null || eventType == null || address == null) {
            message += " - All combobox is required \n";
            eventFormPanel.setBorderObject('b');

        } else {
            double price = Double.parseDouble(priceSTR);
            int nbParticipant = Integer.parseInt(nbParticipantSTR);
            eventModel = new EventModel(title, description, additionnalInformation, isImportant, startDate, endDate, price, nbParticipant, isPrivate, creator.getIduser(), eventType.getIdEventType(), address.getIdaddress());
            MainWindow.getController().addEvent(eventModel);

            //TODO voir si on peut pas faire autrement le retour !
            //class callPanel(JPanel panel) => on appelle cette class qui removeall...)
            MainWindow.getMainWindow().getFrameContainer().removeAll();
            MainWindow.getMainWindow().getFrameContainer().setLayout(new BorderLayout());
            MainWindow.getMainWindow().getFrameContainer().add(new EventListingPanel(), BorderLayout.CENTER);
            MainWindow.getMainWindow().repaint();
            MainWindow.getMainWindow().printAll(MainWindow.getMainWindow().getGraphics());

        }

        if(!message.trim().isEmpty() )  JOptionPane.showMessageDialog(eventFormPanel, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
