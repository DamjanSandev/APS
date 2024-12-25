package Kolokvium.K2;

import java.util.Scanner;

public class Lab_9_Doma_2024 {
    public static int sumaNaPatista(AdjacencyListGraph<Integer> graph, Integer pocetnoTeme, int N, int sum) {
        if (sum > N)
            return 0;
        if (sum == N)
            return 1;
        int patista = 0;
        for (Integer sosednoTeme : graph.getNeighbors(pocetnoTeme)) {
            patista += sumaNaPatista(graph, sosednoTeme, N, sum + sosednoTeme);
        }
        return patista;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            graph.addEdge(a, b);
        }
        int pocetnoTeme = sc.nextInt();
        int suma = sc.nextInt();
        System.out.println(sumaNaPatista(graph, pocetnoTeme, suma, pocetnoTeme));
    }
}
