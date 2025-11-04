import java.util.ArrayList;

public class Investigate {
  public static void main(String[] args) {
    Minimax model = new Minimax(3);

    // 1 - How many tree-leaves result in a draw?
    int drawCount = drawCount(model.root);
    System.out.println(drawCount);
    // 2 - How many of the leaves win for the first (aka max) player
    int maxWinCount = maxWinCount(model.root);
    System.out.println(maxWinCount);
    // 3 - How many of the leaves win for the second (aka min) player
    int minWinCount = minWinCount(model.root);
    System.out.println(minWinCount);

    // System.out.println(model.root);
    // model.play(0);
    // System.out.println(model.root);
    // model.play(1);
    // System.out.println(model.root);
  }

  public static int drawCount(Vertex root) {
    ArrayList<Vertex> children = root.children;
    int count = 0;
    if (children.size() > 0) {
      for (Vertex child : children) {
        count += drawCount(child);
      }
    } else {
      if (root.terminal() == 0) {
        return count += 1;
      }
    }
    return count;
  }

  public static int maxWinCount(Vertex root) {
    ArrayList<Vertex> children = root.children;
    int count = 0;
    if (children.size() > 0) {
      for (Vertex child : children) {
        count += maxWinCount(child);
      }
    } else {
      if (root.terminal() == 1) {
        return count += 1;
      }
    }
    return count;
  }

  public static int minWinCount(Vertex root) {
    ArrayList<Vertex> children = root.children;
    int count = 0;
    if (children.size() > 0) {
      for (Vertex child : children) {
        count += minWinCount(child);
      }
    } else {
      if (root.terminal() == -1) {
        return count += 1;
      }
    }
    return count;
  }

}
