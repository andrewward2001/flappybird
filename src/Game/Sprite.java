package Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Sprite {

    private BufferedImage pic;
    private Point loc;
    private Rectangle r;

    public void setPic(String name) {
        try {
            pic = ImageIO.read(new File("res/" + name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        loc = new Point(0, 0);
    }

    public BufferedImage getPic(){
        return pic;
    }

    public void setLoc(Point loc) {
        this.loc = loc;
    }

    public Point getLoc() {
        return loc;
    }

    public void draw(Graphics2D g2){
        g2.drawImage(pic, loc.x, loc.y, null);
    }

}
