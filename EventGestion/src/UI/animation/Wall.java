package UI.animation;

import java.awt.*;

public class Wall {
    private Rectangle rectangle;

    public Wall(int height, int width, int x, int y) {
        this.rectangle = new Rectangle(x, y, width, height);

    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(rectangle.x,rectangle.y, rectangle.width, rectangle.height);
    }

}

