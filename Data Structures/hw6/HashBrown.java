import java.util.HashMap;
import java.util.LinkedList;

public class HashBrown {
  public static final long MAX = Integer.MAX_VALUE;

  public static void main(String[] args) {
    String contents = Frequency.read("./words_alpha.txt");
    String words[] = contents.split("\\s+");
    HashMap<Long, LinkedList<String>> map;
    map = new HashMap<Long, LinkedList<String>>();
    for (String word : words) {
      long hash = base27(word);
      if (!map.containsKey(hash))
        map.put(hash, new LinkedList<String>());
      map.get(hash).add(word);
    }

    int collisions = 0;
    for (Long key : map.keySet())
      if (map.get(key).size() > 1) {
        collisions += 1;
        System.out.printf("%15d:%s%n", key, map.get(key).toString());
      }
    System.out.printf("%d total collisions. ", collisions);

  }

  public static long base27(Object toHash) {
    String s = String.format("%s", toHash);
    long base = 27;
    long offset = 'a' - 1;
    long x = 0, p = 1;
    for (int i = s.length() - 1; i > -1; i--) {
      long bit = s.charAt(i);
      bit = bit == ' ' ? 0 : (bit - offset);
      x += bit * p;
      p *= base;
    }
    return Math.floorMod(x, MAX);
  }

  public static long hash(Object toHash) {
    return Math.floorMod(base27(toHash), MAX);
  }
}
