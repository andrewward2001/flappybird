package FuncLibraries;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menu{

    private Rectangle selection;

    private static final BufferedImage logo = setupPic();

    private String start, settings, exit;
    private static final int FW = GameFunctions.FRAMEWIDTH, FH = GameFunctions.FRAMEHEIGHT;

    public Menu(){

    }

    public void draw(Graphics2D g2){

    }

    private static BufferedImage setupPic(){
        try{
            return ImageIO.read(new File("res/logo.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
