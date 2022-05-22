package UI.panel;

import UI.listener.Business.AddReductionPanelListener;
import UI.listener.Business.CalculateListener;
import UI.listener.Business.RemoveReductionPanelListener;
import UI.listener.CRUD.VerificationIntegerListener;
import UI.listener.CRUD.VerificationDoubleListener;
import UI.window.MainWindow;
import model.ReductionModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CalculatePanel extends JPanel {

    private JLabel numberPersonLabel, priceLabel;

    private JTextField priceField, numberPersonField;

    private JButton calculateButton, plusButton, subtractButton;
    private JPanel panel, listButtonPanel;
    private ArrayList <ReductionPanel> jPanelArrayList;
    private ArrayList <ReductionModel> testArrayList;

   private MainWindow mainWindow;

    public CalculatePanel(MainWindow mainWindow) {

        this.mainWindow = mainWindow;

        this.setLayout(new GridBagLayout());

        jPanelArrayList = new ArrayList<>();

        panel = new JPanel();
        panel.setLayout(new GridLayout(17,1,10,10));
        listButtonPanel = new JPanel();
        listButtonPanel.setLayout(new GridBagLayout());

        numberPersonLabel = new JLabel("Number of participants (ex: 100) : ");
        priceLabel = new JLabel("Price of the event (ex: 9.99) : ");


        numberPersonField = new JTextField();
        numberPersonField.addKeyListener(new VerificationIntegerListener(numberPersonField));

        priceField = new JTextField();
        priceField.addKeyListener(new VerificationDoubleListener(priceField));

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateListener(this, mainWindow));

        plusButton = new JButton("+");
        plusButton.addActionListener(new AddReductionPanelListener(this));
        subtractButton = new JButton("-");
        subtractButton.addActionListener(new RemoveReductionPanelListener(this));


        listButtonPanel.add(calculateButton);
        listButtonPanel.add(new JLabel("     "));
        listButtonPanel.add(subtractButton);
        listButtonPanel.add(new JLabel("     "));
        listButtonPanel.add(plusButton);


        addJPanel();
        viewPanel();

       this.add(panel);
    }

    public void addJPanel() {
        if(jPanelArrayList.size() < 10) {
            jPanelArrayList.add(new ReductionPanel());
        } else {
            JOptionPane.showMessageDialog(this, "No more reduction", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void removePanel() {
        if(jPanelArrayList.size() > 1) {
            jPanelArrayList.remove( jPanelArrayList.size() - 1);

        } else {
            JOptionPane.showMessageDialog(this, "A reduction is required", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void viewPanel() {
        panel.removeAll();

        panel.add(numberPersonLabel);
        panel.add(numberPersonField);
        panel.add(priceLabel);
        panel.add(priceField);

        for(ReductionPanel p : jPanelArrayList) {
                panel.add(p);
        }

        subtractButton.setEnabled( jPanelArrayList.size() > 1);
        plusButton.setEnabled(jPanelArrayList.size() < 10);

        panel.add(listButtonPanel);
    }

    public String getNumberPersonSTR() {
        return numberPersonField.getText().trim();
    }

    public String getPriceSTR() {
        return priceField.getText().trim();
    }



    public ArrayList<ReductionModel> getReducList() {
        testArrayList = new ArrayList<>();
        for(ReductionPanel reduc : jPanelArrayList) {
            Double tempReduc = null;
            Integer tempNumberPerson = null;
            if(reduc.getReducField() != null && !reduc.getReducField().trim().isEmpty()) tempReduc = Double.parseDouble(reduc.getReducField());
            if(reduc.getNumberPersonField() != null && !reduc.getNumberPersonField().trim().isEmpty()) tempNumberPerson = Integer.parseInt(reduc.getNumberPersonField());
            testArrayList.add(new ReductionModel(tempNumberPerson, tempReduc ));
        }
        return  testArrayList;
    }

    public void refresh() {
        mainWindow.getFrameContainer().removeAll();
        mainWindow.getFrameContainer().add(this);
        mainWindow.printAll(mainWindow.getGraphics());
    }
}
