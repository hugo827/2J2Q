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

    public ScrollingDate() {

        verticalWalls.add(new Wall(100,5,15,15));
        verticalWalls.add(new Wall(100,5,95,15));
        horizontalWalls.add(new Wall(5,80,20,15));
        horizontalWalls.add(new Wall(5,80,20,35));
        horizontalWalls.add(new Wall(5,80,20,110));

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
