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

Sample Output
Smallest Path = 01256@28
Largest Path = 032546@66

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

  static String smallestPath = "";
  static String largestPath = "";

  static int smallestPathWeight = Integer.MAX_VALUE;
  static int largestPathWeight = Integer.MIN_VALUE;

  public static void smallestAndLargestWeightPath(ArrayList<Edge>[] graph, int source, int destination) {
    boolean[] visited = new boolean[graph.length];
    smallestAndLargestWeightPathHelper(graph, source, destination, visited, "", 0);
  }

  private static void smallestAndLargestWeightPathHelper(ArrayList<Edge>[] graph, int source, int destination,
      boolean[] visited, String pathSoFar, int weightSoFar) {
    if (source == destination) {
      pathSoFar += source;

      if (weightSoFar > largestPathWeight) {
        largestPathWeight = weightSoFar;
        largestPath = pathSoFar;
      }

      if (weightSoFar < smallestPathWeight) {
        smallestPathWeight = weightSoFar;
        smallestPath = pathSoFar;
      }

      return;
    }

    visited[source] = true;

    for (Edge edge : graph[source]) {
      if (!visited[edge.neighbour]) {
        smallestAndLargestWeightPathHelper(graph, edge.neighbour, destination, visited, pathSoFar + source,
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

    smallestAndLargestWeightPath(graph, source, destination);

    System.out.println("Smallest Path = " + smallestPath + "@" + smallestPathWeight);
    System.out.println("Largest Path = " + largestPath + "@" + largestPathWeight);
  }

}
