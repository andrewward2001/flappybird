package FuncLibraries;

import Execute.GameMain;
import Game.Background;
import Game.PipeSet;
import Game.Bird;

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

    public void score(ArrayList<PipeSet> pipeSets, Bird bird) {
        for(PipeSet p: pipeSets) {
            if(p.getTopPipeHitBox().getX() == bird.getHitbox().getX())
                GameMain.G.score += 1;
        }
    }

    public boolean checkBackgroundHitDetection(Background bg, Bird bird){
        return  bg.getFloorHitBox().intersects(bird.getHitbox());
    }

}
