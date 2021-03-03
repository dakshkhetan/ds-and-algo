/*

Sample Input
7
8
0 1 10
1 2 10
2 3 10
0 3 25
3 4 2
4 5 3
5 6 3
4 6 8

Sample Output
[1-0@10]
[2-1@10]
[3-2@10]
[4-3@2]
[5-4@3]
[6-5@3]

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
  int parentVertex;
  int weight;

  public Pair(int vertex, int parentVertex, int weight) {
    this.vertex = vertex;
    this.parentVertex = parentVertex;
    this.weight = weight;
  }

  public int compareTo(Pair other) {
    return this.weight - other.weight;
  }
}

public class Main {

  public static void minimumWireRequiredToConnectPCs(ArrayList<Edge>[] graph) {
    int noOfVertices = graph.length;

    if (noOfVertices == 0) {
      return;
    }

    boolean visited[] = new boolean[noOfVertices];
    primsAlgorithm(graph, 0, visited);
  }

  private static void primsAlgorithm(ArrayList<Edge>[] graph, int source, boolean[] visited) {
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.add(new Pair(source, -1, 0)); // initially, parent = -1 and weight = 0

    while (!pq.isEmpty()) {
      Pair min = pq.poll();
      int vertex = min.vertex;
      int parentVertex = min.parentVertex;
      int weight = min.weight;

      if (!visited[vertex]) {
        visited[vertex] = true;

        if (parentVertex != -1) {
          System.out.println("[" + vertex + "-" + parentVertex + "@" + weight + "]");
        }

        for (Edge edge : graph[vertex]) {
          if (!visited[edge.neighbour]) {
            pq.add(new Pair(edge.neighbour, vertex, edge.weight));
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

    minimumWireRequiredToConnectPCs(graph); // using prim's algorithm
  }

}
