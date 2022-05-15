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
    private JLabel startTime, endTime;
    private Checkbox isImportant, isPrivate;
    private JTextField titleTF, descriptionTF, aiTF, priceTF, nbParticipantTF;
    private JXDatePicker startDate, endDate;

    private JComboBox creator, eventType, address;

    private JButton  cancel, add;

    private JPanel form, startTimePanel, endTimePanel;

    private  ArrayList<UserModel> userModelArrayList;
    private ArrayList<EventTypeModel> eventTypeModelArrayList;
    private ArrayList<AddressModel> addressModelArrayList;

    private LineBorder lineBorder = new LineBorder(Color.RED, 1);

    private SpinnerModel modelStartHour = new SpinnerNumberModel(
            8, //valeur initiale
            1, //valeur minimum
            24, //valeur maximum
            1 //pas
    );
    private SpinnerModel modelEndHour= new SpinnerNumberModel(
            8, //valeur initiale
            1, //valeur minimum
            24, //valeur maximum
            1 //pas
    );
    private SpinnerModel modelEndMinutes = new SpinnerNumberModel(
            0, //valeur initiale
            0, //valeur minimum
            59, //valeur maximum
            1 //pas
    );
    private SpinnerModel modelStartMinutes = new SpinnerNumberModel(
            0, //valeur initiale
            0, //valeur minimum
            59, //valeur maximum
            1 //pas
    );


    private EventFormPanel(Boolean isUpdate, EventModel eventUpdate) {
        this.setLayout(new BorderLayout());
        label = new JLabel( isUpdate ? "Event update panel" : "Event add panel");
        label.setHorizontalAlignment(JLabel.CENTER);

        this.add(label, BorderLayout.NORTH);
        JPanel listButton = new JPanel();
        form = new JPanel();
        form.setLayout(new GridLayout(15,2,5,5));
        listButton.setLayout(new GridLayout(1,2,5,5));


        titleLabel = new JLabel("*Title : ");
        titleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        titleTF = new JTextField(isUpdate ? eventUpdate.getTitle() : "");

        descriptionLabel = new JLabel("*Description : ");
        descriptionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        descriptionTF = new JTextField(isUpdate ? eventUpdate.getDescription() : "");

        AILabel = new JLabel("Additional information : ");
        AILabel.setHorizontalAlignment(SwingConstants.RIGHT);
        aiTF = new JTextField(isUpdate ? eventUpdate.getAdditionalInformation() : "");

        importantLabel = new JLabel("Is Important : ");
        importantLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        isImportant = new Checkbox("", isUpdate ? eventUpdate.getImportant() : false);

        startDateLabel = new JLabel("*Start Date Event : ");
        startDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        startDate = new JXDatePicker();
        if(isUpdate) startDate.setDate(eventUpdate.getStartDate());

        startTime = new JLabel("Select start time : ");
        startTime.setHorizontalAlignment(SwingConstants.RIGHT);
        startTimePanel = new JPanel(new FlowLayout());
        JLabel startHourLabel = new JLabel("Hour : ");
        JLabel startMinutesLabel = new JLabel("minutes :");

        JSpinner startHour = new JSpinner(modelStartHour);
        JSpinner startMinutes = new JSpinner(modelStartMinutes);
        startTimePanel.add(startHourLabel);
        startTimePanel.add(startHour);
        startTimePanel.add(startMinutesLabel);
        startTimePanel.add(startMinutes);

        endTime = new JLabel("Select end time :");
        endTime.setHorizontalAlignment(SwingConstants.RIGHT);
        endTimePanel = new JPanel(new FlowLayout());
        JLabel endHourLabel = new JLabel("Hour : ");
        JLabel endMinutesLabel = new JLabel("minutes :");

        JSpinner endHour = new JSpinner(modelEndHour);
        JSpinner endMinutes = new JSpinner(modelEndMinutes);
        endTimePanel.add(endHourLabel);
        endTimePanel.add(endHour);
        endTimePanel.add(endMinutesLabel);
        endTimePanel.add(endMinutes);


        endDateLabel = new JLabel("*End Date Event : ");
        endDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        endDate = new JXDatePicker();
        if(isUpdate) endDate.setDate(eventUpdate.getEndDate());

        priceLabel = new JLabel("*Price : ");
        priceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        priceTF = new JTextField(isUpdate ? Double.toString(eventUpdate.getPrice()) : "");
        priceTF.addKeyListener(new VerificationPriceListener(priceTF));

        nbParticipantLabel = new JLabel("*Number of participant : ");
        nbParticipantLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        nbParticipantTF = new JTextField(isUpdate ? Integer.toString(eventUpdate.getParticipantNbMax()) : "");
        nbParticipantTF.addKeyListener(new VerificationNbParticipantsListener(nbParticipantTF));

        privateLabel = new JLabel("Is Private Event ? ");
        privateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        isPrivate = new Checkbox("", isUpdate ? eventUpdate.getPrivate() : false);

        creatorLabel = new JLabel("*Creator of Event ? ");
        creatorLabel.setHorizontalAlignment(SwingConstants.RIGHT);

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

        cancel = new JButton("Cancel");
        add = new JButton(isUpdate ? "Update event" : "Add new event");

        if(isUpdate) {
            cancel.addActionListener(new EventReadListener(MainWindow.getMainWindow()));
            add.addActionListener(new UpdateListener(this, eventUpdate));
            address.setSelectedIndex(eventUpdate.getFk_address()-1);
            creator.setSelectedIndex(eventUpdate.getFk_creator()-1);
            eventType.setSelectedIndex(eventUpdate.getFk_eventType()-1);
        } else {
            cancel.addActionListener(new CancelListener());
            add.addActionListener(new AddListener(this));
        }

        form.add(titleLabel);
        form.add(titleTF);
        form.add(descriptionLabel);
        form.add(descriptionTF);
        form.add(AILabel);
        form.add(aiTF);
        form.add(importantLabel);
        form.add(isImportant);
        form.add(startDateLabel);
        form.add(startDate);
        form.add(startTime);
        form.add(startTimePanel);
        form.add(endDateLabel);
        form.add(endDate);
        form.add(endTime);
        form.add(endTimePanel);
        form.add(priceLabel);
        form.add(priceTF);
        form.add(nbParticipantLabel);
        form.add(nbParticipantTF);
        form.add(privateLabel);
        form.add(isPrivate);
        form.add(creatorLabel);
        form.add(creator);
        form.add(typeLabel);
        form.add(eventType);
        form.add(addressLabel);
        form.add(address);
        form.add(requiredLabel);

        listButton.add(add);
        listButton.add(cancel);

        this.add(form, BorderLayout.CENTER);
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
