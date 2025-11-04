import java.util.ArrayList;
import java.util.Collections;

public class Vertex implements Comparable<Vertex> {
  final static int CONT = 2;

  public byte utility = CONT;
  public byte size;
  public byte[] board;
  public ArrayList<Vertex> children;

  public Vertex(int size) {
    this.size = (byte)size;
    this.board = new byte[this.size * this.size];
    this.children = new ArrayList<Vertex>();
  }

  public byte minimax(int turn) {
    if (turn == 1)
      return (this.utility = this.max().utility);
    return (this.utility = this.min().utility);
  }

  public byte terminal() {
    int n = this.size;
    byte[] b = this.board;

    for (int i = 0; i < n; i++) { // rows
      boolean rowWin = true;
      for (int j = 1; j < n; j++) {
        if (b[i * n + j] == 0 || b[i * n + j] != b[i * n + j - 1]) {
          rowWin = false;
          break;
        }
      }
      if (rowWin)
        return b[i * n];
    }

    for (int j = 0; j < n; j++) { // columns
      boolean colWin = true;
      for (int i = 1; i < n; i++) {
        if (b[i * n + j] == 0 || b[i * n + j] != b[(i - 1) * n + j]) {
          colWin = false;
          break;
        }
      }
      if (colWin)
        return b[j];
    }

    boolean diagWin = true;
    for (int i = 1; i < n; i++) { // diagonal
      if (b[i * n + i] == 0 || b[i * n + i] != b[(i - 1) * n + i - 1]) {
        diagWin = false;
        break;
      }
    }
    if (diagWin)
      return b[0];

    diagWin = true;
    for (int i = 1; i < n; i++) { // anti-diagonal
      int k = i * n + (n - i - 1);
      if (b[k] == 0 || b[k] != b[(i - 1) * n + (n - i)]) {
        diagWin = false;
        break;
      }
    }
    if (diagWin)
      return b[n - 1];

    for (int cell : b) { // game CONTinued
      if (cell == 0)
        return CONT;
    }
    return 0; // draw
  }

  public void grow(int place, int turn) {
    if (this.board[place] != 0) // is marked
      return;
    Vertex child = new Vertex(this.size);
    System.arraycopy(this.board, 0, child.board, 0, child.board.length);
    child.board[place] = (byte)turn;
    this.children.add(child);
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < this.size; i++) {
      for (int j = 0; j < this.size; j++)
        sb.append(String.format("%d ", this.board[i * this.size + j]));
      if (i < this.size - 1)
        sb.append("\n");
    }
    return "-----\n" + sb.toString() + "\n-----";
  }

  public Vertex min() {
    if (children.size() <= 0)
      return this;
    return Collections.min(this.children);
  }

  public Vertex max() {
    if (children.size() <= 0)
      return this;
    return Collections.max(this.children);
  }

  public int compareTo(final Vertex o) {
    return Integer.compare(this.utility, o.utility);
  }
}
