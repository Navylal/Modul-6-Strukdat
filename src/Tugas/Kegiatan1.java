package Tugas;

public class Kegiatan1 {
    private final int V = 10;
    private final String[] nodes = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    private final int[][] adjacencyMatrix = new int[V][V];
    private final int[] inDegree = new int[V];
    private final int[] outDegree = new int[V];

    public void addEdge(int u, int v) {
        if (adjacencyMatrix[u][v] == 0) {
            adjacencyMatrix[u][v] = 1;
            outDegree[u]++;
            inDegree[v]++;
        }
    }

    public void printAdjacencyMatrix() {
        System.out.println("\nAdjacency Matrix:");
        System.out.print("    ");
        for (String label : nodes) {
            System.out.print(label + " ");
        }
        System.out.println();
        for (int i = 0; i < V; i++) {
            System.out.print(nodes[i] + " | ");
            for (int j = 0; j < V; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printDegrees() {
        System.out.println("\nTabel In-Degree dan Out-Degree:");
        System.out.printf("%-5s %-10s %-10s%n", "Node", "In-Degree", "Out-Degree");
        for (int i = 0; i < V; i++) {
            System.out.printf("%-5s %-10d %-10d%n", nodes[i], inDegree[i], outDegree[i]);
        }
    }

    // Main method
    public static void main(String[] args) {
        Kegiatan1 graph = new Kegiatan1();

        graph.addEdge(0, 1);  // A → B
        graph.addEdge(0, 2);  // A → C
        graph.addEdge(1, 3);  // B → D
        graph.addEdge(2, 3);  // C → D
        graph.addEdge(2, 4);  // C → E
        graph.addEdge(3, 5);  // D → F
        graph.addEdge(4, 5);  // E → F
        graph.addEdge(5, 6);  // F → G
        graph.addEdge(6, 7);  // G → H
        graph.addEdge(7, 8);  // H → I
        graph.addEdge(8, 9);  // I → J
        graph.addEdge(9, 0);  // J → A

        // Cetak hasil
        graph.printDegrees();
        graph.printAdjacencyMatrix();
    }
}
