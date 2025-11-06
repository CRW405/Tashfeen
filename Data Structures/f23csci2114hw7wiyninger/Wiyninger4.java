public class Wiyninger4 {
  public static void main(String[] args) {
    long number = 20;
    long expected = 232792560;

    long actual = findSmallestMultiple(number);
    System.out.println(actual);

    // actual = 18044195
    // exprected = 232792560
    if (actual == expected) {
      System.out.println(":)");
    } else {
      System.out.println(":(");
    }
  }

  public static long findSmallestMultiple(long input) {
    long result = 1;
    for (int i = 2; i <= input; i++) {
      System.out.println("getting lcm of result: " + result + " and i: " + i);
      result = lcm(result, i);
      System.out.println("lcm: " + result);
    }
    return result;
  }

  private static long lcm(long a, long b) {
    long gcd = gcd(a, b);
    System.out.println("    " + a + " * " + b + " / " + gcd);
    return a * b / gcd;
  }

  private static long gcd(long a, long b) {
    while (b != 0) {
      long temp = b;
      b = a % b;
      a = temp;
      System.out.println("        a:" + a + " b: " + b);
    }
    return a;
  }
}
