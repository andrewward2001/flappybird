package Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite {

    private BufferedImage pic;
    private Point loc;
    private int speed, dy;
    private Rectangle r;

    public void setPic(String name) {
        try {
            pic = ImageIO.read(new File("res/" + name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        speed = 1;
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

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void draw(Graphics2D g2){
        g2.drawImage(pic, loc.x, loc.y, null);
    }

    public void update(){
        loc.translate(speed, 0);
    }

    public void endGame(){
        speed = 0;
        dy-=5;

    }

}
