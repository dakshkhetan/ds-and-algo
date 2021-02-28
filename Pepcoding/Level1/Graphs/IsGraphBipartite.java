/*

Reference Video -> https://youtu.be/ZBhZ1DXGrhA

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

class Pair {
  int vertex;
  int level;

  public Pair(int vertex, int level) {
    this.vertex = vertex;
    this.level = level;
  }
}

public class Main {

  public static boolean isGraphBipartite(ArrayList<Edge>[] graph) {
    int noOfVertices = graph.length;

    if (noOfVertices == 0) {
      return true;
    }

    int visited[] = new int[noOfVertices];
    Arrays.fill(visited, -1);
    // -1 signifies that the corresponding vertex is not visited
    // visited[] will also store the 'level' of corresponding vertex

    // we need to iterate & check each vertex since the graph may also be disconnected
    for (int vertex = 0; vertex < noOfVertices; vertex++) {
      if (visited[vertex] == -1) { // not visited
        boolean isBipartite = traverseAndCheckForBipartitenessBFS(graph, vertex, visited);
        // boolean isBipartite = traverseAndCheckForBipartitenessDFS(graph, vertex, vertex, 0, visited);

        if (!isBipartite) {
          return false;
        }
      }
    }

    return true;
  }

  private static boolean traverseAndCheckForBipartitenessBFS(ArrayList<Edge>[] graph, int startVertex, int[] visited) {
    Queue<Pair> queue = new LinkedList<>();
    queue.add(new Pair(startVertex, 0)); // taking initial level as 0

    while (!queue.isEmpty()) {
      Pair pair = queue.poll();
      int currentVertex = pair.vertex;
      int currentVertexLevel = pair.level;

      if (visited[currentVertex] == -1) { // not visited
        visited[currentVertex] = currentVertexLevel;

        for (Edge edge : graph[currentVertex]) {
          if (visited[edge.neighbour] == -1) {
            queue.add(new Pair(edge.neighbour, currentVertexLevel + 1));
          }
        }
      } else {
        // 'currentVertex' has already been visited (through some other path)
        // hence, a cycle is present

        // now, if the cycle is odd, then the graph is NOT bipartite
        // (check video for reference)

        if (currentVertexLevel != visited[currentVertex]) { // odd cycle
          return false;
        }
      }
    }

    // if no cycle is present or cycle is even
    // then the graph is bipartite
    return true;
  }

  private static boolean traverseAndCheckForBipartitenessDFS(ArrayList<Edge>[] graph, int vertex, int parentVertex,
      int vertexLevel, int[] visited) {
    // 'parentVertex' -> 'vertex' of previous/last recursive call

    int lastVertexLevel = visited[vertex];
    visited[vertex] = vertexLevel;

    for (Edge edge : graph[vertex]) {
      if (visited[edge.neighbour] == -1) {
        boolean isBipartite = traverseAndCheckForBipartitenessDFS(graph, edge.neighbour, vertex, vertexLevel + 1,
            visited);

        if (!isBipartite) {
          return false;
        }
      } else if (edge.neighbour != parentVertex) {
        // the vertex 'edge.neighbour' has already been visited (through some other path)
        // and, it is not the vertex of previous/last recursive call, then
        // this signifies, a cycle is present

        // now, if the cycle is odd, then the graph is NOT bipartite
        // (check video for reference)

        if (vertexLevel != lastVertexLevel) { // odd cycle
          return false;
        }
      }
    }

    // if no cycle is present or cycle is even
    // then the graph is bipartite
    return true;
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

    boolean result = isGraphBipartite(graph);
    System.out.println(result);
  }

}
