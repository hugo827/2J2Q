package UI.Panels;

import javax.swing.*;
import java.awt.*;

import UI.Listeners.CRUD.AddListener;
import UI.Listeners.CRUD.CancelListener;
import org.jdesktop.swingx.JXDatePicker;

public class EventAddPanel extends JPanel {

    private JLabel label; // Name panel NORTH

    private JLabel titleLabel, descriptionLabel, AILabel, importantLabel, startDateLabel, endDateLabel, priceLabel, nbParticipantLabel, privateLabel, creatorLabel, typeLabel, addressLabel;
    private Checkbox isImportant, isPrivate;
    private JTextField titleTF, descriptionTF, aiTF, priceTF, nbParticipantTF;
    private JXDatePicker startDate, endDate;

    private JComboBox creator, eventType, address;

    private JButton  cancel, add;


    public EventAddPanel() {
        this.setLayout(new BorderLayout());
        label = new JLabel("Event add panel");
        label.setHorizontalAlignment(JLabel.CENTER);

        this.add(label, BorderLayout.NORTH);
        JPanel listButton = new JPanel();
        JPanel form = new JPanel();
        form.setBounds(50,50,150,150);
        form.setLayout(new GridLayout(12,2,5,5));
        listButton.setLayout(new GridLayout(1,2,5,5));


        titleLabel = new JLabel("Title : ");
        titleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(titleLabel);
        titleTF = new JTextField();
        form.add(titleTF);

        descriptionLabel = new JLabel("Description : ");
        descriptionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(descriptionLabel);
        descriptionTF = new JTextField();
        form.add(descriptionTF);

        AILabel = new JLabel("Additionnal information : ");
        AILabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(AILabel);
        aiTF = new JTextField();
        form.add(aiTF);

        importantLabel = new JLabel("Is Important : ");
        importantLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(importantLabel);
        isImportant = new Checkbox();
        form.add(isImportant);

        startDateLabel = new JLabel("Start Date Event : ");
        startDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(startDateLabel);
        startDate = new JXDatePicker();
        form.add(startDate);

        endDateLabel = new JLabel("End Date Event : ");
        endDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(endDateLabel);
        endDate = new JXDatePicker();
        form.add(endDate);

        priceLabel = new JLabel("Price : ");
        priceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(priceLabel);
        priceTF = new JTextField();
        form.add(priceTF);

        nbParticipantLabel = new JLabel("Number of participant : ");
        nbParticipantLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(nbParticipantLabel);
        nbParticipantTF = new JTextField();
        form.add(nbParticipantTF);

        privateLabel = new JLabel("Is Private Event ? ");
        privateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(privateLabel);
        isPrivate = new Checkbox();
        form.add(isPrivate);

        creatorLabel = new JLabel("Creator of Event ? ");
        creatorLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(creatorLabel);
        //TODO : remplir les combo box, faire appelle a une arraylist dans le controller.
        creator = new JComboBox();
        form.add(creator);

        typeLabel = new JLabel("Type of Event ? ");
        typeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(typeLabel);
        eventType = new JComboBox();
        form.add(eventType);

        addressLabel = new JLabel("Address of Event ? ");
        addressLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(addressLabel);
        address = new JComboBox();
        form.add(address);


        this.add(form, BorderLayout.CENTER);

        cancel = new JButton("Cancel");
        add = new JButton("Add new event");
        cancel.addActionListener(new CancelListener());
        add.addActionListener(new AddListener());

        listButton.add(add);
        listButton.add(cancel);

        this.add(listButton, BorderLayout.SOUTH);

    }
}
