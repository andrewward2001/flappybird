package Execute;

import FuncLibraries.*;
import Game.Background;
import Game.Bird;
import Game.PipeSet;
import Menus.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Panel extends JPanel{

    private Background bg;
    private Timer runtime, menuTimer, game, endGame;
    private Timer[] timers = {runtime, menuTimer, game, endGame};
    private boolean[] keys;
    private Bird bird;
    private ArrayList<PipeSet> pipeSets;
    private GameFunctions functions;
    private Score score;
    private FuncLibraries.Menu menu;

    public static final boolean debug = GameMain.debug;
    public static boolean active = true, isSoundEnabled = true;

    public enum GameState {INIT, TITLE_STATE, RUN_STATE, PAUSE_STATE, GAMEOVER_STATE}

    Panel(){
        setup();

        GameStateUpdate(GameState.INIT);

        GameStateUpdate(GameState.TITLE_STATE);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                keys[keyEvent.getKeyCode()] = true;
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                keys[keyEvent.getKeyCode()] = false;
            }
        });
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

    }

    private void setup(){
        instanceSetup();
        menuTimer();
        runTimer();
        gameTimer();
    }

    private void runTimer(){
        runtime = new Timer(1, e -> {
            if(keys[KeyEvent.VK_ESCAPE]) {
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException ex) {
                    ex.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        });
    }

    private void menuTimer(){
        menuTimer = new Timer(40, e -> {
            bird.getLoc();
        });
    }

    private void gameTimer() {
        game = new Timer(16, e -> {
            if (keys[KeyEvent.VK_SPACE] && active)
                bird.bump();
            for (PipeSet s : pipeSets)
                s.update();
            bird.update();
            //update each obstacle

            //check for collisions
            if (functions.checkEnemyHitDetection(pipeSets, bird) || functions.checkBackgroundHitDetection(bg, bird)) {
                active = false;
                endGame();
            }

            for (PipeSet s : pipeSets) {
                if (bird.getLoc().getX() > s.getLoc() + s.getWidth()) {
                    if (s.isUnscored()) {
                        score.addToScore();
                        s.scored();
                    }
                }
            }

            for (int i = 0; i < pipeSets.size(); i++) {
                PipeSet p = pipeSets.get(i);
                if (p.getLoc() <= -150) {
                    PipeSet temp;
                    pipeSets.remove(i);
                    temp = new PipeSet(pipeSets.get(pipeSets.size() - 1).getLoc() + 300);
                    pipeSets.add(temp);
                    i--;
                }
            }
            repaint();
        });

        endGame = new Timer(16, e -> {
            bird.update();
            repaint();
            if (bird.getLoc().x > 2000)
                GameStateUpdate(GameState.GAMEOVER_STATE);
            repaint();
        });
    }

    private void GameStateUpdate(GameState gameState) {
        switch(gameState) {
            case INIT: {
                runtime.start();
            }
            case TITLE_STATE: {
                menuTimer();
                menu = new MainMenu();
            }
            case RUN_STATE: {
                bird = new Bird();
            }
            case PAUSE_STATE: {

            }
            case GAMEOVER_STATE: {
                menu = new GameOverMenu();
                bird = null;
                repaint();
            }
            default: {
                System.exit(444);
            }
        }
    }

    private void instanceSetup(){

        score = new Score();
        keys = new boolean[512];
        bird = new Bird();
        pipeSets = new ArrayList<>();
        for(int i = 1; i <= 10; i++)
            pipeSets.add(new PipeSet(1000 + i * 300));
        bg = new Background();
        functions = new GameFunctions();
    }

    //Our paint method.
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        GameStateUpdate(GameState.PAUSE_STATE);
        bg.draw(g2);
        for(PipeSet p: pipeSets)
            p.draw(g2);
        bird.draw(g2);
        if(debug){
            for(PipeSet p: pipeSets) {
                p.getTopPipeHitBox().drawHitBox(g2);
                p.getBotPipeHitBox().drawHitBox(g2);
            }
            bird.getHitbox().drawHitBox(g2);
        }
        score.drawScore(g2);
    }

    private void endGame() {
        game.stop();
        bird.endGame();
        endGame.start();
    }
}
