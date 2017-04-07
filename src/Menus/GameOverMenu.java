package Menus;

import Execute.Panel;
import FuncLibraries.GameFunctions;
import FuncLibraries.MenuOption;

import java.awt.*;

public class GameOverMenu extends FuncLibraries.Menu {

    public GameOverMenu(){
        MenuOption playagain = new MenuOption("Play again", GameFunctions.FRAMEHEIGHT / 2) {
            @Override
            public void command() {
                Panel.reset();
                Panel.startGame();
            }
        };
        MenuOption main = new MenuOption("Exit to Main Menu", GameFunctions.FRAMEHEIGHT / 2 + 100) {
            @Override
            public void command() {
                Panel.reset();
                Panel.changeMenu(1);
            }
        };
        MenuOption exit = new MenuOption("Exit", GameFunctions.FRAMEHEIGHT / 2 + 200) {
            @Override
            public void command() {
                System.exit(0);
            }
        };
        MenuOption[] menuOptions = {playagain, main, exit};
        super.setup(menuOptions);
    }

    public void draw(Graphics2D g2){
        super.draw(g2);
        g2.setColor(Color.WHITE);
        g2.drawString("Game over! Your score was: " + FuncLibraries.Score.getScore(), 150, GameFunctions.FRAMEHEIGHT/2 - 75);
    }

}
