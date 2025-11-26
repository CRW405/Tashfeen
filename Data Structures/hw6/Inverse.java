import java.math.BigInteger;

public class Inverse {

  public static void main(String[] args) {

    BigInteger bigNumber = new BigInteger(
        "144644361721427313922062331675403123867343950242520475640707597283261643774925737501589409076350039814");

    System.out.println(unhash(bigNumber));
  }

  public static BigInteger hash(String str) {
    str = str.toLowerCase();
    BigInteger output = BigInteger.ZERO;

    int index = str.length() - 1;
    for (char character : str.toCharArray()) {
      int value = 0;

      if (character == ' ') {
        value = 0;
      } else {
        value = character - 'a' + 1;
      }

      output = output
          .add(BigInteger.valueOf(value).multiply(BigInteger.valueOf(27).pow(index)));

      index--;
    }
    return output;
  }

  public static String unhash(BigInteger hash) {
    StringBuilder output = new StringBuilder();

    int index = 0;
    for (BigInteger i = hash; i.compareTo(BigInteger.ZERO) > 0; index++) {
      BigInteger place = BigInteger.valueOf(27).pow(index);

      BigInteger remainder = i.divide(place); // (result, remainder)
      int value = remainder.mod(BigInteger.valueOf(27)).intValue();
      char character;
      if (value == 0) {
        character = ' ';
      } else {
        character = (char) ('a' + value - 1);
      }
      output.insert(0, character);
      i = i.subtract(BigInteger.valueOf(value).multiply(place));
    }
    return output.toString();
  }
}

/*
 * (' ', 0), (a, 1), (b, 2), (c, 3), ...
 * h(s) = sum(n-1, i=0) ( f(s_i)27^i ) mod m
 * h(' ') = (0*27^0) mod m = 0
 * h('a') = (1*27^0) mod m = 1
 * h('b') = (2*27^0) mod m = 2
 * h('bobby') = (2*27^0 + 25*27^1 + 2*27^2 + 15*27^3 + 25*27^4) mod m
 * = 1359664 mod m
 *
 */
