package UI.Listeners.CRUD;

import Models.AddressModel;
import Models.EventModel;
import Models.EventTypeModel;
import Models.UserModel;
import UI.Panels.EventAddPanel;
import UI.Windows.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AddListener implements ActionListener {

    private EventAddPanel eventAddPanel;
    private EventModel eventModel;

    public AddListener(EventAddPanel eventAddPanel) {
        this.eventAddPanel = eventAddPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // TODO : soit faire qu'il y a une erreur ....
        // soit faire en sorte que le boutton s'affiche uniqument quand tout est completer.
        if(eventAddPanel.getTitleTF().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Title is required", "Error", JOptionPane.ERROR_MESSAGE);
        }

        Boolean isImportant = eventAddPanel.getIsImportant();
        Boolean isPrivate = eventAddPanel.getIsPrivate();
        String title = eventAddPanel.getTitleTF();
        String description = eventAddPanel.getDescriptionTF();
        String additionnalInformation = eventAddPanel.getAiTF();
        double price = Double.parseDouble(eventAddPanel.getPriceTF());
        int nbParticipant = Integer.parseInt(eventAddPanel.getNbParticipantTF());
        Date startDate = eventAddPanel.getStartDate();
        Date endDate = eventAddPanel.getEndDate();
        UserModel creator = eventAddPanel.getCreator();
        EventTypeModel eventType = eventAddPanel.getEventType();
        AddressModel address = eventAddPanel.getAddress();

        eventModel = new EventModel(title, description, additionnalInformation, isImportant, startDate, endDate, price, nbParticipant, isPrivate, creator.getIduser(), eventType.getIdEventType(), address.getIdaddress());

        MainWindow.getController().addEvent(eventModel);
    }
}
