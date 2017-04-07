package FuncLibraries;

import java.awt.*;

public class Score {

    private static int score;

    public void drawScore(Graphics2D g2){
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", 0, 50));
        g2.drawString("Score: " + score, GameFunctions.FRAMEWIDTH - 200, 50);
    }

    public void addToScore(){
        score+=1;
        GameFunctions.playSound("score.wav");
    }

    public static int getScore(){
        return score;
    }

    public void resetScore(){
        score = 0;
    }

}
