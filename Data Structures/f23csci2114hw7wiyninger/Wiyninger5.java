// 232792560
public class Wiyninger5 {
  public static void main(String[] args) {
    // long n = 10;
    long n = 20;

    for (long i = n; i < factorial(n); i += n) {
      if (cleanlyDivisable(i, n)) {
        System.out.println(i);
        break;
      }
    }
  }

  public static boolean cleanlyDivisable(long n, long d) {
    for (long i = 1; i <= d; i++) {
      if (n % i != 0) {
        return false;
      }
    }
    return true;
  }

  public static long factorial(long n) {
    long o = 1;
    for (long i = 1; i <= n; i++) {
      o = o * i;
    }
    return o;
  }
}
