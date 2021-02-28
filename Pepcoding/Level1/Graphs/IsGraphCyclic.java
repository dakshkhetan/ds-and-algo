/*

Sample Input
7
5
0 1 10
2 3 10
4 5 10
5 6 10
6 4 10

Sample Output
false

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

  public static boolean isGraphCyclic(ArrayList<Edge>[] graph) {
    int noOfVertices = graph.length;

    if (noOfVertices == 0) {
      return true;
    }

    boolean visited[] = new boolean[noOfVertices];

    // we need to iterate & check each vertex since the graph may also be disconnected
    for (int vertex = 0; vertex < noOfVertices; vertex++) {
      if (!visited[vertex]) {
        // now, check if this 'vertex' is present in a cycle

        // boolean isCyclePresent = traverseAndCheckForCycleBFS(graph, vertex, visited);
        boolean isCyclePresent = traverseAndCheckForCycleDFS(graph, vertex, vertex, visited);

        if (isCyclePresent) {
          return true;
        }
      }
    }

    return false;
  }

  private static boolean traverseAndCheckForCycleBFS(ArrayList<Edge>[] graph, int startVertex, boolean[] visited) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(startVertex);

    while (!queue.isEmpty()) {
      int vertex = queue.poll();

      if (!visited[vertex]) {
        visited[vertex] = true;

        for (Edge edge : graph[vertex]) {
          if (!visited[edge.neighbour]) {
            queue.add(edge.neighbour);
          }
        }
      } else {
        // 'vertex' has already been visited (through some other path)
        // hence, a cycle is present
        return true;
      }
    }

    return false;
  }

  private static boolean traverseAndCheckForCycleDFS(ArrayList<Edge>[] graph, int vertex, int parentVertex,
      boolean[] visited) {
    // 'parentVertex' -> 'vertex' of previous/last recursive call

    visited[vertex] = true;

    for (Edge edge : graph[vertex]) {
      if (!visited[edge.neighbour]) {
        boolean isCyclePresent = traverseAndCheckForCycleDFS(graph, edge.neighbour, vertex, visited);
        if (isCyclePresent) {
          return true;
        }
      } else if (edge.neighbour != parentVertex) {
        // the vertex 'edge.neighbour' has already been visited (through some other path)
        // and, it is not the vertex of previous/last recursive call, then
        // this signifies, a cycle is present
        return true;
      }
    }

    return false;
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

    boolean result = isGraphCyclic(graph);
    System.out.println(result);
  }

}
