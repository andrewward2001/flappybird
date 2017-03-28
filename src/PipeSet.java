import java.awt.*;
import java.awt.image.BufferedImage;

public class PipeSet {

    private static final int fh = GameMain.FRAMEHEIGHT;
    private int topPipeY, botPipeY;
    private BufferedImage topPipe, botPipe;

    public PipeSet(){
        int i = 3;
        setupHeights();
    }

    private int setupHeights(){
        topPipeY = (int)(Math.random()*700);
        botPipeY = fh - topPipeY + (int)(Math.random()*10) + 90;
    }

    public void draw(Graphics2D g2, PipeSet pipeSet){
        g2.fillRoundRect();
    }

}
