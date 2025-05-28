package Tugas;

import java.util.*;

public class Kegiatan2 {
    private final int V = 8;
    private final String[] kota = {"A", "B", "C", "D", "E", "F", "G", "H"};
    private int[][] adjacencyMatrix = new int[V][V];

    public void addEdge(int u, int v) {
        adjacencyMatrix[u][v] = 1;
    }

    public void printAdjacencyMatrix() {
        System.out.println("Adjacency Matrix:");
        System.out.print("   ");
        for (String k : kota) {
            System.out.print(k + " ");
        }
        System.out.println();
        for (int i = 0; i < V; i++) {
            System.out.print(kota[i] + ": ");
            for (int j = 0; j < V; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public List<String> bfs(int start) {
        boolean[] visited = new boolean[V];
        List<String> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(kota[current]);

            for (int i = 0; i < V; i++) {
                if (adjacencyMatrix[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        return result;
    }

    public List<String> dfs(int start) {
        boolean[] visited = new boolean[V];
        List<String> result = new ArrayList<>();
        dfsHelper(start, visited, result);
        return result;
    }

    private void dfsHelper(int current, boolean[] visited, List<String> result) {
        visited[current] = true;
        result.add(kota[current]);

        for (int i = 0; i < V; i++) {
            if (adjacencyMatrix[current][i] == 1 && !visited[i]) {
                dfsHelper(i, visited, result);
            }
        }
    }

    public static void main(String[] args) {
        Kegiatan2 graph = new Kegiatan2();

        // Tambahkan 10 rute pengiriman
        graph.addEdge(0, 1); // A -> B
        graph.addEdge(0, 2); // A -> C
        graph.addEdge(1, 3); // B -> D
        graph.addEdge(2, 3); // C -> D
        graph.addEdge(2, 4); // C -> E
        graph.addEdge(3, 5); // D -> F
        graph.addEdge(4, 5); // E -> F
        graph.addEdge(5, 6); // F -> G
        graph.addEdge(6, 7); // G -> H
        graph.addEdge(7, 2); // H -> C

        graph.printAdjacencyMatrix();

        List<String> bfsTraversal = graph.bfs(0);
        System.out.println("\nBFS traversal dari kota A: " + bfsTraversal);

        List<String> dfsTraversal = graph.dfs(0);
        System.out.println("DFS traversal dari kota A: " + dfsTraversal);

    }
}
