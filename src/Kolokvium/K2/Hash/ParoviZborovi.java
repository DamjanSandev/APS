package Kolokvium.K2.Hash;

import java.util.Scanner;

public class ParoviZborovi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        OBHT<Integer, Integer> table = new OBHT<>(N * 2);
        for (int i = 0; i < N; i++) {
            String zbor = sc.nextLine();
            int len = zbor.length();
            int bucket = table.search(len);
            if (bucket == -1) {
                table.insert(len, 1);
            } else {
                table.getBucket(bucket).value++;
            }
        }
        int sum = 0;
        for (int i = 0; i < N * 2; i++) {
            MapEntry<Integer, Integer> bucket = table.getBucket(i);
            if (bucket != null) {
                sum += (bucket.value * (bucket.value - 1) / 2);
            }
        }
        System.out.println(sum);
    }
}
