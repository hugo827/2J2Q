package UI.Windows;

import Controllers.EventController;
import UI.Listeners.*;
import UI.Panels.HomePanel;
import UI.animation.ScrollingDate;
import UI.animation.AnimationPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainWindow extends JFrame {

    private Container mainContainer, frameContainer;
    private JMenuBar jMenuBar;
    private JMenu event, search, home, businessTask;
    private JMenuItem eventCreate, eventRead, search1, search2, search3;
    private HomeListener homeListener;
    private BusinessTaskListener btListener;
    private EventCreateListener eventCreateListener;
    private EventReadListener eventReadListener;

    private SearchDatesListener searchDatesListener;
    private SearchEventTypeListener searchEventTypeListener;
    private SearchPromotionListener searchPromotionListener;

    private ScrollingDate scrollingDate;
    private AnimationPanel animationPanel;

    private static EventController eventController;


    public MainWindow() {
        super("Gestion d'événement");
        setBounds(100,100,1300,800);

        // a voir si il n'existe pas des element par defaut pour fermer le programme ...
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e){
                        System.exit(0);
                    }
                }
        );

        eventController = new EventController();

        setMenu();
        setListeners();

        animationPanel = new AnimationPanel();

        mainContainer = this.getContentPane();
        frameContainer = new Container();

        mainContainer.setLayout(new BorderLayout());
        frameContainer.setLayout(new BorderLayout());

        mainContainer.add(animationPanel, BorderLayout.WEST);
        mainContainer.add(frameContainer, BorderLayout.CENTER);
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
        search1 = new JMenuItem("Search by dates");
        search2 = new JMenuItem("Search promotion");
        search3 = new JMenuItem("Search by event types");

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
        searchDatesListener = new SearchDatesListener(this);
        searchPromotionListener = new SearchPromotionListener(this);
        searchEventTypeListener = new SearchEventTypeListener(this);

        home.addMouseListener(homeListener);
        businessTask.addMouseListener(btListener);
        eventCreate.addActionListener(eventCreateListener);
        eventRead.addActionListener(eventReadListener);
        search1.addActionListener(searchDatesListener);
        search2.addActionListener(searchPromotionListener);
        search3.addActionListener(searchEventTypeListener);
    }


    public Container getFrameContainer() {
        return frameContainer;
    }

    public static EventController getController() {
        return eventController;
    }
}
