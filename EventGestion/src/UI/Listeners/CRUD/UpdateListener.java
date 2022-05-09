package UI.Listeners.CRUD;

import Models.AddressModel;
import Models.EventModel;
import Models.EventTypeModel;
import Models.UserModel;
import UI.Panels.EventFormPanel;
import UI.Panels.EventListingPanel;
import UI.Windows.MainWindow;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateListener implements ActionListener {

    private EventFormPanel eventFormPanel;

    private EventModel event;

    public UpdateListener(EventFormPanel eventFormPanel, EventModel event) {
        this.eventFormPanel = eventFormPanel;
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        event.setImportant(eventFormPanel.getIsImportant());
        event.setPrivate(eventFormPanel.getIsPrivate());
        event.setTitle(eventFormPanel.getTitleTF());
        event.setDescription(eventFormPanel.getDescriptionTF());
        event.setAdditionnalInformation(eventFormPanel.getAiTF());
        event.setPrice(Double.parseDouble(eventFormPanel.getPriceTF()));
        event.setParticipantNbMax(Integer.parseInt(eventFormPanel.getNbParticipantTF()));
        event.setStartDate(eventFormPanel.getStartDate());
        event.setEndDate(eventFormPanel.getEndDate());
        UserModel creator = eventFormPanel.getCreator();
        EventTypeModel eventType = eventFormPanel.getEventType();
        AddressModel address = eventFormPanel.getAddress();

        event.setFk_eventType(eventType.getIdEventType());
        event.setFk_address(address.getIdaddress());
        event.setFk_creator(creator.getIduser());

        MainWindow.getController().updateEvent(event);

        //TODO voir si on peut pas faire autrement le retour !
        MainWindow.getMainWindow().setTitle("Event Gestion - Listing Event");
        MainWindow.getMainWindow().getFrameContainer().removeAll();
        MainWindow.getMainWindow().getFrameContainer().setLayout(new BorderLayout());
        MainWindow.getMainWindow().getFrameContainer().add(new EventListingPanel(), BorderLayout.CENTER);
        MainWindow.getMainWindow().repaint();
        MainWindow.getMainWindow().printAll(MainWindow.getMainWindow().getGraphics());
    }
}
