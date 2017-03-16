import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by andrew_ward on 3/16/17.
 */
public class Sprite {

    private BufferedImage img;

    public Sprite(String name) {
        try {
            img = ImageIO.read(new File("res/"+name));
        } catch (IOException e) {e.printStackTrace();}
    }
}
