public class Coordinates implements Comparable<Coordinates> {
  public int x;
  public int y;
  public int w;
  public int h;

  public Coordinates(int x, int y, int w, int h) {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
  }

  public String toString() {
    String f = "[%d, %d, %d, %d]";
    return String.format(f, this.x, this.y, this.w, this.h);
  }

  public int compareTo(Coordinates other) {
    return 0;
  }
}