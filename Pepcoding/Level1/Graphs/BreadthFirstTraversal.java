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
1@21
3@23
0@210
4@234
5@2345
6@2346

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

  public static void breadthFirstTraversal(ArrayList<Edge>[] graph, int source) {
    int noOfVertices = graph.length;

    if (noOfVertices == 0) {
      return;
    }

    boolean visited[] = new boolean[noOfVertices];
    BFS(graph, source, visited);
  }

  private static void BFS(ArrayList<Edge>[] graph, int source, boolean[] visited) {
    Queue<Pair> queue = new LinkedList<>();
    queue.add(new Pair(source, source + ""));

    while (!queue.isEmpty()) {
      Pair pair = queue.poll();

      if (!visited[pair.vertex]) {
        visited[pair.vertex] = true;

        System.out.println(pair.vertex + "@" + pair.pathSoFar);

        for (Edge edge : graph[pair.vertex]) {
          if (!visited[edge.neighbour]) {
            queue.add(new Pair(edge.neighbour, pair.pathSoFar + edge.neighbour));
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

    breadthFirstTraversal(graph, sourceVertex);
  }

}
