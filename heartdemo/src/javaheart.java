import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import javax.swing.*;
public class javaheart extends JPanel{
    private static final long serialVersionUID = 1L;
    @Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        int margin = 5;
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        int boxSize = Math.min(panelWidth, panelHeight)-margin*2;
        float boxX = (panelWidth - boxSize)/2.0f;
        float boxY = (panelHeight - boxSize)/2.0f;
        if(boxSize>0){
            Path2D heartPath = createHeartPath(boxX, boxY, boxSize, boxSize);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(Color.blue);
            g2d.fill(heartPath);
        }
    }

    private Path2D createHeartPath(float X, float Y, float width, float height) {
        float beX = X + width/2;
        float beY = Y + height;
        float C1DX = width*0.968f;
        float C1DY = height*672f;
        float C2DX = width*0.281f;
        float C2Dy = height*1.295f;
        float teDY = height*0.850f;
        Path2D.Float heartPath = new Path2D.Float();
        heartPath.moveTo(beX, beY);
        heartPath.curveTo(
                beX - C1DX,beY - C1DY, 
                beX - C2DX,beY - C2Dy, 
                beX     ,beY - teDY);
        heartPath.curveTo(
                beX - C1DX, beY - C1DY, 
                beX - C2DX, beY-C2Dy, 
                beX   , beY);
        return heartPath;
    }
}
