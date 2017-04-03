package FuncLibraries;

import Execute.GameMain;

import java.awt.*;

public class HitBox extends Rectangle{

    public HitBox(Rectangle r){
        this.setBounds(r);
    }

    public void drawHitBox(Graphics2D g2){
        if(GameMain.debug)
            g2.drawRect(this.x, this.y, this.width, this.height);
    }

}
