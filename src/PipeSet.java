import java.awt.*;

public class PipeSet {

    private static final int fh = GameMain.FRAMEHEIGHT;

    public PipeSet(){

    }

    private String setupPic(boolean isTop){
        if(isTop)
            return "topPipe.png";
        return "botPipe.png";
    }

    private int setupHeights(boolean isTop){
        int topPipeY = (int)(Math.random()*700);
        int botPipeY = fh - topPipeY + 100;

    }

    public void draw(Graphics2D g2, PipeSet pipeSet){

    }

}
