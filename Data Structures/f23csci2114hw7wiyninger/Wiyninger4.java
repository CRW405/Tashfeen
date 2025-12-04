// 906609
public class Wiyninger4 {

  public static void main(String[] args) {
    // 9009 = 91 * 99 // 2 digits
    // 3 digits?
    int n = 0;
    String nString = "";
    int l = 0;
    int largest = 0;
    for (int i = 999; i >= 100; i--) {
      for (int j = 999; j >= 100; j--) {
        n = i * j;
        // System.out.println("n: " + n);
        // System.out.println("i: " + i);
        // System.out.println("j: " + j);
        nString = String.valueOf(n);
        if (nString.length() % 2 != 0) {
          continue;
        }
        l = nString.length();
        // System.out.println("comparing: " + nString.substring(0, l / 2) + " with " +
        // nString.substring(l / 2, l));
        if (nString.substring(0, l / 2).equals(reverse(nString.substring(l / 2, l)))) {
          // System.out.println("Palindrome found: ");
          // System.out.println("n: " + n);
          // System.out.println("i: " + i);
          // System.out.println("j: " + j);
          if (n > largest) {
            largest = n;
          }
        }
      }
    }
    System.out.println(largest);
  }

  public static String reverse(String s) {
    String r = "";
    for (int i = s.length() - 1; i >= 0; i--) {
      r += s.charAt(i);
    }
    return r;
  }
}
