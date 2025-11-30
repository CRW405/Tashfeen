public class Wiyninger10 {
  // 142913828922
  // summation of primes below two million
  public static void main(String[] args) {
    boolean[] primes = new boolean[2000000];

    for (int i = 2; i < primes.length; i++) {
      primes[i] = true;
    }

    for (int i = 2; i * i < primes.length; i++) {
      if (primes[i]) {
        for (int j = i * i; j < primes.length; j += i) {
          primes[j] = false;
        }
      }
    }

    long sum = 0;

    for (int i = 2; i < primes.length; i++) {
      if (primes[i]) {
        sum += i;
      }
    }

    System.out.println(sum);
  }
}
