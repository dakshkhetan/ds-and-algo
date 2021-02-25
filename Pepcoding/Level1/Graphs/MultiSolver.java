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
4

Sample Output
Smallest Path = 01256@28
Largest Path = 032546@66
Just Larger Path than 30 = 012546@36
Just Smaller Path than 30 = 01256@28
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

  static String smallestPath = "";
  static String largestPath = "";
  static String ceilPath = "";
  static String floorPath = "";

  static int smallestPathWeight = Integer.MAX_VALUE;
  static int largestPathWeight = Integer.MIN_VALUE;
  static int ceilPathWeight = Integer.MAX_VALUE;
  static int floorPathWeight = Integer.MIN_VALUE;

  static PriorityQueue<Pair> pq = new PriorityQueue<>(); // min-heap

  public static void multiSolver(ArrayList<Edge>[] graph, int source, int destination, int target, int k) {
    boolean[] visited = new boolean[graph.length];
    multiSolverHelper(graph, source, destination, target, k, visited, "", 0);

    System.out.println("Smallest Path = " + smallestPath + "@" + smallestPathWeight);
    System.out.println("Largest Path = " + largestPath + "@" + largestPathWeight);
    System.out.println("Just Larger Path than " + target + " = " + ceilPath + "@" + ceilPathWeight);
    System.out.println("Just Smaller Path than " + target + " = " + floorPath + "@" + floorPathWeight);
    System.out.println(k + "th largest path = " + pq.peek().pathSoFar + "@" + pq.peek().weightSoFar);
  }

  private static void multiSolverHelper(ArrayList<Edge>[] graph, int source, int destination, int targetWeight, int k,
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

      if (weightSoFar > targetWeight && weightSoFar < ceilPathWeight) {
        ceilPathWeight = weightSoFar;
        ceilPath = pathSoFar;
      }

      if (weightSoFar < targetWeight && weightSoFar > floorPathWeight) {
        floorPathWeight = weightSoFar;
        floorPath = pathSoFar;
      }

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
        multiSolverHelper(graph, edge.neighbour, destination, targetWeight, k, visited, pathSoFar + source,
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
    int k = s.nextInt();

    // 1. Smallest Path from source to destination vertex.
    // 2. Largest Path from source to destination vertex.
    // 3. Ceil (just larger) Weighted Path than a target weight.
    // 4. Floor (just smaller) Weighted Path than a target weight.
    // 5. k'th Largest Path from source to destination vertex.

    multiSolver(graph, source, destination, target, k);
  }

}
