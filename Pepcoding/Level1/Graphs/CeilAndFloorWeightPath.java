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
30

Sample Output
Just Larger Path than 30 = 012546@36
Just Smaller Path than 30 = 01256@28

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

  static String ceilPath = "";
  static String floorPath = "";

  static int ceilPathWeight = Integer.MAX_VALUE;
  static int floorPathWeight = Integer.MIN_VALUE;

  public static void ceilAndFloorWeightPath(ArrayList<Edge>[] graph, int source, int destination, int target) {
    boolean[] visited = new boolean[graph.length];
    // ceil -> smallest amongst largest
    // floor -> largest amongst smallest

    ceilAndFloorWeightPathHelper(graph, source, destination, target, visited, "", 0);
  }

  private static void ceilAndFloorWeightPathHelper(ArrayList<Edge>[] graph, int source, int destination,
      int targetWeight, boolean[] visited, String pathSoFar, int weightSoFar) {
    if (source == destination) {
      pathSoFar += source;

      if (weightSoFar > targetWeight && weightSoFar < ceilPathWeight) {
        ceilPathWeight = weightSoFar;
        ceilPath = pathSoFar;
      }

      if (weightSoFar < targetWeight && weightSoFar > floorPathWeight) {
        floorPathWeight = weightSoFar;
        floorPath = pathSoFar;
      }

      return;
    }

    visited[source] = true;

    for (Edge edge : graph[source]) {
      if (!visited[edge.neighbour]) {
        ceilAndFloorWeightPathHelper(graph, edge.neighbour, destination, targetWeight, visited, pathSoFar + source,
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
    int target = s.nextInt();

    ceilAndFloorWeightPath(graph, source, destination, target);

    System.out.println("Just Larger Path than " + target + " = " + ceilPath + "@" + ceilPathWeight);
    System.out.println("Just Smaller Path than " + target + " = " + floorPath + "@" + floorPathWeight);
  }

}
