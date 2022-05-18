package UI.panel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

import model.AddressModel;
import model.EventModel;
import model.EventTypeModel;
import model.UserModel;
import UI.listener.CRUD.*;
import UI.listener.Menu.EventReadListener;
import UI.window.MainWindow;
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

    private JSpinner startMinutes, startHour, endHour, endMinutes;

    private SpinnerModel modelStartHour = new SpinnerNumberModel(
            8, //valeur initiale
            0, //valeur minimum
            23, //valeur maximum
            1 //pas
    );
    private SpinnerModel modelEndHour= new SpinnerNumberModel(
            8, //valeur initiale
            0, //valeur minimum
            23, //valeur maximum
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

    private MainWindow mainWindow;

    private EventFormPanel(Boolean isUpdate, EventModel eventUpdate, MainWindow mainWindow) {
        this.mainWindow = mainWindow;
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
        isImportant = new Checkbox( " ", isUpdate ? eventUpdate.getImportant() : false);

        startDateLabel = new JLabel("*Start Date Event : ");
        startDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        startDate = new JXDatePicker();
        if(isUpdate) startDate.setDate(eventUpdate.getStartDate());

        startTime = new JLabel("Select start time : ");
        startTime.setHorizontalAlignment(SwingConstants.RIGHT);
        startTimePanel = new JPanel(new FlowLayout());
        JLabel startHourLabel = new JLabel("Hour : ");
        JLabel startMinutesLabel = new JLabel("minutes :");

        startHour = new JSpinner(modelStartHour);
        startMinutes = new JSpinner(modelStartMinutes);
        startTimePanel.add(startHourLabel);
        startTimePanel.add(startHour);
        startTimePanel.add(startMinutesLabel);
        startTimePanel.add(startMinutes);

        endTime = new JLabel("Select end time :");
        endTime.setHorizontalAlignment(SwingConstants.RIGHT);
        endTimePanel = new JPanel(new FlowLayout());
        JLabel endHourLabel = new JLabel("Hour : ");
        JLabel endMinutesLabel = new JLabel("minutes :");

        endHour = new JSpinner(modelEndHour);
        endMinutes = new JSpinner(modelEndMinutes);
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
        priceTF.addKeyListener(new VerificationDoubleListener(priceTF));

        nbParticipantLabel = new JLabel("*Max Number of participant : ");
        nbParticipantLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        nbParticipantTF = new JTextField(isUpdate ? Integer.toString(eventUpdate.getParticipantNbMax()) : "");
        nbParticipantTF.addKeyListener(new VerificationIntegerListener(nbParticipantTF));

        privateLabel = new JLabel("Is Private Event ? ");
        privateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        isPrivate = new Checkbox(" ", isUpdate ? eventUpdate.getPrivate() : false);

        creatorLabel = new JLabel("*Creator of Event ? ");
        creatorLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        userModelArrayList = mainWindow.getEventsManagementController().getUserList();
        creator = new JComboBox(userModelArrayList.toArray());
        creator.setSelectedIndex(-1);

        typeLabel = new JLabel("*Type of Event ? ");
        typeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        eventTypeModelArrayList = mainWindow.getEventsManagementController().getEventTypeList();
        eventType = new JComboBox(eventTypeModelArrayList.toArray());
        eventType.setSelectedIndex(-1);

        addressLabel = new JLabel("*Address of Event ? ");
        addressLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        addressModelArrayList = mainWindow.getEventsManagementController().getAddressList();
        address = new JComboBox(addressModelArrayList.toArray());
        address.setSelectedIndex(-1);

        requiredLabel = new JLabel("*Required field");
        requiredLabel.setForeground(Color.RED);

        cancel = new JButton("Cancel");
        add = new JButton(isUpdate ? "Update event" : "Add new event");

        if(isUpdate) {
            cancel.addActionListener(new EventReadListener(mainWindow));
            add.addActionListener(new UpdateListener(this, eventUpdate, mainWindow));
            //TODO : modifie ce -1
            address.setSelectedIndex(eventUpdate.getFk_address()-1);
            creator.setSelectedIndex(eventUpdate.getFk_creator()-1);
            eventType.setSelectedIndex(eventUpdate.getFk_eventType()-1);
            startHour.setValue(eventUpdate.getStartDate().getHours());
            startMinutes.setValue(eventUpdate.getStartDate().getMinutes());
            endHour.setValue(eventUpdate.getEndDate().getHours());
            endMinutes.setValue(eventUpdate.getEndDate().getMinutes());
        } else {
            cancel.addActionListener(new CancelListener(mainWindow));
            add.addActionListener(new AddListener(this, mainWindow));
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
    public EventFormPanel(MainWindow mainWindow) {
        this(false, null, mainWindow);
    }
    public EventFormPanel(EventModel eventUpdate, MainWindow mainWindow) {
        this(true, eventUpdate, mainWindow);
    }
    public void setBorderObject(char caract) {


        switch (caract) {
            case 't' -> titleTF.setBorder(lineBorder);
            case 'd' -> descriptionTF.setBorder(lineBorder);
            case 'p' -> priceTF.setBorder(lineBorder);
            case 'n' -> nbParticipantTF.setBorder(lineBorder);
            case 's' -> startDate.setBorder(lineBorder);
            case 'e' -> endDate.setBorder(lineBorder);
            case 'c' -> {
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

    public int getStartHour() {
        return (int) startHour.getValue();
    }
    public int getStartMinutes() {
        return (int) startMinutes.getValue();
    }

    public int getEndHour() {
        return (int) endHour.getValue();
    }

    public int getEndMinutes() {
        return (int) endMinutes.getValue();
    }

}
