/*

Sample Input
7
5
0 1
2 3
4 5
5 6
4 6

Sample Output
16

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

  public static int numberOfPerfectFriends(ArrayList<Edge>[] graph) {
    ArrayList<ArrayList<Integer>> components = getConnectedComponents(graph);

    int noOfConnectedComponents = components.size();
    int totalNoOfPairs = 0;

    for (int i = 0; i < noOfConnectedComponents; i++) {
      for (int j = i + 1; j < noOfConnectedComponents; j++) { // j = i+1 to prevent duplicate pairs count
        int firstComponentSize = components.get(i).size();
        int secondComponentSize = components.get(j).size();
        int noOfPossiblePairs = firstComponentSize * secondComponentSize;

        totalNoOfPairs += noOfPossiblePairs;
      }
    }

    return totalNoOfPairs;
  }

  private static ArrayList<ArrayList<Integer>> getConnectedComponents(ArrayList<Edge>[] graph) {
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

      graph[source].add(new Edge(source, destination));
      graph[destination].add(new Edge(destination, source));
    }

    int result = numberOfPerfectFriends(graph);
    System.out.println(result);
  }

}
