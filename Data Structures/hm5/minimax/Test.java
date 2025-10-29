import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test {
  public static void main(String[] args) {
    String PASS = String.format("[\u001B[%dmPASS\u001B[m]", 42);
    String FAIL = String.format("[\u001B[%dmFAIL\u001B[m]", 41);
    Minimax model = new Minimax(3);
    int minWins = DFS(model.root, -1);
    int draws = DFS(model.root, 0);
    int maxWins = DFS(model.root, 1);
    int leftMostBranchLength = measureDepth(model.root, 0);
    int rightMostBranchLength = measureDepth(model.root, -1);
    int totalVertices = treeSize(model.root);
    String boards = tree(model.root).toString();
    String expectedBoards = null;
    try {
      expectedBoards = Files.readString(Paths.get("boards.txt"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    if (minWins + draws + maxWins == 255168)
      System.out.printf("%s Total leaves.%n", PASS);
    else
      System.out.printf("%s Total leaves.%n", FAIL);
    if (maxWins == 131184)
      System.out.printf("%s Win leaves.%n", PASS);
    else
      System.out.printf("%s Win leaves.%n", FAIL);
    if (draws == 46080)
      System.out.printf("%s Draw leaves.%n", PASS);
    else
      System.out.printf("%s Draw leaves.%n", FAIL);
    if (minWins == 77904)
      System.out.printf("%s Lose leaves.%n", PASS);
    else
      System.out.printf("%s Lose leaves.%n", FAIL);
    if (leftMostBranchLength == 8)
      System.out.printf("%s Leftmost length.%n", PASS);
    else
      System.out.printf("%s Leftmost length.%n", FAIL);
    if (rightMostBranchLength == 8)
      System.out.printf("%s Rightmost length.%n", PASS);
    else
      System.out.printf("%s Rightmost length.%n", FAIL);
    if (totalVertices == 549946)
      System.out.printf("%s Vertex count.%n", PASS);
    else
      System.out.printf("%s Vertex count.%n", FAIL);
    if (boards.equals(expectedBoards))
      System.out.printf("%s Vertex value.%n", PASS);
    else
      System.out.printf("%s Vertex value.%n", FAIL);
    if (tryWinning(100))
      System.out.printf("%s Unbeatable.%n", PASS);
    else
      System.out.printf("%s Model beat.%n", FAIL);
  }

  public static boolean tryWinning(int n) {
    int lo = 0, hi = 8;
    Minimax model = new Minimax((byte)3);
    while ((n = n - 1) > 0) {
      model = new Minimax(3);
      while (model.gameOverState() == Vertex.CONT) {
        int move = lo + (int)(Math.random() * (hi - lo + 1));
        model.play(move);
      }
      if (model.gameOverState() == 1)
        return false;
    }
    return true;
  }

  public static int DFS(Vertex root, int player) {
    if (root.children.size() <= 0)
      return root.utility == player ? 1 : 0;
    int count = 0;
    for (Vertex child : root.children)
      count += DFS(child, player);
    return count;
  }

  public static int measureDepth(Vertex root, int direction) {
    if (root.children.size() <= 0)
      return 1;
    int i = direction >= 0 ? direction : root.children.size() + direction;
    return 1 + measureDepth(root.children.get(i), direction);
  }

  public static int treeSize(Vertex root) {
    if (root.children.size() <= 0)
      return 1;
    int count = 1;
    for (Vertex child : root.children)
      count += treeSize(child);
    return count;
  }

  public static StringBuilder tree(Vertex root) {
    StringBuilder sb = new StringBuilder();
    for (Byte i : root.board)
      sb.append(i);
    sb.append(root.utility);
    if (root.children.size() <= 0)
      return sb;
    for (Vertex child : root.children)
      sb.append(tree(child));
    return sb;
  }
}