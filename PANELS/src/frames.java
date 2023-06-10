import java.awt.*;
import javax.swing.*;
public class frames extends JFrame {
    frames(){
        this.add(new practiceplane());
        this.setTitle("maerion");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
