package Game;

import FuncLibraries.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import static FuncLibraries.GameFunctions.FRAMEHEIGHT;
import static FuncLibraries.GameFunctions.FRAMEWIDTH;

public class GameMain extends JPanel {

    //instance fields for the general environment
    private Background bg;
    private Timer timer;
    private boolean[] keys;
    private Bird bird;
    private ArrayList<PipeSet> pipeSets;
    private GameFunctions functions;

    public static final boolean debug = true;

    static boolean active = true;

    GameMain(){

        instanceSetup();

        timer = new Timer(40, e -> {
            if(keys[KeyEvent.VK_SPACE] && active)
                bird.bump();

            for(PipeSet s: pipeSets)
                s.update();
            bird.update();
            //update each obstacle

            //check for collisions
            if(functions.checkEnemyHitDetection(pipeSets, bird) || functions.checkBackgroundHitDetection(bg, bird)) {
                endGame();
                active = false;
            }
            repaint();
        });
        timer.start();

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

    private void instanceSetup(){
        keys = new boolean[512];
        bird = new Bird();
        pipeSets = new ArrayList<>();
        for(int i = 1; i <= 20; i++)
            pipeSets.add(new PipeSet(1000 + i * 300));
        bg = new Background();
        functions = new GameFunctions();
    }

    //Our paint method.
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        bg.draw(g2);
        for(PipeSet p: pipeSets)
            p.draw(g2);
        bird.draw(g2);

    }


    private void endGame() {
        for (PipeSet p: pipeSets)
            p.endGame();
        bird.endGame();
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Ermahgerd Hopps is playing this");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, FRAMEWIDTH, FRAMEHEIGHT + 22); //(x, y, w, h) 22 due to title bar.

        GameMain panel = new GameMain();
        panel.setSize(FRAMEWIDTH, FRAMEHEIGHT);

        panel.setFocusable(true);
        panel.grabFocus();

        window.add(panel);
        window.setVisible(true);
        window.setResizable(false);
    }
}