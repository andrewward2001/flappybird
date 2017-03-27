import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite {

    private BufferedImage img;
    private Point loc;

    private void setPic(String name){
        try {
            img = ImageIO.read(new File("res/"+name));
        } catch (IOException e) {e.printStackTrace();}
    }

}
