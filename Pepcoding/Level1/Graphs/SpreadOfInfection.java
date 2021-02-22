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
6
3

Sample Output
4

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
  int time;

  public Pair(int vertex, int time) {
    this.vertex = vertex;
    this.time = time;
  }
}

public class Main {

  public static int findSpreadOfInfection(ArrayList<Edge>[] graph, int source, int time) {
    int noOfPersons = graph.length;

    if (noOfPersons == 0) {
      return 0;
    }

    int infected[] = new int[noOfPersons];
    Arrays.fill(infected, -1);
    // -1 signifies that the corresponding person (vertex) is not infected (visited)
    // infected[] will also store the 'time' when the person is infected (i.e. corresponding vertex is visited)

    return countInfectedPersonsBFS(graph, source, time, infected);
  }

  private static int countInfectedPersonsBFS(ArrayList<Edge>[] graph, int source, int time, int[] infected) {
    Queue<Pair> queue = new LinkedList<>();
    queue.add(new Pair(source, 1)); // taking initial time to be 1 unit

    int noOfInfectedPersons = 0;

    while (!queue.isEmpty()) {
      Pair pair = queue.poll();
      int currentPerson = pair.vertex;
      int personInfectedAtTime = pair.time;

      if (infected[currentPerson] == -1) { // not infected/visited
        if (personInfectedAtTime > time) {
          return noOfInfectedPersons;
        }

        infected[currentPerson] = personInfectedAtTime;
        noOfInfectedPersons++;

        for (Edge edge : graph[currentPerson]) {
          if (infected[edge.neighbour] == -1) {
            queue.add(new Pair(edge.neighbour, personInfectedAtTime + 1));
          }
        }
      }
    }

    return noOfInfectedPersons;
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

    int source = s.nextInt();
    int time = s.nextInt();

    int result = findSpreadOfInfection(graph, source, time);
    System.out.println(result);
  }

}
