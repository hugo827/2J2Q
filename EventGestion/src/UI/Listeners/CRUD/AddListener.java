package UI.Listeners.CRUD;

import Models.AddressModel;
import Models.EventModel;
import Models.EventTypeModel;
import Models.UserModel;
import UI.Panels.EventFormPanel;
import UI.Windows.MainWindow;

import javax.swing.*;
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

        // TODO : soit faire qu'il y a une erreur ....
        // soit faire en sorte que le boutton s'affiche uniqument quand tout est completer.
        if(eventFormPanel.getTitleTF().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Title is required", "Error", JOptionPane.ERROR_MESSAGE);
        }

        Boolean isImportant = eventFormPanel.getIsImportant();
        Boolean isPrivate = eventFormPanel.getIsPrivate();
        String title = eventFormPanel.getTitleTF();
        String description = eventFormPanel.getDescriptionTF();
        String additionnalInformation = eventFormPanel.getAiTF();
        double price = Double.parseDouble(eventFormPanel.getPriceTF());
        int nbParticipant = Integer.parseInt(eventFormPanel.getNbParticipantTF());
        Date startDate = eventFormPanel.getStartDate();
        Date endDate = eventFormPanel.getEndDate();
        UserModel creator = eventFormPanel.getCreator();
        EventTypeModel eventType = eventFormPanel.getEventType();
        AddressModel address = eventFormPanel.getAddress();

        eventModel = new EventModel(title, description, additionnalInformation, isImportant, startDate, endDate, price, nbParticipant, isPrivate, creator.getIduser(), eventType.getIdEventType(), address.getIdaddress());

        MainWindow.getController().addEvent(eventModel);
    }
}
