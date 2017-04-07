package Menus;

import Execute.Panel;
import FuncLibraries.GameFunctions;
import FuncLibraries.MenuOption;

public class MainMenu extends FuncLibraries.Menu {


    public MainMenu(){
        MenuOption start = new MenuOption("Start", GameFunctions.FRAMEHEIGHT / 2) {
            @Override
            public void command() {
                Panel.startGame();
            }
        };
        MenuOption settings = new MenuOption("Settings", GameFunctions.FRAMEHEIGHT / 2 + 100) {
            @Override
            public void command() {
                Panel.changeMenu(2);
            }
        };
        MenuOption exit = new MenuOption("Exit", GameFunctions.FRAMEHEIGHT / 2 + 200) {
            @Override
            public void command() {
                System.exit(0);
            }
        };
        MenuOption[] menuOptions = {start, settings, exit};
        super.setup(menuOptions);
    }

}
