// 25164150
public class Wiyninger3 {
  public static void main(String[] args) {
    int x = 0;
    int y = 0;

    for (int i = 1; i <= 100; i++) {
      x += i * i;
      y += i;
    }

    y = y * y;

    System.out.println("1^2 + 2^2 + ...: " + x);
    System.out.println("(1 + 2 + 3+...)^2: " + y);

    System.out.println("Difference: " + (y - x));
  }
}
