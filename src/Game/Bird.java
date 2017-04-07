package Game;

import FuncLibraries.HitBox;

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

    public Bird(){
        try {
            pic = ImageIO.read(new File("res/flappybird.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        loc = new Point(200, 200);
        hitbox = new HitBox(getBoundingRectangle());
    }

    public void update(){
        hitbox.translate(0, vy);
        loc.translate(0, vy);
        vy+=1;
    }

    public void draw(Graphics2D g2){
        g2.drawImage(pic, loc.x, loc.y, null);
    }

    public void bump(){
        vy = -10;
//        if(Execute.Panel.isSoundEnabled){
//            //GameFunctions.playSound("flap.wav");
//        }
    }

    public Point getLoc(){
        return loc;
    }

    public HitBox getHitbox(){
        return hitbox;
    }

    private Rectangle getBoundingRectangle(){
        return new Rectangle(loc.x, loc.y, pic.getWidth(), pic.getHeight());
    }

    public void endGame(){
        bump();
    }

}
