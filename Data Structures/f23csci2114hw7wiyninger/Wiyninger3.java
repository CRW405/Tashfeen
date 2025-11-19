public class Wiyninger3 {
  // 6857
  public static void main(String[] args) {
    long n = 600851475143L;

    long prime = 0;

    long cursor = 2;

    while (n > 1) {
      if (n % cursor == 0) {
        prime = cursor;
        n = n / cursor;
      } else {
        cursor++;
      }
    }

    System.out.println(prime);
  }
}
