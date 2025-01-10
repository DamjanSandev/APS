package Kolokvium.K2.Grafovi_Algoritmi.Djikstra;


import java.util.*;

public class Lab_10_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //GRAFOT E NASOCEN !!!
        int n = sc.nextInt();
        sc.nextLine();
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();
        List<String[]> transformacii = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s1 = sc.next(), s2 = sc.next();
            transformacii.add(new String[]{s1, s2});
        }
        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            graph.addEdge(parts[0], parts[1], Integer.parseInt(parts[2]));
        }
        int sum = 0;
        for (int i = 0; i < transformacii.size(); i++) {
            String v1 = transformacii.get(i)[0], v2 = transformacii.get(i)[1];
            Map<String, Integer> shortest = graph.shortestPath(v1);
            sum += shortest.get(v2);
        }
        System.out.println(sum);
    }
}
