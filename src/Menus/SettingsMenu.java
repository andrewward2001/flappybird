package Menus;

import Execute.Panel;
import FuncLibraries.GameFunctions;
import FuncLibraries.MenuOption;
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
        MenuOption back = new MenuOption("Back to main menu", GameFunctions.FRAMEHEIGHT / 2 + 200) {
            @Override
            public void command() {
                Panel.changeMenu(1);
            }
        };
        MenuOption[] menuOptions = {sound, debugEnabled, back};
        super.setup(menuOptions);
    }

    @NotNull
    @Contract(pure = true)
    private String status(boolean b){
        if(b) return "Enabled";
        else return "Disabled";
    }

}
