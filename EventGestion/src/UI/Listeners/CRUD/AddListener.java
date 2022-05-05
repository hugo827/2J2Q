package UI.Listeners.CRUD;

import Models.EventModel;
import UI.Panels.EventAddPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
        String additionnalInformation = eventAddPanel.getDescriptionTF();
        float price = Float.parseFloat(eventAddPanel.getPriceTF());
        int nbParticipant = Integer.parseInt(eventAddPanel.getNbParticipantTF());
        Date startDate = eventAddPanel.getStartDate();
        Date endDate = eventAddPanel.getEndDate();

        // eventModel = new EventModel(title, description, additionnalInformation, isImportant, );
        System.out.println(startDate);
        GregorianCalendar releaseDate = new GregorianCalendar();
        releaseDate.setTime(startDate);
        System.out.println(releaseDate.get(Calendar.YEAR) + "/" + releaseDate.get(Calendar.MONTH)+1 + "/" + releaseDate.get(Calendar.DAY_OF_MONTH));

    }
}
