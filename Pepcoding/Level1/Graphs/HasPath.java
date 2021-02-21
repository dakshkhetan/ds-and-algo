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
true

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

  public static boolean hasPath(ArrayList<Edge>[] graph, int source, int destination) {
    boolean[] visited = new boolean[graph.length];
    return hasPathHelper(graph, source, destination, visited);
  }

  private static boolean hasPathHelper(ArrayList<Edge>[] graph, int source, int destination, boolean[] visited) {
    if (source == destination) {
      return true;
    }

    visited[source] = true;

    for (Edge edge : graph[source]) {
      if (!visited[edge.neighbour]) {
        boolean hasPathNeighbour = hasPathHelper(graph, edge.neighbour, destination, visited);
        if (hasPathNeighbour) {
          return true;
        }
      }
    }

    return false;
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

    boolean result = hasPath(graph, source, destination);
    System.out.println(result);
  }

}
