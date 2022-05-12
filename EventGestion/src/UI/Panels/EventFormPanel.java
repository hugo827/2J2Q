package UI.Panels;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

import Models.AddressModel;
import Models.EventModel;
import Models.EventTypeModel;
import Models.UserModel;
import UI.Listeners.CRUD.*;
import UI.Listeners.Menu.EventReadListener;
import UI.Windows.MainWindow;
import org.jdesktop.swingx.JXDatePicker;

public class EventFormPanel extends JPanel {

    private JLabel label;

    private JLabel requiredLabel,titleLabel, descriptionLabel, AILabel, importantLabel, startDateLabel, endDateLabel, priceLabel, nbParticipantLabel, privateLabel, creatorLabel, typeLabel, addressLabel;
    private Checkbox isImportant, isPrivate;
    private JTextField titleTF, descriptionTF, aiTF, priceTF, nbParticipantTF;
    private JXDatePicker startDate, endDate;

    private JComboBox creator, eventType, address;

    private JButton  cancel, add;

    private JPanel form;

    private  ArrayList<UserModel> userModelArrayList;
    private ArrayList<EventTypeModel> eventTypeModelArrayList;
    private ArrayList<AddressModel> addressModelArrayList;

    private LineBorder lineBorder = new LineBorder(Color.RED, 1);


    private EventFormPanel(Boolean isUpdate, EventModel eventUpdate) {
        this.setLayout(new BorderLayout());
        label = new JLabel( isUpdate ? "Event update panel" : "Event add panel");
        label.setHorizontalAlignment(JLabel.CENTER);

        this.add(label, BorderLayout.NORTH);
        JPanel listButton = new JPanel();
        form = new JPanel();
        form.setLayout(new GridLayout(13,2,5,5));
        listButton.setLayout(new GridLayout(1,2,5,5));


        titleLabel = new JLabel("*Title : ");
        titleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(titleLabel);
        titleTF = new JTextField(isUpdate ? eventUpdate.getTitle() : "");
        form.add(titleTF);

        descriptionLabel = new JLabel("*Description : ");
        descriptionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(descriptionLabel);
        descriptionTF = new JTextField(isUpdate ? eventUpdate.getDescription() : "");
        form.add(descriptionTF);

        AILabel = new JLabel("Additional information : ");
        AILabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(AILabel);
        aiTF = new JTextField(isUpdate ? eventUpdate.getAdditionnalInformation() : "");
        form.add(aiTF);

        importantLabel = new JLabel("Is Important : ");
        importantLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(importantLabel);
        isImportant = new Checkbox("", isUpdate ? eventUpdate.getImportant() : false);
        form.add(isImportant);

        startDateLabel = new JLabel("*Start Date Event : ");
        startDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(startDateLabel);
        startDate = new JXDatePicker();
        if(isUpdate) startDate.setDate(eventUpdate.getStartDate());
        form.add(startDate);

        endDateLabel = new JLabel("*End Date Event : ");
        endDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(endDateLabel);
        endDate = new JXDatePicker();
        if(isUpdate) endDate.setDate(eventUpdate.getEndDate());
        form.add(endDate);

        priceLabel = new JLabel("*Price : ");
        priceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(priceLabel);
        priceTF = new JTextField(isUpdate ? Double.toString(eventUpdate.getPrice()) : "");
        form.add(priceTF);
        priceTF.addKeyListener(new VerificationPriceListener(priceTF));

        nbParticipantLabel = new JLabel("*Number of participant : ");
        nbParticipantLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(nbParticipantLabel);
        nbParticipantTF = new JTextField(isUpdate ? Integer.toString(eventUpdate.getParticipantNbMax()) : "");
        form.add(nbParticipantTF);
        nbParticipantTF.addKeyListener(new VerificationNbParticipantsListener(nbParticipantTF));

        privateLabel = new JLabel("Is Private Event ? ");
        privateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(privateLabel);
        isPrivate = new Checkbox("", isUpdate ? eventUpdate.getPrivate() : false);
        form.add(isPrivate);

        creatorLabel = new JLabel("*Creator of Event ? ");
        creatorLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(creatorLabel);

        userModelArrayList = MainWindow.getController().getUserList();
        creator = new JComboBox(userModelArrayList.toArray());
        creator.setSelectedIndex(-1);

        typeLabel = new JLabel("*Type of Event ? ");
        typeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        eventTypeModelArrayList = MainWindow.getController().getEventTypeList();
        eventType = new JComboBox(eventTypeModelArrayList.toArray());
        eventType.setSelectedIndex(-1);


        addressLabel = new JLabel("*Address of Event ? ");
        addressLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        addressModelArrayList = MainWindow.getController().getAddressList();
        address = new JComboBox(addressModelArrayList.toArray());
        address.setSelectedIndex(-1);

        requiredLabel = new JLabel("*Required field");




        this.add(form, BorderLayout.CENTER);

        cancel = new JButton("Cancel");
        add = new JButton(isUpdate ? "Update event" : "Add new event");

        if(isUpdate) {
            cancel.addActionListener(new EventReadListener(MainWindow.getMainWindow()));
            add.addActionListener(new UpdateListener(this, eventUpdate));
            //TODO :  modifier ce truc de -1
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
        form.add(requiredLabel);

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
    public void setBorderObject(char c) {


        switch (c) {
            case 't' -> titleTF.setBorder(lineBorder);
            case 'd' -> descriptionTF.setBorder(lineBorder);
            case 'p' -> priceTF.setBorder(lineBorder);
            case 'n' -> nbParticipantTF.setBorder(lineBorder);
            case 's' -> startDate.setBorder(lineBorder);
            case 'e' -> endDate.setBorder(lineBorder);
            case 'b' -> {
                creator.setBorder(lineBorder);
                address.setBorder(lineBorder);
                eventType.setBorder(lineBorder);
            }
        }
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
        return priceTF.getText().trim().isEmpty() ? "-1" : priceTF.getText().trim();
    }

    public String getNbParticipantTF() {
        return nbParticipantTF.getText().trim().isEmpty() ? "-1" : nbParticipantTF.getText().trim();
    }

    public Date getStartDate() {
        return startDate.getDate();
    }

    public Date getEndDate() {
        return endDate.getDate();
    }

    public UserModel getCreator() {
        if(creator.getSelectedIndex() == -1) return null;
        else return userModelArrayList.get(creator.getSelectedIndex());
    }
    public EventTypeModel getEventType() {
        if(eventType.getSelectedIndex() == -1) return null;
        else return eventTypeModelArrayList.get(eventType.getSelectedIndex());
    }

    public AddressModel getAddress() {
        if(address.getSelectedIndex() == -1) return null;
        else return addressModelArrayList.get(address.getSelectedIndex());
    }


}
