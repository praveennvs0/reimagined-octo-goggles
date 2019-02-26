import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Peach extends JPanel{

    public void paintComponent2(Graphics g) {
      //  super.paintComponent(g);
        this.setBackground(Color.WHITE);
        
        g.setColor(Color.BLUE);
        g.drawRect(1, 1, 250, 50);
        
        g.setColor(Color.RED);
        g.drawRect(10, 10, 150, 50);
    }
}
