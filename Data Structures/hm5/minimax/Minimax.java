import java.util.Arrays;

public class Minimax {

  public Vertex root;
  public String message;

  public Minimax(int size) {
    this.message = "Tic Tac Toe";
    this.root = new Vertex(size);
    growTree(this.root, 1, 0);
  }

  private int growTree(Vertex root, int turn, int utility) {
    // implement me
  }

  public void play(int place) {
    // implement me
  }

  public int gameOverState() {
    if (this.root.children.size() > 0)
      return Vertex.CONT;
    return this.root.terminal();
  }

  private String evalMessage() {
    if (this.root.children.size() > 0)
      return this.message;
    else if (this.root.terminal() == 0)
      return "Draw! (right click to reset).";
    else
      return "Peasant! (right click to reset).";
  }
}