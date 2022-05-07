package UI.Panels;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

import Models.AddressModel;
import Models.EventModel;
import Models.EventTypeModel;
import Models.UserModel;
import UI.Listeners.CRUD.AddListener;
import UI.Listeners.CRUD.CancelListener;
import UI.Listeners.CRUD.UpdateListener;
import UI.Listeners.Menu.EventReadListener;
import UI.Windows.MainWindow;
import org.jdesktop.swingx.JXDatePicker;

public class EventFormPanel extends JPanel {

    private JLabel label;

    private JLabel titleLabel, descriptionLabel, AILabel, importantLabel, startDateLabel, endDateLabel, priceLabel, nbParticipantLabel, privateLabel, creatorLabel, typeLabel, addressLabel;
    private Checkbox isImportant, isPrivate;
    private JTextField titleTF, descriptionTF, aiTF, priceTF, nbParticipantTF;
    private JXDatePicker startDate, endDate;

    private JComboBox creator, eventType, address;

    private JButton  cancel, add;

    private JPanel form;

    private  ArrayList<UserModel> userModelArrayList;
    private ArrayList<EventTypeModel> eventTypeModelArrayList;
    private ArrayList<AddressModel> addressModelArrayList;

    private EventModel eventUpdate;

    private EventFormPanel(Boolean isUpdate, EventModel eventUpdate) {
        this.setLayout(new BorderLayout());
        label = new JLabel( isUpdate ? "Event update panel" : "Event add panel");
        label.setHorizontalAlignment(JLabel.CENTER);

        this.add(label, BorderLayout.NORTH);
        JPanel listButton = new JPanel();
        form = new JPanel();
        form.setLayout(new GridLayout(12,2,5,5));
        listButton.setLayout(new GridLayout(1,2,5,5));


        titleLabel = new JLabel("Title : ");
        titleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(titleLabel);
        titleTF = new JTextField(isUpdate ? eventUpdate.getTitle() : "");
        form.add(titleTF);

        descriptionLabel = new JLabel("Description : ");
        descriptionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(descriptionLabel);
        descriptionTF = new JTextField(isUpdate ? eventUpdate.getDescription() : "");
        form.add(descriptionTF);

        AILabel = new JLabel("Additionnal information : ");
        AILabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(AILabel);
        aiTF = new JTextField(isUpdate ? eventUpdate.getAdditionnalInformation() : "");
        form.add(aiTF);

        importantLabel = new JLabel("Is Important : ");
        importantLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(importantLabel);
        isImportant = new Checkbox("", isUpdate ? eventUpdate.getImportant() : false);
        form.add(isImportant);

        startDateLabel = new JLabel("Start Date Event : ");
        startDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(startDateLabel);
        startDate = new JXDatePicker();
        if(isUpdate) startDate.setDate(eventUpdate.getStartDate());
        form.add(startDate);

        endDateLabel = new JLabel("End Date Event : ");
        endDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(endDateLabel);
        endDate = new JXDatePicker();
        if(isUpdate) endDate.setDate(eventUpdate.getEndDate());
        form.add(endDate);

        priceLabel = new JLabel("Price : ");
        priceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(priceLabel);
        priceTF = new JTextField(isUpdate ? Double.toString(eventUpdate.getPrice()) : "");
        form.add(priceTF);

        nbParticipantLabel = new JLabel("Number of participant : ");
        nbParticipantLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(nbParticipantLabel);
        nbParticipantTF = new JTextField(isUpdate ? Integer.toString(eventUpdate.getParticipantNbMax()) : "");
        form.add(nbParticipantTF);

        privateLabel = new JLabel("Is Private Event ? ");
        privateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(privateLabel);
        isPrivate = new Checkbox("", isUpdate ? eventUpdate.getPrivate() : false);
        form.add(isPrivate);

        creatorLabel = new JLabel("Creator of Event ? ");
        creatorLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(creatorLabel);

        userModelArrayList = MainWindow.getController().getUserList();
        creator = new JComboBox(userModelArrayList.toArray());


        typeLabel = new JLabel("Type of Event ? ");
        typeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        eventTypeModelArrayList = MainWindow.getController().getEventTypeList();
        eventType = new JComboBox(eventTypeModelArrayList.toArray());


        addressLabel = new JLabel("Address of Event ? ");
        addressLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        addressModelArrayList = MainWindow.getController().getAddressList();
        address = new JComboBox(addressModelArrayList.toArray());




        this.add(form, BorderLayout.CENTER);

        cancel = new JButton("Cancel");
        add = new JButton(isUpdate ? "Update event" : "Add new event");

        if(isUpdate) {
            cancel.addActionListener(new EventReadListener(MainWindow.getMainWindow()));
            add.addActionListener(new UpdateListener(this, eventUpdate));
            // TODO :  modifier ce truc de -1
            address.setSelectedIndex(eventUpdate.getFk_address()-1);
            creator.setSelectedIndex(eventUpdate.getFk_creator()-1);
            eventType.setSelectedIndex(eventUpdate.getFk_eventType()-1);
        } else {
            cancel.addActionListener(new CancelListener());
            add.addActionListener(new AddListener(this));
        }

        form.add(creator);
        form.add(typeLabel);
        form.add(eventType);
        form.add(addressLabel);
        form.add(address);
        listButton.add(add);
        listButton.add(cancel);

        this.add(listButton, BorderLayout.SOUTH);

    }

    public EventFormPanel() {
        this(false, null);
    }
    public EventFormPanel(EventModel eventUpdate) {
        this(true, eventUpdate);
    }

    public Boolean getIsImportant() {
        return isImportant.getState();
    }

    public Boolean getIsPrivate() {
        return isPrivate.getState();
    }

    public String getTitleTF() {
        return titleTF.getText();
    }

    public String getDescriptionTF() {
        return descriptionTF.getText();
    }

    public String getAiTF() {
        return aiTF.getText();
    }

    public String getPriceTF() {
        return priceTF.getText().trim();
    }

    public String getNbParticipantTF() {
        return nbParticipantTF.getText().trim();
    }

    public Date getStartDate() {
        return startDate.getDate();
    }

    public Date getEndDate() {
        return endDate.getDate();
    }

    public UserModel getCreator() {
        return userModelArrayList.get(creator.getSelectedIndex());
    }
    public EventTypeModel getEventType() {
        return eventTypeModelArrayList.get(eventType.getSelectedIndex());
    }

    public AddressModel getAddress() {
        return addressModelArrayList.get(address.getSelectedIndex());
    }
}
