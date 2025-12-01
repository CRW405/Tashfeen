public class Wiyninger9 {
  // 31875000

  public static void main(String[] args) {
    // a^2 + b^2 = c^2
    // c = (a^2 + b^2)^1/2
    //
    // a^2 + b^2 = 1000

    int a = 1;
    int b = 1;
    double c = Math.sqrt(1000);

    for (a = 1; a < 1000; a++) {
      for (b = 1; b < 1000; b++) {
        c = Math.sqrt((a * a) + (b * b));
        if (a + b + c == 1000) {
          System.out.println((a * b * (int) c));
        }
      }
    }
  }
}
