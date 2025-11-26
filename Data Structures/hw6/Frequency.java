import java.io.IOException;
import java.nio.file.Files;
import java.util.Map.Entry;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.nio.file.Files.readString;

public class Frequency {

  public static void main(String[] args) {
    String book = read("./TheKingInYellow.txt").toLowerCase().replace("\n", " ");
    String[] tokens = book.split("\\s+");
    StringBuilder filteredContents = new StringBuilder();

    for (int i = 0; i < book.length(); i++) {
      char c = book.charAt(i);
      if (Character.isLetter(c) || Character.isWhitespace(c)) {
        filteredContents.append(c);
      }
    }

    String[] words = filteredContents.toString().split("\\s+");
    HashMap<String, Integer> counts = new HashMap<>();

    for (String word : words) {
      if (word.length() < 6)
        continue;
      counts.put(word, counts.getOrDefault(word, 0) + 1);

      if (counts.containsKey(word)) {
        counts.put(word, counts.get(word) + 1);
      } else {
        counts.put(word, 1);
      }
    }

    List<Map.Entry<String, Integer>> entryList = new ArrayList<>(counts.entrySet());
    entryList.sort(Entry.comparingByValue(Comparator.reverseOrder()));

    int i = 0;

    for (Entry<String, Integer> entry : entryList) {
      System.out.printf("%15s:%4d%n", entry.getKey(), entry.getValue());
      if (++i >= 10)
        break;
    }
  }

  public static String read(String filePath) {
    byte[] ret = null;
    try {
      ret = Files.readAllBytes(Paths.get(filePath));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new String(ret);
  }
}
