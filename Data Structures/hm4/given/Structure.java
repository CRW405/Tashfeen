public abstract class Structure<T extends Comparable<T>> {
  public Node<T> head;
  public Node<T> tail;

  public Structure() {
    this.head = new Node<T>(null);
    this.tail = this.head;
  }

  public abstract T pop();

  public void push(T x) {
    this.tail.next = new Node<T>(x);
    this.tail.next.before = this.tail;
    this.tail = this.tail.next;
  }

  public boolean isEmpty() {
    return this.head.next == null;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    while (!this.isEmpty())
      sb.append(this.pop() + ", ");
    sb.setLength(sb.length() - 2);
    sb.append("]");
    return sb.toString();
  }
}