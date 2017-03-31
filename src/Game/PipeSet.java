package Game;

import FuncLibraries.HitBox;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PipeSet

{

    private static final int fh = GameMain.FRAMEHEIGHT;
    private int topPipeY, botPipeY;
    private Point topPipeLoc, botPipeLoc;
    private BufferedImage topPipePic, botPipePic;
    private HitBox topPipeHitBox, botPipeHitBox;
    private int speed;

    public PipeSet(int x){
        setSpeed(5);
        setup(x);
    }

    private void setup(int x){
        setupLoc(x);
        setupPics();
    }

    private void setupLoc(int x){
        topPipeY = (int)(Math.random()*700);
        botPipeY = fh - topPipeY + (int)(Math.random()*10) + 90;
        topPipeLoc = new Point(x, topPipeY);
        botPipeLoc = new Point(x, botPipeY);
    }

    private void setupPics(){
        topPipeHitBox = new HitBox(new Rectangle(topPipeLoc.x, topPipeLoc.y, getTopPipePic().getWidth(), getTopPipePic().getHeight()));
        botPipeHitBox = new HitBox(new Rectangle(botPipeLoc.x, botPipeLoc.y, getBotPipePic().getWidth(), getBotPipePic().getHeight()));
    }

    public BufferedImage getTopPipePic(){
        setPic("topPipe.png");
        return getPic();
    }

    public BufferedImage getBotPipePic(){
        setPic("botPipe.png");
        return getPic();
    }

    public HitBox getTopPipeHitBox(){
        return topPipeHitBox;
    }

    public HitBox getBotPipeHitBox(){
        return botPipeHitBox;
    }

    public void update(){
        topPipeLoc.translate(-speed, 0);
        botPipeLoc.translate(-speed, 0);
        super.setLoc(new Point(topPipeLoc.x, (topPipeLoc.y + botPipeLoc.y)/2));
    }

    public void setSpeed(int speed){
        this.speed = speed;
    } //TODO: To be used later for increasing difficulty purposes.

    public void draw(Graphics2D g2){
        super.draw(g2);
    }

    public void endGame(){
        speed = 0;
    }

}
