// https://en.wikipedia.org/wiki/Binary_heap
public class BinaryHeap<T extends Comparable<T>> {
  public static void main(String[] args) {
    BinaryHeap<Integer> q = new BinaryHeap<>();

    for (int i = 7; i > 0; i--)
      q.add(i);

    System.out.println(q);
    for (int i = 7; i > 0; i--) {
      System.out.printf("Extraction: %d, Size: %d%n", q.extract(), q.size);
      System.out.println(q);
    }
  }

  public int size;
  private Node<T> root;
  private Node<T> head;
  private Node<T> tail;

  public BinaryHeap() {
    size = 0;
  }

  public T peek() {
    return root.x;
  }

  public T extract() {
    T ret = root.x;
    root.swap(tail);
    pop();
    heapifyDown(root);
    size--;
    return ret;
  }

  public void add(T x) {
    append(x);
    heapifyUp(tail);
    size++;
  }

  public String toString() {
    return stringify(root, "", "");
  }

  private String stringify(Node<T> v, String ret, String level) {
    if (v == null)
      return ret;
    ret += level + v + "\n";
    ret = stringify(v.left, ret, level + "| ");
    ret = stringify(v.right, ret, level + "| ");
    return ret;
  }

  private void append(T x) {
    if (root == null) {
      root = new Node<T>(x);
      head = root;
      tail = root;
    } else if (head.left == null) {
      head.left = new Node<T>(x);
      head.left.parent = head;
      enqueue(head.left);
    } else if (head.right == null) {
      head.right = new Node<T>(x);
      head.right.parent = head;
      enqueue(head.right);
    } else {
      deque();
      append(x);
    }
  }

  private void heapifyUp(Node<T> v) {
    // implement me
  }

  private void heapifyDown(Node<T> v) {
    // implement me
  }

  private void enqueue(Node<T> v) {
    tail.next = v;
    tail.next.before = tail;
    tail = tail.next;
  }

  private void deque() {
    head = head.next;
  }

  private void pop() {
    if (tail.parent == null) {
      tail = head = root = null;
      return;
    }
    if (tail.parent.left == tail)
      tail.parent.left = null;
    if (tail.parent.right == tail)
      tail.parent.right = null;
    tail = tail.before;
    tail.next = null;
  }
}