import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Game extends JPanel {

  public static void main(String[] args) {
    int size = args.length > 0 ? Integer.parseInt(args[0]) : 3;

    Minimax model = new Minimax(size); // set-up the MVC architecture
    Mouse control = new Mouse(model);
    Game view = new Game(control);

    Toolkit kit = Toolkit.getDefaultToolkit(); // figure out measurements
    Dimension screen = kit.getScreenSize();
    int length = Math.min(screen.width, screen.height);
    length = (int)(Math.log(length) / Math.log(2));
    length = (int)Math.pow(2, length);
    int pad = (int)(Math.pow(2, -5) * length);

    JPanel container = new JPanel(); // this will contain the view
    container.setBorder(new EmptyBorder(pad, pad, pad, pad));
    container.setLayout(new BorderLayout());
    container.add(view, BorderLayout.CENTER);

    JFrame frame = new JFrame(); // this will contain the container
    frame.setSize(length / 2, length / 2);
    frame.add(container, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  private Mouse control;

  public Game(Mouse control) {
    this.control = control;
    this.addMouseListener(control);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    this.removeAll();
    this.getParentFrame().setTitle(this.control.model.message);
    this.drawLattice(g);
    this.drawMoves(g);
  }

  private JFrame getParentFrame() {
    Container con = this.getParent();
    while (!(con instanceof JFrame))
      con = con.getParent();
    return (JFrame)con;
  }

  private void drawLattice(Graphics g) {
    Graphics2D g2 = (Graphics2D)g;
    g2.setStroke(new BasicStroke(3));
    int size = this.control.model.root.size;
    int width = getWidth();
    int height = getHeight();

    for (int i = 1; i < size; i++) {
      int x = i * width / size;
      g2.drawLine(x, 0, x, height);
    }

    for (int i = 1; i < size; i++) {
      int y = i * height / size;
      g2.drawLine(0, y, width, y);
    }
  }

  private void drawMoves(Graphics g) {
    Graphics2D g2 = (Graphics2D)g;
    byte[] b = this.control.model.root.board;
    int size = this.control.model.root.size; // Get the grid size
    int w = getWidth() / size;
    int h = getHeight() / size;

    for (int i = 0; i < b.length; i++) {
      if (b[i] == 0)
        continue; // Skip vacant spaces

      int row = i / size;
      int col = i % size;
      int x1 = col * w;
      int y1 = row * h;
      int x2 = (col + 1) * w;
      int y2 = (row + 1) * h;

      this.mark(x1, y1, x2, y2, b[i], g2);
    }
  }

  private void mark(int x1, int y1, int x2, int y2, int turn, Graphics2D g2) {
    int xp = (x2 - x1) / 5, yp = (y2 - y1) / 5;
    if (turn == 1) {
      g2.setColor(Color.RED);
      g2.drawLine(x1 + xp, y1 + yp, x2 - xp, y2 - yp);
      g2.drawLine(x2 - xp, y1 + yp, x1 + xp, y2 - yp);
      g2.setColor(Color.BLACK);
    } else {
      g2.setColor(Color.BLUE);
      g2.drawOval(x1 + xp, y1 + yp, x2 - x1 - 2 * xp, y2 - y1 - 2 * yp);
      g2.setColor(Color.BLACK);
    }
  }
}

class Mouse extends MouseAdapter {

  public Minimax model;

  public Mouse(Minimax model) {
    this.model = model;
  }

  public void mousePressed(MouseEvent e) {
    Game gm = (Game)e.getSource();
    if (e.getButton() == MouseEvent.BUTTON3)
      this.model = new Minimax(this.model.root.size); // this was a reset click
    else
      this.changeModel(e.getX(), e.getY(), gm.getWidth(), gm.getHeight());
    gm.repaint();
  }

  private void changeModel(int x, int y, int w, int h) {
    int size = this.model.root.size;
    int col = x / (w / size);
    int row = y / (h / size);
    int index = row * size + col;
    this.model.play(index);
  }
}
