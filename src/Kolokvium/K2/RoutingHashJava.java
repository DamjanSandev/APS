package Kolokvium.K2;

import Kolokvium.K1.SLLNode;

import java.util.List;
import java.util.Scanner;

public class RoutingHashJava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        CBHT<String, String[]> table = new CBHT<>(n * 2);
        for (int i = 0; i < n; i++) {
            String vlezenInterfejs = sc.nextLine();
            String ipAdresi = sc.nextLine();
            String[] partsIpAdresi = ipAdresi.split(",");
            table.insert(vlezenInterfejs, partsIpAdresi);
        }
        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String vlezenInterfejs = sc.nextLine();
            String ipAdresa = sc.nextLine();
            SLLNode<MapEntry<String, String[]>> node = table.search(vlezenInterfejs);
            if (node == null) {
                System.out.println("ne postoi");
            } else {
                String[] ipAdresiNaruter = node.element.value;
                String[] ipAdresaSplit = ipAdresa.split("\\.");
                boolean flag = false;
                for (String s : ipAdresiNaruter) {
                    String[] parts = s.split("\\.");
                    if (parts[0].equals(ipAdresaSplit[0]) && parts[1].equals(ipAdresaSplit[1]) && parts[2].equals(ipAdresaSplit[2])) {
                        System.out.println("postoi");
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    System.out.println("ne postoi");
                }
            }
        }
    }
}
