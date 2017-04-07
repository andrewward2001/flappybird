package Menus;

import Execute.Panel;
import FuncLibraries.GameFunctions;
import FuncLibraries.MenuOption;
import Game.Bird;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import static Execute.Panel.*;

public class SettingsMenu extends FuncLibraries.Menu {

    public SettingsMenu(){
        MenuOption sound = new MenuOption("Sound: " + status(isSoundEnabled), GameFunctions.FRAMEHEIGHT / 2) {
            @Override
            public void command() {
                isSoundEnabled = !isSoundEnabled;
            }
        };
        MenuOption debugEnabled = new MenuOption("Debug: " + status(debug), GameFunctions.FRAMEHEIGHT / 2 + 100) {
            @Override
            public void command() {
                debug = !debug;
            }
        };
        MenuOption drawBen = new MenuOption("Easter Egg: " + status(Bird.drawBen), GameFunctions.FRAMEHEIGHT / 2 + 200) {
            @Override
            public void command() {
                Bird.drawBen = !Bird.drawBen;
            }
        };
        MenuOption back = new MenuOption("Back to main menu", GameFunctions.FRAMEHEIGHT / 2 + 300) {
            @Override
            public void command() {
                Panel.changeMenu(1);
            }
        };
        MenuOption[] menuOptions = {sound, debugEnabled, drawBen, back};
        super.setup(menuOptions);
    }

    @NotNull
    @Contract(pure = true)
    private String status(boolean b){
        if(b) return "Enabled";
        else return "Disabled";
    }

}
