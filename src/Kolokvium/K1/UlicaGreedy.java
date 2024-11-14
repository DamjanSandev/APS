package Kolokvium.K1;

import java.util.Arrays;
import java.util.Scanner;

public class UlicaGreedy {

    public static int minLights(int N, int M, int[] positions) {
        Arrays.sort(positions);
        int[] ulica = new int[M + 1];

        int counter = 0;
        for (int j = 0; j < N; j++) {
            if (ulica[M] == 1) {
                break;
            }
            if (positions[j] - 1 >= 0 && ulica[positions[j] - 1] == 1 && positions[j] - 2 >= 0 && ulica[positions[j] - 2] == 1 && ulica[positions[j]] == 1) {
                counter--;
            }

                ulica[positions[j]] = 1;
                if (positions[j] + 1 <= M) {
                    ulica[positions[j] + 1] = 1;
                }
                if (positions[j] + 2 <= M) {
                    ulica[positions[j] + 2] = 1;
                }
                if (positions[j] - 1 >= 0) {
                    ulica[positions[j] - 1] = 1;
                }
                if (positions[j] - 2 >= 0) {
                    ulica[positions[j] - 2] = 1;
                }
            counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(minLights(n, m, arr));

    }
}
