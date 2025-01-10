package Kolokvium.K2.Hash;

import java.util.*;

class Traveller {
    private String name, surname;
    public int budget;
    private String ip, time, city;
    private int price;

    public Traveller(String name, String surname, int budget, String ip, String time, String city, int price) {
        this.name = name;
        this.surname = surname;
        this.budget = budget;
        this.ip = ip;
        this.time = time;
        this.city = city;
        this.price = price;
    }

    public int timeToMinutes() {
        int hour = Integer.parseInt(time.split(":")[0]);
        int minutes = Integer.parseInt(time.split(":")[1]);
        return hour * 60 + minutes;
    }

    @Override
    public String toString() {
        return String.format("%s %s with salary %d from address %s who logged in at %s", name, surname, budget, ip, time);
    }
}

public class Lab_6_VoLab_2024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        OBHT<String, List<Traveller>> table = new OBHT<>(n * 2);
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            String name = parts[0], surname = parts[1], ip = parts[3], time = parts[4], city = parts[5];
            int budget = Integer.parseInt(parts[2]), price = Integer.parseInt(parts[6]);
            int index = table.search(city);
            if (index == -1) {
                table.insert(city, new ArrayList<>());
            }
            index = table.search(city);
            if (Integer.parseInt(time.split(":")[0]) >= 12)
                table.getBucket(index).value.add(new Traveller(name, surname, budget, ip, time, city, price));
        }
        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            String city = parts[5];
            int index = table.search(city);
            List<Traveller> travellers = table.getBucket(index).value;
            System.out.println("City: " + city + " has the following number of customers:");
            System.out.println(travellers.size());
            System.out.println("The user who logged on earliest after noon from that city is:");
            Traveller min = travellers.stream().min(Comparator.comparing(Traveller::timeToMinutes)).orElse(null);
            System.out.println(min);
            System.out.println();
        }
    }
}
