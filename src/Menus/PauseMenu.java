package Menus;

import Execute.Panel;
import FuncLibraries.GameFunctions;
import FuncLibraries.Menu;
import FuncLibraries.MenuOption;

public class PauseMenu extends Menu{

    public PauseMenu(){
        MenuOption resume = new MenuOption("Resume", GameFunctions.FRAMEHEIGHT / 2) {
            @Override
            public void command() {
                Panel.startGame();
            }
        };
        MenuOption main = new MenuOption("Exit to Main Menu", GameFunctions.FRAMEHEIGHT / 2 + 100) {
            @Override
            public void command() {
                Panel.changeMenu(1);
                Panel.reset();
            }
        };
        MenuOption exit = new MenuOption("Exit", GameFunctions.FRAMEHEIGHT / 2 + 200) {
            @Override
            public void command() {
                System.exit(0);
            }
        };
        MenuOption[] menuOptions = {resume, main, exit};
        super.setup(menuOptions);
    }

}
