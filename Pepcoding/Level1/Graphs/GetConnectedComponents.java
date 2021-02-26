/*

Sample Input
7
5
0 1 10
2 3 10
4 5 10
5 6 10
4 6 10

Sample Output
[[0, 1], [2, 3], [4, 5, 6]]

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

  public static ArrayList<ArrayList<Integer>> getConnectedComponents(ArrayList<Edge>[] graph) {
    int noOfVertices = graph.length;
    boolean visited[] = new boolean[noOfVertices];

    ArrayList<ArrayList<Integer>> components = new ArrayList<>();

    for (int vertex = 0; vertex < noOfVertices; vertex++) {
      if (!visited[vertex]) {
        ArrayList<Integer> component = new ArrayList<>();
        addVerticesToComponent(graph, visited, vertex, component);

        components.add(component);
      }
    }

    return components;
  }

  // add all the connected vertices from 'startVertex' into 'component' ArrayList
  private static void addVerticesToComponent(ArrayList<Edge>[] graph, boolean[] visited, int startVertex,
      ArrayList<Integer> component) {
    visited[startVertex] = true;
    component.add(startVertex);

    for (Edge edge : graph[startVertex]) {
      if (!visited[edge.neighbour]) {
        addVerticesToComponent(graph, visited, edge.neighbour, component);
      }
    }
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

    ArrayList<ArrayList<Integer>> result = getConnectedComponents(graph);
    System.out.println(result);
  }

}
