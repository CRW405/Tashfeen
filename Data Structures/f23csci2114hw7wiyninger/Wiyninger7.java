public class Wiyninger7 { // 10001st Prime
  //
  // 104743
  public static void main(String[] args) {
    int n = 10001;

    boolean[] sieve = new boolean[n * 20];

    for (int i = 2; i < sieve.length; i++) {
      sieve[i] = true;
    }

    for (int i = 2; i * i < sieve.length; i++) {
      if (sieve[i]) {
        for (int j = i * i; j < sieve.length; j += i) {
          sieve[j] = false;
        }
      }
    }

    int count = 0;
    for (int i = 2; i < sieve.length; i++) {
      if (sieve[i]) {
        count++;
        if (count == n) {
          System.out.println(i);
          break;
        }
      }
    }
  }
}
