package Kolokvium.K2.Hash;

import java.util.Scanner;

public class UpisiNaFakultet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        OBHT<String, Double> aplikacii = new OBHT<>(n * 2);
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\\s+");
            String embg = parts[0];
            Double prosek = Double.parseDouble(parts[1]);
            aplikacii.insert(embg, prosek);
        }
        int m = sc.nextInt();
        sc.nextLine();
        OBHT<String, Double> e_dnevnik = new OBHT<>(m * 2);
        for (int i = 0; i < m; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\\s+");
            String embg = parts[0];
            Double prosek = Double.parseDouble(parts[1]);
            e_dnevnik.insert(embg, prosek);
        }
        String embg = sc.nextLine();
        int indexApp = aplikacii.search(embg);
        int indexED = e_dnevnik.search(embg);
        if (indexED == -1) {
            System.out.println("Empty");
        } else {
            Double prosekApp = aplikacii.getBucket(indexApp).value;
            Double prosekED = e_dnevnik.getBucket(indexED).value;
            if (prosekED.equals(prosekApp)) {
                System.out.println("Ok");
            } else {
                System.out.println("Error");
            }
        }
    }

}
