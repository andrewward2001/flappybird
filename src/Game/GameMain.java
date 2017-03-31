package Game;

import FuncLibraries.GameFunctions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameMain extends JPanel {

    //instance fields for the general environment
    static final int FRAMEWIDTH = 1000, FRAMEHEIGHT = 600;
    private Background bg;
    private Timer timer;
    private boolean[] keys;
    private Bird bird;
    private ArrayList<PipeSet> pipeSets;
    private GameFunctions functions;
    private boolean debug;

    static boolean active;

    GameMain(){

        keys = new boolean[512]; //should be enough to hold any key code.
        //initialize the instance fields.
        bird = new Bird();
        pipeSets = new ArrayList<>();
        for(int i = 1; i <= 20; i++)
            pipeSets.add(new PipeSet(1000 + i * 300));
        bg = new Background();
        functions = new GameFunctions();
        active = false;
        timer = new Timer(40, e -> {
            if(keys[KeyEvent.VK_SPACE])
                bird.bump();

            for(PipeSet s: pipeSets)
                s.update();
            bird.update();
            //update each obstacle

            //check for collisions
            boolean b = false;
            if(functions.checkEnemyHitDetection(pipeSets, bird) || functions.checkBackgroundHitDetection(bg, bird))
                b = true;
            if(b)
                endGame();
            else
                repaint();

            while(!active)
                endGame();
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

    //Our paint method.
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        bg.draw(g2);
        for(PipeSet p: pipeSets)
            p.draw(g2);
        bird.draw(g2);

    }

    private void endGame(){
        endGame();
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