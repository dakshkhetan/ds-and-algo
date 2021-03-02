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
2

Sample Output
2@2
3@23
4@234
6@2346
5@23465
0@230
1@2301

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

class Pair {
  int vertex;
  String pathSoFar;

  public Pair(int vertex, String pathSoFar) {
    this.vertex = vertex;
    this.pathSoFar = pathSoFar;
  }
}

public class Main {

  public static void iterativeDepthFirstTraversal(ArrayList<Edge>[] graph, int source) {
    int noOfVertices = graph.length;

    if (noOfVertices == 0) {
      return;
    }

    boolean visited[] = new boolean[noOfVertices];
    iterativeDFS(graph, source, visited);
  }

  private static void iterativeDFS(ArrayList<Edge>[] graph, int source, boolean[] visited) {
    Stack<Pair> stack = new Stack<>(); // stack will generate reverse euler pattern of traversal
    stack.push(new Pair(source, source + ""));

    while (!stack.isEmpty()) {
      Pair pair = stack.pop();
      int vertex = pair.vertex;
      String pathSoFar = pair.pathSoFar;

      if (!visited[vertex]) {
        visited[vertex] = true;

        System.out.println(vertex + "@" + pathSoFar);

        for (Edge edge : graph[vertex]) {
          if (!visited[edge.neighbour]) {
            stack.push(new Pair(edge.neighbour, pathSoFar + edge.neighbour));
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

    int sourceVertex = s.nextInt();

    iterativeDepthFirstTraversal(graph, sourceVertex);
  }

}
