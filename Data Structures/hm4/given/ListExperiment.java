import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListExperiment {
  public static void main(String[] args) {
    List<Integer> ls = null;
    StringBuilder sb = new StringBuilder();
    appendTimes((int) Math.pow(2, 20), ls, sb);
    searchTimes((int) Math.pow(2, 17), ls, sb);
  }

  /**
   * FOR ls IN [ArrayList, LinkedList]:
   * i = 1
   * WHILE i is less than n:
   * record time for appending on ls
   * i++
   *
   * At return, there should be a CSV file with two rows. The first
   * for the ArrayList and the second for the LinkedList. The ith
   * column of each row represents the nanoseconds taken to append
   * the ith element.
   *
   * @param n  The row length.
   * @param ls The list that is either an array or linked list.
   * @param sb The string builder to join the nanoseconds.
   */
  public static void appendTimes(int n, List<Integer> ls, StringBuilder sb) {
    ArrayList<Integer> al = new ArrayList<Integer>();
    LinkedList<Integer> ll = new LinkedList<Integer>();

    long start;
    long end;

    for (List ls : [al,ll]) {
        int i = 1;
        while (i < n) {
            start = System.currentTimeMillis();
            ls.add(i);
            end = System.currentTimeMillis() - start;
            sb.append(end, ", ");
        }
        sb.append("\n");
    }
    System.out.println(sb.toString());
    return;
  }

  /**
   * FOR ls IN [ArrayList, LinkedList]:
   * i = 1
   * WHILE 2^i is less than n:
   * assure ls is empty
   * fill ls with 2^i random integers
   * let x be a random integer
   * record time for binary searching x in ls
   * i++
   *
   * At return, there should be a CSV file with two rows. The first
   * for the ArrayList and the second for the LinkedList. The ith
   * column of each row represents the nanoseconds taken to perform
   * the binary search on a list of size 2^i.
   *
   * @param n  The row length.
   * @param ls The list that is either an array or linked list.
   * @param sb The string builder to join the nanoseconds.
   */
  public static void searchTimes(int n, List<Integer> ls, StringBuilder sb) {
    return;
  }

  /**
   * @param ls The list to binary search.
   * @param n  The integer to look for.
   * @param s  The starting bound.
   * @param r  The ending bound.
   * @return Whether n was found in ls.
   */
  public static boolean binarySearch(List<Integer> ls, int n, int s, int r) {
    return false;
  }

  /**
   * Write, appending or overwriting, a string to a file.
   *
   * @param path   The path of the file to write to.
   * @param line   The line to write to the file at that path.
   * @param append Whether to append or overwrite the file.
   */
  public static void write(String path, String line, boolean append) {
    try (FileWriter fw = new FileWriter(path, append)) {
      fw.write(line + "\n");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * Fill the list ls with random integers and sort it.
   *
   * @param min The lower bound (inclusive) for the random n.
   * @param max The upper bound (exclusive) for the random n.
   * @param ls  The list to fill with random integers n.
   */
  public static void fillList(int min, int max, List<Integer> ls) {
    for (int i = 0; i < max; i++)
      ls.add(randomInteger(min, max));
    Collections.sort(ls);
  }

  /**
   * @param min The lower bound (inclusive) for the random n.
   * @param max The upper bound (exclusive) for the random n.
   * @return A random integer n between min and max.
   */
  public static int randomInteger(int min, int max) {
    return min + (int) (Math.random() * (max - min));
  }s
}
