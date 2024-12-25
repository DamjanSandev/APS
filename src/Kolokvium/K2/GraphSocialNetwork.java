package Kolokvium.K2;

import java.util.Scanner;

public class GraphSocialNetwork {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();
        for (int i = 0; i < n; i++) {
            String person = sc.nextLine();
            int friends = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < friends; j++) {
                String friend = sc.nextLine();
                graph.addEdge(person, friend);
            }
        }
        String person1 = sc.nextLine();
        String person2 = sc.nextLine();
        System.out.println(graph.shortestPath(person1, person2));
    }
}
