package Menus;

import FuncLibraries.GameFunctions;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MainMenu extends Menu{

    private Rectangle selection;
    private BufferedImage logo;
    private String start, settings, exit;
    private final static int FW = FuncLibraries.GameFunctions.FRAMEWIDTH, FH = GameFunctions.FRAMEHEIGHT;

    public MainMenu(){
        try{
            logo = ImageIO.read(new File("res/logo.png"));
        }catch(Exception ignored){
            ignored.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){

    }


}
