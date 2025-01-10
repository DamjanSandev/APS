package Kolokvium.K2.Grafovi_Algoritmi.KruskalPrim;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Lab_10_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        AdjacencyMatrixGraph<String> graph = new AdjacencyMatrixGraph<>(n);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.addVertex(i, sc.nextLine());
            map.put(graph.getVertex(i), i);
        }
        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            graph.addEdge(map.get(parts[0]), map.get(parts[1]), Integer.parseInt(parts[2]));
        }
        List<Edge> kruskal = graph.kruskal();
        int sum = 0;
        for (Edge edge : kruskal) {
            sum += edge.getWeight();
        }
        System.out.println(sum);
    }
}
