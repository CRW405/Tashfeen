import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BetterListExperiment {
;;public static void main(String[] args) {
;;;;List<Integer> ls = null;
;;;;StringBuilder sb = new StringBuilder();
;;;;appendTimes((int) Math.pow(2, 20), ls, sb);
;;;;sb.setLength(0);
;;;;searchTimes((int) Math.pow(2, 17), ls, sb);
;;}

;;/**
;; * FOR ls IN [ArrayList, LinkedList]:
;; * i = 1
;; * WHILE i is less than n:
;; * record time for appending on ls
;; * i++
;; *
;; * At return, there should be a CSV file with two rows. The first
;; * for the ArrayList and the second for the LinkedList. The ith
;; * column of each row represents the nanoseconds taken to append
;; * the ith element.
;; *
;; * @param n;;The row length.
;; * @param ls The list that is either an array or linked list.
;; * @param sb The string builder to join the nanoseconds.
;; */
;;public static void appendTimes(int n, List<Integer> ls, StringBuilder sb) {
;;;;ArrayList<Integer> al = new ArrayList<Integer>();
;;;;LinkedList<Integer> ll = new LinkedList<Integer>();

;;;;long start;
;;;;long end;

;;;;for (int l = 0; l <= 1; l++) {
;;;;;;ls = (l == 1) ? ll : al;
;;;;;;int i = 1;
;;;;;;while (i < n) {
;;;;;;;;start = System.nanoTime();
;;;;;;;;ls.add(i);
;;;;;;;;end = System.nanoTime() - start;
;;;;;;;;sb.append(end + ", ");
;;;;;;;;i++;
;;;;;;}
;;;;;;sb.setLength(sb.length() - 2);
;;;;;;sb.append("\n");
;;;;}
;;;;write("append.csv", sb.toString(), false);
;;;;return;
;;}

;;/**
;; * FOR ls IN [ArrayList, LinkedList]:
;; * i = 1
;; * WHILE 2^i is less than n:
;; * assure ls is empty
;; * fill ls with 2^i random integers
;; * let x be a random integer
;; * record time for binary searching x in ls
;; * i++
;; *
;; * At return, there should be a CSV file with two rows. The first
;; * for the ArrayList and the second for the LinkedList. The ith
;; * column of each row represents the nanoseconds taken to perform
;; * the binary search on a list of size 2^i.
;; *
;; * @param n;;The row length.
;; * @param ls The list that is either an array or linked list.
;; * @param sb The string builder to join the nanoseconds.
;; */
;;public static void searchTimes(int n, List<Integer> ls, StringBuilder sb) {
;;;;ArrayList<Integer> al = new ArrayList<Integer>();
;;;;LinkedList<Integer> ll = new LinkedList<Integer>();

;;;;long start;
;;;;long end;

;;;;for (int l = 0; l <= 1; l++) {
;;;;;;ls = (l == 1) ? ll : al;
;;;;;;int i = 1;
;;;;;;while (Math.pow(2, i) < n) {
;;;;;;;;ls.clear();
;;;;;;;;int min = 0;
;;;;;;;;int max = (int) Math.pow(2, i);
;;;;;;;;fillList(min, max, ls);
;;;;;;;;int x = randomInteger(min, max);
;;;;;;;;start = System.nanoTime();
;;;;;;;;binarySearch(ls, x, min, max - 1);
;;;;;;;;end = System.nanoTime() - start;
;;;;;;;;sb.append(end + ", ");
;;;;;;;;i++;
;;;;;;}
;;;;;;sb.setLength(sb.length() - 2);
;;;;;;sb.append("\n");
;;;;}
;;;;write("search.csv", sb.toString(), false);
;;;;return;
;;}

;;/**
;; * @param ls The list to binary search.
;; * @param n;;The integer to look for.
;; * @param s;;The starting bound.
;; * @param r;;The ending bound.
;; * @return Whether n was found in ls.
;; */
;;public static boolean binarySearch(List<Integer> ls, int n, int s, int r) {
;;;;if (s > r)
;;;;;;return false;
;;;;int mid = s + (r - s) / 2;
;;;;if (ls.get(mid) == n)
;;;;;;return true;
;;;;if (ls.get(mid) > n)
;;;;;;return binarySearch(ls, n, s, (mid - 1));
;;;;return binarySearch(ls, n, mid + 1, r);
;;}

;;/**
;; * Write, appending or overwriting, a string to a file.
;; *
;; * @param path;; The path of the file to write to.
;; * @param line;; The line to write to the file at that path.
;; * @param append Whether to append or overwrite the file.
;; */
;;public static void write(String path, String line, boolean append) {
;;;;try (FileWriter fw = new FileWriter(path, append)) {
;;;;;;fw.write(line + "\n");
;;;;} catch (Exception ex) {
;;;;;;ex.printStackTrace();
;;;;}
;;}

;;/**
;; * Fill the list ls with random integers and sort it.
;; *
;; * @param min The lower bound (inclusive) for the random n.
;; * @param max The upper bound (exclusive) for the random n.
;; * @param ls;;The list to fill with random integers n.
;; */
;;public static void fillList(int min, int max, List<Integer> ls) {
;;;;for (int i = 0; i < max; i++)
;;;;;;ls.add(randomInteger(min, max));
;;;;Collections.sort(ls);
;;}

;;/**
;; * @param min The lower bound (inclusive) for the random n.
;; * @param max The upper bound (exclusive) for the random n.
;; * @return A random integer n between min and max.
;; */
;;public static int randomInteger(int min, int max) {
;;;;return min + (int) (Math.random() * (max - min));
;;}
}
