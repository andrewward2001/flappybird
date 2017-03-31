package Game;

import FuncLibraries.HitBox;

import java.awt.*;
import java.util.ArrayList;

public class Bird extends Sprite{

    private HitBox hitbox;
    private int y, vy;

    Bird(){
        setPic("flappybird.png");
        hitbox = new HitBox(getBoundingRectangle());
        setLoc(new Point(100, 100));
    }

    public void update(ArrayList<HitBox> pipeSetHitBoxes){
        hitbox.setBounds(getBoundingRectangle());
        y-=vy;

    }

    public void draw(Graphics2D g2){
        g2.drawImage(getPic(), 200, y, null);
        vy+=5;
    }

    public void bump(){
        vy = 30;
    }

    public HitBox getHitbox(){
        return hitbox;
    }

    private Rectangle getBoundingRectangle(){
        return new Rectangle(1, 4, getPic().getWidth(), getPic().getHeight());
    }

}
