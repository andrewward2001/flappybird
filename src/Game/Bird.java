package Game;

import FuncLibraries.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bird{

    private HitBox hitbox;
    private int vy;
    private BufferedImage pic;
    private Point loc;

    Bird(){
        try {
            pic = ImageIO.read(new File("res/flappybird.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        loc = new Point(200, 200);
        hitbox = new HitBox(getBoundingRectangle());
    }

    public void update(){
        hitbox.setBounds(getBoundingRectangle());
        loc.translate(0, vy);
        vy+=5;
    }

    public void draw(Graphics2D g2){
        g2.drawImage(pic, loc.x, loc.y, null);
    }

    public void bump(){
        vy = -30;
    }

    public HitBox getHitbox(){
        return hitbox;
    }

    private Rectangle getBoundingRectangle(){
        return new Rectangle(loc.x, loc.y, pic.getWidth(), pic.getHeight());
    }

    public void endGame(){
        vy = 20;

    }

}
