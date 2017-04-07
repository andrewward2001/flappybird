package Execute;

import FuncLibraries.GameFunctions;
import FuncLibraries.Menu;
import FuncLibraries.Score;
import Game.*;
import Menus.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Panel extends JPanel{

    private Background bg;
    private static Timer menuTimer, game, endGame;
    private boolean[] keys;
    private static Bird bird;
    private static ArrayList<PipeSet> pipeSets;
    private GameFunctions functions;
    private static Score score;
    private static Menu menu;

    public static boolean debug = GameMain.debug, isSoundEnabled = true;
    private static boolean active = true;

    Panel(){
        setup();
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
    }

    private void setup(){
        instanceSetup();
        menuTimer();
        gameTimer();
        menuTimer.start();
    }

    private void menuTimer(){
        menuTimer = new Timer(75, e -> {
             if(keys[KeyEvent.VK_DOWN]) {
                 menu.optionDown();
             }
             if(keys[KeyEvent.VK_UP]) {
                 menu.optionUp();
             }
             if(keys[KeyEvent.VK_SPACE] || keys[KeyEvent.VK_ENTER]) {
                 menu.select();
             }
             repaint();
        });
    }

    private void gameTimer() {
        game = new Timer(16, e -> {
            if(keys[KeyEvent.VK_ESCAPE]){
                menu = new PauseMenu();
                menuTimer.start();
                game.stop();
            }
            if (keys[KeyEvent.VK_SPACE] && active)
                bird.bump();
            pipeSets.forEach(PipeSet::update);
            bird.update();
            //update each obstacle

            //check for collisions
            if (functions.checkEnemyHitDetection(pipeSets, bird) || functions.checkBackgroundHitDetection(bg, bird)) {
                GameFunctions.playSound("hurt.wav");
                active = false;
                endGame();
            }

            pipeSets.stream().filter(s -> bird.getLoc().getX() > s.getLoc() + s.getWidth()).filter(PipeSet::isUnscored).forEach(s -> {
                score.addToScore();
                s.scored();
            });

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
            if (bird.getLoc().y > 2000) {
                game.stop();
                menu = new GameOverMenu();
                menuTimer.start();
                endGame.stop();
            }
            repaint();
        });
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
        menu = new MainMenu();
    }

    //Our paint method.
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        bg.draw(g2);
        if(menuTimer.isRunning()){
            menu.draw(g2);
        }
        if (game.isRunning() || endGame.isRunning()) {
            for (PipeSet p : pipeSets)
                p.draw(g2);
            bird.draw(g2);
            if (debug) {
                for (PipeSet p : pipeSets) {
                    p.getTopPipeHitBox().drawHitBox(g2);
                    p.getBotPipeHitBox().drawHitBox(g2);
                }
                bird.getHitbox().drawHitBox(g2);
            }
            score.drawScore(g2);
        }
    }

    public static void startGame(){
        menuTimer.stop();
        game.start();
        active = true;
    }

    public static void reset(){
        score.resetScore();
        bird = new Bird();
        pipeSets = new ArrayList<>();
        for(int i = 1; i <= 10; i++)
            pipeSets.add(new PipeSet(1000 + i * 300));
    }

    public static void changeMenu(int i){
        if(i == 1)
            menu = new MainMenu();
        if(i == 2)
            menu = new SettingsMenu();
        if(i == 3)
            menu = new GameOverMenu();
    }

    private void endGame() {
        game.stop();
        bird.endGame();
        endGame.start();
    }
}
