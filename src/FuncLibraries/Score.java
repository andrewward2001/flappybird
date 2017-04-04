package FuncLibraries;

import java.awt.*;

public class Score {

    private int score;

    public void drawScore(Graphics2D g2){
        g2.setColor(Color.WHITE);
        g2.drawString("Score: " + score, GameFunctions.FRAMEWIDTH - 100, 50);
    }

    public void addToScore(){
        score+=1;
    }

    public void addToScore(int score){
        this.score+=score;
    }

    public int getScore(){
        return score;
    }

    public void resetScore(){
        score = 0;
    }

}
