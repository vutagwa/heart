import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import javax.swing.JPanel;

public class javaheart extends JPanel {
    private static final long serialVersionUID = 1L;   // mainly for "picky" IDEs

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int margin = 5;   // just some margin around the heart shape
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        int boxSize = Math.min(panelWidth, panelHeight) - margin * 2;
        float boxX = (panelWidth - boxSize) / 2.0f;
        float boxY = (panelHeight - boxSize) / 2.0f;

        if (boxSize > 0) {
            Path2D heartPath = createHeartPath(boxX, boxY, boxSize, boxSize);

            // activates the "antialiasing" feature
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // sets the color and fills the shape
            g2d.setColor(Color.RED);
            g2d.fill(heartPath);
        }
    }

    private Path2D createHeartPath(float x, float y, float width, float height) {
        float beX = x + width / 2;  // bottom endpoint X
        float beY = y + height;     // bottom endpoint Y

        float c1DX = width  * 0.968f;  // delta X of control point 1
        float c1DY = height * 0.672f;  // delta Y of control point 1
        float c2DX = width  * 0.281f;  // delta X of control point 2
        float c2DY = height * 1.295f;  // delta Y of control point 2
        float teDY = height * 0.850f;  // delta Y of top endpoint

        Path2D.Float heartPath = new Path2D.Float();
        heartPath.moveTo(beX, beY);       // bottom endpoint
        // left side of heart
        heartPath.curveTo(
                beX - c1DX, beY - c1DY,   // control point 1
                beX - c2DX, beY - c2DY,   // control point 2
                beX       , beY - teDY);  // top endpoint
        // right side of heart
        heartPath.curveTo(
                beX + c2DX, beY - c2DY,   // control point 2
                beX + c1DX, beY - c1DY,   // control point 1
                beX       , beY);         // bottom endpoint
        return heartPath;
    }
}