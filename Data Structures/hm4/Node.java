// `T extends Comparable<T>` will accept anything `Comparable<T>`
public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
  public T x;

  public Node<T> next = null;
  public Node<T> before = null;

  public Node<T> parent = null;
  public Node<T> left = null;
  public Node<T> right = null;

  public Node(T x) {
    this.x = x;
  }

  public int compareTo(Node<T> other) {
    return x.compareTo(other.x);
  }

  public String toString() {
    return x.toString();
  }

  public void swap(Node<T> other) {
    T escrow = x;
    x = other.x;
    other.x = escrow;
  }
}