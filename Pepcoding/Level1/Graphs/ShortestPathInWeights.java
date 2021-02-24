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

Sample Output
0 via 0 @ 0
1 via 01 @ 10
2 via 012 @ 20
5 via 0125 @ 25
4 via 01254 @ 28
6 via 01256 @ 28
3 via 012543 @ 30

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
  int vertex;
  String pathSoFar;
  int weightSoFar;

  public Pair(int vertex, String pathSoFar, int weightSoFar) {
    this.vertex = vertex;
    this.pathSoFar = pathSoFar;
    this.weightSoFar = weightSoFar;
  }

  public int compareTo(Pair other) {
    return this.weightSoFar - other.weightSoFar;
  }
}

public class Main {

  public static void printShortestPathInWeights(ArrayList<Edge>[] graph, int source) {
    int noOfVertices = graph.length;

    if (noOfVertices == 0) {
      return;
    }

    boolean visited[] = new boolean[noOfVertices];
    dijkstraAlgorithm(graph, source, visited);
  }

  private static void dijkstraAlgorithm(ArrayList<Edge>[] graph, int source, boolean[] visited) {
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.add(new Pair(source, source + "", 0));

    while (!pq.isEmpty()) {
      Pair min = pq.poll();
      int vertex = min.vertex;
      String pathSoFar = min.pathSoFar;
      int weightSoFar = min.weightSoFar;

      if (!visited[vertex]) {
        visited[vertex] = true;
        System.out.println(vertex + " via " + pathSoFar + " @ " + weightSoFar);

        for (Edge edge : graph[vertex]) {
          if (!visited[edge.neighbour]) {
            pq.add(new Pair(edge.neighbour, pathSoFar + edge.neighbour, weightSoFar + edge.weight));
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int noOfVertices = s.nextInt();
    int noOfEdges = s.nextInt();

    @SuppressWarnings("unchecked") // ignore unchecked warnings
    ArrayList<Edge> graph[] = new ArrayList[noOfVertices]; // this will give a type-safety warning

    for (int i = 0; i < noOfVertices; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < noOfEdges; i++) {
      int source = s.nextInt();
      int destination = s.nextInt();
      int weight = s.nextInt();

      graph[source].add(new Edge(source, destination, weight));
      graph[destination].add(new Edge(destination, source, weight));
    }

    int source = s.nextInt();

    printShortestPathInWeights(graph, source); // dijkstra algorithm
  }

}
