package Kolokvium.K2.Hash;

import java.util.Scanner;

public class Preveduvac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        OBHT<String, String> table = new OBHT<>(n * 2);
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\\s+");
            String makedonski = parts[0];
            String ang = parts[1];
            table.insert(ang, makedonski);
        }
        String line;
        while (true) {
            line = sc.nextLine();
            if (line.equals("KRAJ")) {
                break;
            }
            int index = table.search(line);
            if (index != -1) {
                System.out.println(table.getBucket(index).value);
            } else {
                System.out.println("/");
            }
        }
    }
}
