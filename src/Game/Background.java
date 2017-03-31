package Game;

import FuncLibraries.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static FuncLibraries.GameFunctions.FRAMEWIDTH;
import static FuncLibraries.GameFunctions.FRAMEHEIGHT;

public class Background {

    private BufferedImage bg;
    private static final int FW = FRAMEWIDTH, FH = FRAMEHEIGHT;
    private HitBox ceilingHitBox, floorHitBox;

    public Background(){
        try{
            bg = ImageIO.read(new File("res/bg.png"));
        }catch(Exception e){e.printStackTrace();}

        ceilingHitBox = new HitBox(new Rectangle(0, 0, 1000, 50));
        floorHitBox = new HitBox(new Rectangle(950, 0, 1000, 50));
    }

    public HitBox getCeilingHitBox() {
        return ceilingHitBox;
    }
    public HitBox getFloorHitBox() {
        return floorHitBox;
    }

    public void draw(Graphics2D g2){
        HitBox c = ceilingHitBox, f = floorHitBox;
        g2.drawImage(bg, 0, 0, FW, FH, null);
        g2.setColor(Color.GREEN);
        g2.fillRect(c.x, c.y, c.width, c.height);
        g2.fillRect(f.x, f.y, f.width, f.height);
        g2.fillRect(0, 950, 1000, 100);
    }

}
