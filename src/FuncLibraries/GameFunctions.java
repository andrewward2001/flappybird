package FuncLibraries;

import Game.Background;
import Game.PipeSet;
import Game.Bird;

import javax.swing.*;
import java.util.ArrayList;


public class GameFunctions {

    public static final int FRAMEWIDTH = 1500, FRAMEHEIGHT = 800;

    public boolean checkEnemyHitDetection(ArrayList<PipeSet> pipeSets, Bird bird){
        for(PipeSet p: pipeSets){
            if(p.getTopPipeHitBox().intersects(bird.getHitbox()) || p.getBotPipeHitBox().intersects(bird.getHitbox()))
                return true;
        }
        return false;
    }

    public boolean checkBackgroundHitDetection(Background bg, Bird bird){
        return bg.getCeilingHitBox().intersects(bird.getHitbox()) || bg.getFloorHitBox().intersects(bird.getHitbox());
    }

    public void stopTimers(Timer[] timers){
        for (Timer t: timers){
            t.stop();
        }
    }

}
