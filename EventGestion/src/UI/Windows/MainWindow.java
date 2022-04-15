package UI.Windows;

import UI.Listeners.BusinessTaskListener;
import UI.Listeners.EventCreateListener;
import UI.Listeners.EventReadListener;
import UI.Listeners.HomeListener;
import UI.Panels.HomePanel;

import javax.swing.*;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame {

    private Container frameContainer;
    private JMenuBar jMenuBar;
    private JMenu event, search, home, businessTask;
    private JMenuItem eventCreate, eventRead, search1, search2, search3;
    private HomeListener homeListener;
    private BusinessTaskListener btListener;
    private EventCreateListener eventCreateListener;
    private EventReadListener eventReadListener, searchOneListener, searchTwoListener, searchThreeListener;


    public MainWindow() {
        super("Gestion d'événement");

        setBounds(10,10,1300,800);
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e){
                        System.exit(0);
                    }
                }
        );



        setMenu();
        setListeners();


        frameContainer = this.getContentPane();
        frameContainer.setLayout(new BorderLayout());
        frameContainer.add(new HomePanel(), BorderLayout.CENTER);


        setVisible(true);
    }

    private void setMenu() {
        jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);

        event = new JMenu("Event");
        search = new JMenu("Search");
        home = new JMenu("Home");
        businessTask = new JMenu("Business task");
        eventRead = new JMenuItem("Listing");
        eventCreate = new JMenuItem("Add");
        search1 = new JMenuItem("Search 1");
        search2 = new JMenuItem("Search 2");
        search3 = new JMenuItem("Search 3");

        jMenuBar.add(home);
        jMenuBar.add(event);
        jMenuBar.add(search);
        jMenuBar.add(businessTask);
        event.add(eventRead);
        event.add(eventCreate);
        search.add(search1);
        search.add(search2);
        search.add(search3);
    }

    private void setListeners() {
        homeListener = new HomeListener(this);
        btListener = new BusinessTaskListener(this);
        eventCreateListener = new EventCreateListener(this);
        eventReadListener = new EventReadListener(this);

        home.addMouseListener(homeListener);
        businessTask.addMouseListener(btListener);
        eventCreate.addActionListener(eventCreateListener);
        eventRead.addActionListener(eventReadListener);


    }


    public Container getFrameContainer() {
        return frameContainer;
    }
}
