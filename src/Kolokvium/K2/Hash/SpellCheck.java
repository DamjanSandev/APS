package Kolokvium.K2.Hash;

import java.util.Scanner;

public class SpellCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        OBHT<String, String> table = new OBHT<>(n * 2);
        for (int i = 0; i < n; i++) {
            String zbor = sc.nextLine();
            table.insert(zbor, zbor);
        }
        String[] parts = sc.nextLine().split("\\s+");
        boolean flag = true;
        for (int i = 0; i < parts.length; i++) {
            String zbor = parts[i];
            zbor = zbor.toLowerCase();
            zbor = zbor.replaceAll("[.,!?]", "");
            int index = table.search(zbor);
            if (index == -1) {
                String zborToPrint = parts[i];
                zborToPrint = zborToPrint.replaceAll("[.,!?]", "");
                System.out.println(zborToPrint);
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Bravo");
        }
    }
}
