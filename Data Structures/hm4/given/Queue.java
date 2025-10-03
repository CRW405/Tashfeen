public class Queue<T extends Comparable<T>> extends Structure<T> {
  public T pop() {
    Node<T> ret = this.head.next;
    this.head = this.head.next;
    this.head.before.next = null;
    return ret.x;
  }

}
