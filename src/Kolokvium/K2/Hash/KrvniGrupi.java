package Kolokvium.K2.Hash;

import java.util.Scanner;

public class KrvniGrupi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        OBHT<String, Integer> table = new OBHT<>(n * 2);
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            String krvnaGrupa = parts[2];
            krvnaGrupa = krvnaGrupa.substring(0, 1) + krvnaGrupa.substring(krvnaGrupa.length() - 1);
            int index = table.search(krvnaGrupa);
            if (index == -1) {
                table.insert(krvnaGrupa, 1);
            } else {
                table.getBucket(index).value++;
            }
        }
        String krvnaGrupa = sc.nextLine();
        int index = table.search(krvnaGrupa);
        if (index == -1) {
            System.out.println("Ne postoji krvna grupa " + krvnaGrupa);
        } else {
            System.out.println(table.getBucket(index).value);
        }

    }
}
