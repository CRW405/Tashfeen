
public class Graph {
  public static void main(String[] args) {
    System.out.println("Dijkstra on dijkstra1.txt");
    int[][] dijkstra = readWeights("./dijkstra1.txt");
    Vertex[] dijkstraVertices = new Vertex[dijkstra.length];
    runDijkstra(dijkstraVertices, dijkstra, 0);

    System.out.println("Dijkstra on dijkstra2.txt");
    int[][] dijkstra2 = readWeights("./dijkstra2.txt");
    Vertex[] dijkstra2Vertices = new Vertex[dijkstra2.length];
    runDijkstra(dijkstra2Vertices, dijkstra2, 0);

    System.out.println("Bellman-Ford on bellmanford1.txt");
    int[][] bellmanFord = readWeights("./bellmanford1.txt");
    Vertex[] bellmanFordVertices = new Vertex[bellmanFord.length];
    runBellmanFord(bellmanFordVertices, bellmanFord, 0);

    System.out.println("Bellman-Ford on bellmanford2.txt");
    int[][] bellmanFord2 = readWeights("./bellmanford2.txt");
    Vertex[] bellmanFord2Vertices = new Vertex[bellmanFord2.length];
    runBellmanFord(bellmanFord2Vertices, bellmanFord2, 0);

    System.out.println("Dijkstra on bellmanford1.txt");
    runDijkstra(bellmanFordVertices, bellmanFord, 0);

    System.out.println("Dijkstra on bellmanford2.txt");
    runDijkstra(bellmanFord2Vertices, bellmanFord2, 0);

    System.out.println("Bellman-Ford on dijkstra1.txt");
    runBellmanFord(dijkstraVertices, dijkstra, 0);

    System.out.println("Bellman-Ford on dijkstra2.txt");
    runBellmanFord(dijkstra2Vertices, dijkstra2, 0);
  }

  public static void runDijkstra(Vertex[] vertices, int[][] adjacencyMatrix, int sourceIndex) {
    initializeVertices(vertices, sourceIndex);
    Vertex current;
    while ((current = extractMin(vertices)) != null) {
      for (int j = 0; j < adjacencyMatrix[current.i].length; j++) {
        if (adjacencyMatrix[current.i][j] != 0) {
          relax(current, vertices[j], adjacencyMatrix);
        }
      }
    }
    printResults(vertices);
  }

  public static void runBellmanFord(Vertex[] vertices, int[][] adjacencyMatrix, int sourceIndex) {
    initializeVertices(vertices, sourceIndex);
    int V = vertices.length;

    for (int i = 1; i <= V - 1; i++) {
      for (int u = 0; u < adjacencyMatrix.length; u++) {
        for (int v = 0; v < adjacencyMatrix[u].length; v++) {
          if (adjacencyMatrix[u][v] != 0) {
            relax(vertices[u], vertices[v], adjacencyMatrix);
          }
        }
      }
    }
    printResults(vertices);
  }

  public static void relax(Vertex u, Vertex v, int[][] adjacencyMatrix) {
    if (v.distance > u.distance + adjacencyMatrix[u.i][v.i]) {
      v.distance = u.distance + adjacencyMatrix[u.i][v.i];
      v.predecessor = u.label();
    }
  }

  public static Vertex extractMin(Vertex[] vertices) {
    Vertex minVertex = null;
    for (Vertex v : vertices) {
      if (v.visited)
        continue;
      if (minVertex == null || minVertex.distance > v.distance) {
        minVertex = v;
      }
    }
    if (minVertex != null)
      minVertex.visited = true;
    return minVertex;
  }

  public static void initializeVertices(Vertex[] vertices, int sourceIndex) {
    for (int i = 0; i < vertices.length; i++) {
      vertices[i] = new Vertex(i);
    }
    vertices[sourceIndex].distance = 0;
  }

  public static int[][] readWeights(String path) {
    String contents = Frequency.read(path);
    String[] rows = contents.split("\n");
    int[][] matrix = new int[rows.length][rows[0].split(",").length];
    for (int i = 0; i < matrix.length; i++) {
      String[] row = rows[i].split(",");
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = Integer.parseInt(row[j]);
      }
    }
    return matrix;
  }

  public static void printResults(Vertex[] vertices) {
    for (Vertex v : vertices) {
      if (v.distance == Double.POSITIVE_INFINITY) {
        System.out.println(v.label() + ": infinity");
      } else {
        System.out.println(v.label() + ": " + (int) v.distance + " via " + v.predecessor);
      }
    }
    System.out.println();
  }

  static class Vertex implements Comparable<Vertex> {
    public boolean visited = false;
    public int i = -1;
    public double distance = Double.POSITIVE_INFINITY;
    public char predecessor = 0;

    public Vertex(int i) {
      this.i = i;
      this.predecessor = this.label();
    }

    public int compareTo(Vertex other) {
      return Double.compare(this.distance, other.distance);
    }

    public char label() {
      return (char) (this.i + 'a');
    }
  }
}
