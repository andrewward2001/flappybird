import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Background {

    private BufferedImage bg;
    private final int FW = GameMain.FRAMEWIDTH, FH = GameMain.FRAMEHEIGHT;

    public Background(){
        try{
            bg = ImageIO.read(new File("res/bg.png"));
        }catch(Exception e){e.printStackTrace();}
    }

    public void draw(Graphics2D g2){
        g2.drawImage(bg, 0, 0, FW, FH, null);
    }

}
