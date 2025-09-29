import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Canvas extends JPanel {
  private Sierpinski sierpinski;

  public Canvas(Sierpinski sierpinski) {
    this.sierpinski = sierpinski;
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    JFrame frame = new JFrame("Sierpinski's Triangle");
    frame.setSize(screenSize.width / 2, screenSize.height / 2);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(this);
    frame.setVisible(true);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Queue<Coordinates> q = new Queue<>();
    this.sierpinski.points(0, 0, getWidth(), getHeight(), q, 0);
    while (q != null && !q.isEmpty()) {
      Coordinates c = q.pop();
      int[] xPoints = {c.x + c.w / 2, c.x, c.x + c.w};
      int[] yPoints = {c.y, c.y + c.h, c.y + c.h};
      g.drawPolygon(xPoints, yPoints, 3);
    }
  }
}