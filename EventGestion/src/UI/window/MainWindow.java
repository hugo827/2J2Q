package UI.window;

import controller.EventsManagementController;
import UI.listener.Menu.*;
import UI.panel.HomePanel;
import UI.animation.AnimationPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainWindow extends JFrame {


    private Container mainContainer, frameContainer;
    private JMenuBar jMenuBar;
    private JMenu event, search, home, businessTask, calculate;
    private JMenuItem  eventCreate, eventRead, search1, search2, search3, quit;
    private HomeListener homeListener;
    private BusinessTaskListener btListener;
    private EventCreateListener eventCreateListener;
    private EventReadListener eventReadListener;

    private SearchDatesListener searchDatesListener;
    private SearchEventTypeListener searchEventTypeListener;
    private SearchPromotionListener searchPromotionListener;
    private CalculateListener calculateListener;
    private QuitListener quitListener;

    private AnimationPanel animationPanel;

    private EventsManagementController eventsManagementController;

    public MainWindow() {
        super("Events Management");
        Dimension minimunSizeJFrame = new Dimension(1300,800);
        setBounds(100,100,1300,800);
        this.setMinimumSize(minimunSizeJFrame);

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e){
                        System.exit(0);
                    }
                }
        );

        eventsManagementController = new EventsManagementController();

        setMenu();
        setListeners();

        animationPanel = new AnimationPanel();
        animationPanel.setPreferredSize(new Dimension(150, 800));

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
        calculate = new JMenu("calculate");
        eventRead = new JMenuItem("Listing");
        eventCreate = new JMenuItem("Add Event");
        search1 = new JMenuItem("Search by dates");
        search2 = new JMenuItem("Search promotion");
        search3 = new JMenuItem("Search by event types");
        quit = new JMenuItem("Exit");

        jMenuBar.add(home);
        jMenuBar.add(event);
        jMenuBar.add(search);
        jMenuBar.add(businessTask);
        jMenuBar.add(calculate);

        home.add(quit);
        
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
        calculateListener = new CalculateListener(this);
        quitListener = new QuitListener(this);

        home.addMouseListener(homeListener);
        businessTask.addMouseListener(btListener);
        eventCreate.addActionListener(eventCreateListener);
        eventRead.addActionListener(eventReadListener);
        search1.addActionListener(searchDatesListener);
        search2.addActionListener(searchPromotionListener);
        search3.addActionListener(searchEventTypeListener);
        calculate.addMouseListener(calculateListener);
        quit.addActionListener(quitListener);
    }


    public Container getFrameContainer() {
        return frameContainer;
    }

    public EventsManagementController getEventsManagementController() {
        return eventsManagementController;
    }

}
