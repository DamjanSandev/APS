package Kolokvium.K2.Hash;

import java.util.*;

class Ispit implements Comparable<Ispit> {
    String ime;
    String vreme;
    String prostorija;

    public Ispit(String ime, String vreme, String prostorija) {
        this.ime = ime;
        this.vreme = vreme;
        this.prostorija = prostorija;
    }

    int minutes() {
        String[] parts = vreme.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour * 60 + minute;
    }

    @Override
    public int compareTo(Ispit o) {
        if (this.minutes() > o.minutes()) {
            return 1;
        } else if (this.minutes() < o.minutes()) {
            return -1;
        }
        return 0;
    }
}

public class IspitnaSesija {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        OBHT<String, List<Ispit>> table = new OBHT<>(n * 2);
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            String key = parts[0];
            String vreme = parts[1];
            String prostorija = parts[2];
            String predmeti = "";
            for (int j = 3; j < parts.length; j++) {
                predmeti += parts[j] + " ";
            }
            int index = table.search(key);
            if (index == -1) {
                table.insert(key, new ArrayList<>());
            }
            index = table.search(key);
            table.getBucket(index).value.add(new Ispit(predmeti, vreme, prostorija));
        }
        String key = sc.nextLine();
        int index = table.search(key);
        if (index != -1) {
            List<Ispit> ispiti = table.getBucket(index).value;
            Collections.sort(ispiti);
            for (Ispit i : ispiti) {
                System.out.println(i.vreme + " " + i.prostorija + " " + i.ime);
            }
        }
    }
}
