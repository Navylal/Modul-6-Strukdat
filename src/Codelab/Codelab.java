package Codelab;

import java.util.*;

public class Codelab {
    private Map<String, List<String>> graph;

    public Codelab() {
        graph = new HashMap<>();
    }

    public void addWarehouse(String warehouse) {
        graph.putIfAbsent(warehouse, new ArrayList<>());
    }

    public void addRoute(String from, String to) {
        graph.get(from).add(to);
    }

    public void bfsShortestPaths(String start) {
        Queue<List<String>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(Arrays.asList(start));

        System.out.println("Jalur terdekat dari " + start + ":");

        while (!queue.isEmpty()) {
            List<String> path = queue.poll();
            String current = path.get(path.size() - 1);

            if (!visited.contains(current)) {
                visited.add(current);

                // Print jalur
                System.out.println(start + " -> " + current + ": " + String.join(" -> ", path));

                for (String neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        List<String> newPath = new ArrayList<>(path);
                        newPath.add(neighbor);
                        queue.offer(newPath);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Codelab lg = new Codelab();

        lg.addWarehouse("A");
        lg.addWarehouse("B");
        lg.addWarehouse("C");
        lg.addWarehouse("D");
        lg.addWarehouse("E");

        lg.addRoute("A", "B");
        lg.addRoute("A", "C");
        lg.addRoute("B", "D");
        lg.addRoute("C", "D");
        lg.addRoute("C", "E");
        lg.addRoute("D", "E");

        lg.bfsShortestPaths("A");
    }
}
