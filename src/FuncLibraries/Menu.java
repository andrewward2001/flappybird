package FuncLibraries;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Menu{

    private static BufferedImage logo;

    private static final int FW = GameFunctions.FRAMEWIDTH, FH = GameFunctions.FRAMEHEIGHT;

    private ArrayList<MenuOption> options;
    private int selected;

    protected void setup(MenuOption[] menuOptions){
        setupPic();
        options = new ArrayList<>();
        Collections.addAll(options, menuOptions);
        selected = 0;
        options.get(selected).setSelected(true);
    }

    public void draw(Graphics2D g2){
        g2.drawImage(logo, FW/10, FH/20, null);
        for(MenuOption s: options)
            s.draw(g2);
    }

    private void setupPic(){
        try{
            logo = ImageIO.read(new File("res/logo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void optionDown(){
        if(selected < options.size()-1){
            selected++;
            options.get(selected).setSelected(true);
            options.get(selected-1).setSelected(false);
        }
    }

    public void optionUp(){
        if(selected > 0){
            selected--;
            options.get(selected).setSelected(true);
            options.get(selected+1).setSelected(false);
        }
    }

    public void select(){
        options.get(selected).command();
    }

}
