package Codelab;

import java.util.*;

public class Codelab {

    static final int SIZE = 5;
    static String[] nodes = {"A", "B", "C", "D", "E"};
    static int[][] adjMatrix = new int[SIZE][SIZE];

    static Map<String, Integer> nodeIndex = new HashMap<>();
    static Map<Integer, String> indexNode = new HashMap<>();

    static {
        for (int i = 0; i < SIZE; i++) {
            nodeIndex.put(nodes[i], i);
            indexNode.put(i, nodes[i]);
        }
    }

    public static void main(String[] args) {
        // Tambahkan 7 jalur pengiriman (directed)
        addEdge("A", "B");
        addEdge("A", "C");
        addEdge("B", "D");
        addEdge("C", "D");
        addEdge("C", "E");
        addEdge("D", "E");
        addEdge("E", "A");

        System.out.println("Adjacency Matrix:");
        printAdjMatrix();

        System.out.println("\nBFS dari gudang A:");
        bfs("A");

        System.out.println("\nDFS dari gudang A:");
        dfs("A");
    }

    static void addEdge(String from, String to) {
        int u = nodeIndex.get(from);
        int v = nodeIndex.get(to);
        adjMatrix[u][v] = 1;
    }

    static void printAdjMatrix() {
        System.out.print("  ");
        for (String n : nodes) {
            System.out.print(n + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print(nodes[i] + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void bfs(String start) {
        boolean[] visited = new boolean[SIZE];
        Queue<Integer> queue = new LinkedList<>();

        int startIndex = nodeIndex.get(start);
        visited[startIndex] = true;
        queue.add(startIndex);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(indexNode.get(node) + " ");

            for (int i = 0; i < SIZE; i++) {
                if (adjMatrix[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        System.out.println();
    }

    static void dfs(String start) {
        boolean[] visited = new boolean[SIZE];
        dfsUtil(nodeIndex.get(start), visited);
        System.out.println();
    }

    static void dfsUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(indexNode.get(node) + " ");

        for (int i = 0; i < SIZE; i++) {
            if (adjMatrix[node][i] == 1 && !visited[i]) {
                dfsUtil(i, visited);
            }
        }
    }
}