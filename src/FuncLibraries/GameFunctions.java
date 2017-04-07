package FuncLibraries;

import Game.Background;
import Game.Bird;
import Game.PipeSet;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;


public class GameFunctions {

    public static final int FRAMEWIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), FRAMEHEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

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

    public static void playSound(String filename){
        try {
            InputStream in = new FileInputStream("res/" + filename);
            AudioStream audioStream = new AudioStream(in);
            AudioPlayer.player.start(audioStream);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error loading sound file.");
        }
    }

}
