/*

Sample Input
7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
0
6

Sample Output
0123456
012346
03456
0346

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

public class Main {

  public static void printAllPaths(ArrayList<Edge>[] graph, int source, int destination) {
    boolean[] visited = new boolean[graph.length];
    printAllPathsHelper(graph, source, destination, visited, "");
  }

  private static void printAllPathsHelper(ArrayList<Edge>[] graph, int source, int destination, boolean[] visited,
      String path) {
    if (source == destination) {
      System.out.println(path + source);
      return;
    }

    visited[source] = true;

    for (Edge edge : graph[source]) {
      if (!visited[edge.neighbour]) {
        printAllPathsHelper(graph, edge.neighbour, destination, visited, path + source);
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

    printAllPaths(graph, source, destination);
  }

}
