import javax.swing.JFrame;

public class DrawCanvas {
    public static void main(String args[]) {
        JFrame mainFrame = new JFrame("Graphics demo");
        mainFrame.getContentPane().add(new MyCanvas());
        mainFrame.pack();
        mainFrame.setVisible(true);
      }
    
}
