import java.awt.*;
import javax.swing.*;

public class practiceplane extends JPanel {
    static final int SCREENHEIGHT = 600,SCREENWIDTH = 600, UNITSIZE = 25;
    practiceplane(){
        this.setPreferredSize(new Dimension(SCREENHEIGHT,SCREENWIDTH));
        this.setFocusable(true);
        this.setBackground(Color.black);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        for(int i=0; i<SCREENHEIGHT/UNITSIZE;i++){
        g.drawLine(i*UNITSIZE, 0, i*UNITSIZE, SCREENHEIGHT);
        g.drawLine(0, i*UNITSIZE, SCREENWIDTH, i*UNITSIZE);
        }
    }
}
 