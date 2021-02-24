/*

Sample Input
7
8
0 1
1 2
2 3
0 3
4 5
5 6
4 6
2 5

Sample Output
4
0
1
2
5
6
3

*/

import java.util.*;

class Edge {
  int source;
  int neighbour;

  public Edge(int source, int neighbour) {
    this.source = source;
    this.neighbour = neighbour;
  }
}

public class Main {

  public static ArrayList<Integer> orderOfCompilation(ArrayList<Edge>[] graph) {
    int noOfVertices = graph.length;

    if (noOfVertices == 0) {
      return null;
    }

    boolean visited[] = new boolean[noOfVertices];

    Stack<Integer> topologicalSortStack = new Stack<>();

    for (int vertex = 0; vertex < noOfVertices; vertex++) {
      if (!visited[vertex]) {
        topologicalSort(graph, visited, vertex, topologicalSortStack);
      }
    }

    ArrayList<Integer> result = new ArrayList<>();

    while (!topologicalSortStack.isEmpty()) {
      result.add(topologicalSortStack.pop());
    }

    return result;
  }

  private static void topologicalSort(ArrayList<Edge>[] graph, boolean[] visited, int vertex, Stack<Integer> stack) {
    // topological sort: for an directed edge (A -> B), A is present before B

    visited[vertex] = true;

    for (Edge edge : graph[vertex]) {
      if (!visited[edge.neighbour]) {
        topologicalSort(graph, visited, edge.neighbour, stack);
      }
    }

    // add vertex to topological sort (stack) in post order
    stack.push(vertex);
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

      graph[source].add(new Edge(source, destination)); // directed graph
    }

    ArrayList<Integer> result = orderOfCompilation(graph); // using topological sort

    if (result != null) {
      for (int vertex : result) {
        System.out.println(vertex);
      }
    }
  }

}
