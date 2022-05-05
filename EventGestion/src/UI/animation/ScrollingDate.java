package UI.animation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScrollingDate extends JPanel {

    private Thread animationThread;
    private ChangeDate changeDate;

    private ArrayList<Wall> verticalArray = new ArrayList<>();
    private ArrayList<Wall> horizontalArray = new ArrayList<>();

    private List<Wall> verticalWalls = Collections.synchronizedList(verticalArray);
    private List<Wall> horizontalWalls = Collections.synchronizedList(horizontalArray);

    private JLabel label;

    public ScrollingDate() {

        verticalWalls.add(new Wall(100,5,5,5));
        verticalWalls.add(new Wall(100,5,85,5));
        horizontalWalls.add(new Wall(5,80,10,5));
        horizontalWalls.add(new Wall(5,80,10,25));
        horizontalWalls.add(new Wall(5,80,10,100));

        changeDate = new ChangeDate();
        animationThread = new AnimationThread(this);
        animationThread.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        for(Wall verticalWall : verticalArray){
            verticalWall.draw(g);
        }
        for(Wall horizontalWall : horizontalArray){
            horizontalWall.draw(g);
        }
        changeDate.draw(g);
    }

    public ChangeDate getChangeDate() {
        return changeDate;
    }
}
