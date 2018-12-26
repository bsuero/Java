import java.io.*;
import java.util.*;

/*
 *  Shortest Distance Program
 *    - Uses Dijkstra's Algorithm
 */
public class ShortestDistanceProgram { 
  
  // Variable to store vertices of graph
  private static ArrayList<String> vertices;
  // Variable to store adjacency matrix
  private static int[][] adjacency_matrix;
  
  // Main method for program execution
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    // Get filename from user
    while (true) {
      System.out.println("Enter filename containing distances:");
      String filename = s.nextLine();
      try {
        loadFile(filename);
        break;
      } catch (IOException e) {
        System.out.println("Error: Invalid file. Please try again.");
      }
    }
    // Print locations
    System.out.println("Locations: " + vertices);
    // Get start location from user
    String startVertex = "";
    while (true) {
      System.out.println("Enter start location:");
      startVertex = s.nextLine();
      if (vertices.contains(startVertex)) {
        break;
      } else {
        System.out.println("Error: Invalid location. Please try again.");
      }
    }
    // Get end location from user
    String endVertex = "";
    while (true) {
      System.out.println("Enter end location:");
      endVertex = s.nextLine();
      if (vertices.contains(endVertex) && !startVertex.equals(endVertex)) {
        break;
      } else if (startVertex.equals(endVertex)) {
        System.out.println("Error: Start and end locations can't be the same. Please try again.");
      } else {
        System.out.println("Error: Invalid location. Please try again.");
      }
    }
    int start = vertices.indexOf(startVertex);
    int end = vertices.indexOf(endVertex);
    // Apply Dijkstra's Algortihm
    DijkstrasAlgorithm(start, end);
  } 
  
  // Helper method to load vertices and adjacency matrix from file
  public static void loadFile(String filename) throws IOException {
    vertices = new ArrayList<String>();
    try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
      for(String line; (line = br.readLine()) != null; ) {
        String[] params = line.trim().split("\\s+");
        if (params.length == 3) {
          if (!vertices.contains(params[0]))
            vertices.add(params[0]);
          if (!vertices.contains(params[1]))
            vertices.add(params[1]);
        }
      }
    }
    adjacency_matrix = new int[vertices.size()][vertices.size()];
    try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
      for(String line; (line = br.readLine()) != null; ) {
        String[] params = line.trim().split("\\s+");
        if (params.length == 3) {
          adjacency_matrix[vertices.indexOf(params[0])][vertices.indexOf(params[1])] = Integer.parseInt(params[2]);
          adjacency_matrix[vertices.indexOf(params[1])][vertices.indexOf(params[0])] = Integer.parseInt(params[2]);
        }
      }
    }
  }
  
  /*
   *  Dijkstra's Algorithm implementation
   */
  public static void DijkstrasAlgorithm(int start, int end) {
    int size = vertices.size();
    // dist array keeps track of distances
    int[] dist = new int[size];
    boolean[] visited = new boolean[size]; 
    // Initialize arrays
    for (int v = 0; v < size; v++) {
      dist[v] = Integer.MAX_VALUE; 
      visited[v] = false; 
    }
    dist[start] = 0; 
    // Prev array keeps track of previous vertices
    int[] prev = new int[size]; 
    prev[start] = -1;
    // Iteratively identify the vertex with minimum distance
    for (int i = 1; i < size; i++) {
      int minV = -1; 
      int minDist = Integer.MAX_VALUE; 
      for (int v = 0; v < size; v++) {
        if (!visited[v] && dist[v] < minDist) {
          minV = v; 
          minDist = dist[v]; 
        } 
      }
      visited[minV] = true; 
      // Update the distance to each vertex
      for (int v = 0; v < size; v++) {
        int edgeDist = adjacency_matrix[minV][v]; 
        if (edgeDist > 0 && ((minDist + edgeDist) < dist[v])) {
          prev[v] = minV; 
          dist[v] = minDist + edgeDist; 
        } 
      } 
    }
    // Print the shortest distance from start to end
    System.out.println("The total distance from " + vertices.get(start) + " to " + vertices.get(end) + " is: " + dist[end]);
    // Construct path
    ArrayList<String> path = new ArrayList<String>();
    int v = end; 
    while (v != -1) {
      path.add(0, vertices.get(v));
      v = prev[v];
    }
    // Print path
    System.out.println("Path: " + path);
  }
} 