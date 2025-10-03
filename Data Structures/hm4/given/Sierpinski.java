public class Sierpinski {
  public static void main(String[] args) {
    new Canvas(new Sierpinski());
  }

  public void points(int x, int y, int w, int h, Queue<Coordinates> q, int r) {
    if (r == 8) {
      q.push(new Coordinates(x, y, w, h));
      return;
    }

    points(x + w / 4, y, w / 2, h / 2, q, r + 1);
    points(x, y + h / 2, w / 2, h / 2, q, r + 1);
    points(x + w / 2, y + h / 2, w / 2, h / 2, q, r + 1);
  }
}
