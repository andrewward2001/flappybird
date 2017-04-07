package FuncLibraries;

import java.awt.*;

public abstract class MenuOption {

    private String option;
    private final int x = GameFunctions.FRAMEWIDTH/10, xx = x + 25;
    private int y;
    private boolean isSelected;

    protected MenuOption(String option, int y){
        this.option = option;
        this.y = y;
        isSelected = false;
    }

    void draw(Graphics2D g2){
        g2.setColor(Color.DARK_GRAY);
        g2.setFont(new Font(null, Font.PLAIN, 50));
        g2.drawString(option, xx, y);
        if(isSelected)
            g2.drawRect(x, y - 50, x + 500, 75);
    }

    void setSelected(boolean b){
        isSelected = b;
    }

    public abstract void command();

}
