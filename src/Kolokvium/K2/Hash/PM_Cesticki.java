package Kolokvium.K2.Hash;

import java.util.Scanner;

public class PM_Cesticki {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        OBHT<String, int[]> table = new OBHT<>(n);
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            String key = parts[0];
            String value = parts[1];
            String[] value_split = value.split(",");
            int Pm1 = Integer.parseInt(value_split[0]);
            int Pm2 = Integer.parseInt(value_split[1]);
            int bucket = table.search(key);
            if (bucket == -1) {
                table.insert(key, new int[]{Pm1, Pm2, 1});
            } else {
                table.getBucket(bucket).value[0] += Pm1;
                table.getBucket(bucket).value[1] += Pm2;
                table.getBucket(bucket).value[2]++;
            }
        }
        String key = sc.nextLine();
        int index = table.search(key);
        if (index == -1) {
            System.out.println("Ne postoi kluc " + key);
        } else {
            int[] pms = table.getBucket(index).value;
            System.out.println((int)Math.ceil((double) pms[0] / pms[2]) + "," +
                    (int)Math.ceil((double) pms[1] / pms[2]));
        }
    }
}
