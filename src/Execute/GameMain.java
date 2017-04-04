package Execute;

import javax.swing.*;

import java.awt.*;

import static FuncLibraries.GameFunctions.FRAMEHEIGHT;
import static FuncLibraries.GameFunctions.FRAMEWIDTH;

public class GameMain{

    static final boolean debug = true;

    static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

    public static void main(String[] args) {
        JFrame window = new JFrame("Ermahgerd Hopps is playing this");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, FRAMEWIDTH, FRAMEHEIGHT + 22);
        //window.setUndecorated(true);
        //device.setFullScreenWindow(window);
        Panel panel = new Panel();
        panel.setSize(FRAMEWIDTH, FRAMEHEIGHT);
        panel.setFocusable(true);
        panel.grabFocus();
        window.add(panel);
        window.setVisible(true);
        window.setResizable(false);
    }
}