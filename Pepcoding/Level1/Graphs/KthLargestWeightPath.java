/*

Sample Input
7
9
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8
2 5 5
0
6
4

Sample Output
4th largest path = 03456@48

*/

import java.util.*;

class Edge {
  int source;
  int neighbour;
  int weight;

  public Edge(int source, int neighbour, int weight) {
    this.source = source;
    this.neighbour = neighbour;
    this.weight = weight;
  }
}

class Pair implements Comparable<Pair> {
  String pathSoFar;
  int weightSoFar;

  public Pair(String pathSoFar, int weightSoFar) {
    this.pathSoFar = pathSoFar;
    this.weightSoFar = weightSoFar;
  }

  public int compareTo(Pair other) {
    return this.weightSoFar - other.weightSoFar;
  }
}

public class Main {

  static PriorityQueue<Pair> pq = new PriorityQueue<>(); // min-heap

  public static void kthLargestWeightPath(ArrayList<Edge>[] graph, int source, int destination, int k) {
    boolean[] visited = new boolean[graph.length];
    kthLargestWeightPathHelper(graph, source, destination, k, visited, "", 0);
  }

  private static void kthLargestWeightPathHelper(ArrayList<Edge>[] graph, int source, int destination, int k,
      boolean[] visited, String pathSoFar, int weightSoFar) {
    if (source == destination) {
      pathSoFar += source;

      if (pq.size() < k) {
        pq.add(new Pair(pathSoFar, weightSoFar));
      } else {
        Pair min = pq.peek();
        if (weightSoFar > min.weightSoFar) {
          pq.poll();
          pq.add(new Pair(pathSoFar, weightSoFar));
        }
      }

      return;
    }

    visited[source] = true;

    for (Edge edge : graph[source]) {
      if (!visited[edge.neighbour]) {
        kthLargestWeightPathHelper(graph, edge.neighbour, destination, k, visited, pathSoFar + source,
            weightSoFar + edge.weight);
      }
    }

    visited[source] = false;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int vertices = s.nextInt();
    int edges = s.nextInt();

    @SuppressWarnings("unchecked") // ignore unchecked warnings
    ArrayList<Edge> graph[] = new ArrayList[vertices]; // this will give a type-safety warning

    for (int i = 0; i < vertices; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < edges; i++) {
      int source = s.nextInt();
      int destination = s.nextInt();
      int weight = s.nextInt();

      graph[source].add(new Edge(source, destination, weight));
      graph[destination].add(new Edge(destination, source, weight));
    }

    int source = s.nextInt();
    int destination = s.nextInt();
    int k = s.nextInt();

    kthLargestWeightPath(graph, source, destination, k);

    System.out.println(k + "th largest path = " + pq.peek().pathSoFar + "@" + pq.peek().weightSoFar);
  }

}
