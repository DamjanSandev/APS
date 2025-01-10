package Kolokvium.K2.Hash;

import Kolokvium.K1.SLLNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KumanovskiDijalekt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CBHT<String, String> table = new CBHT<>(n * 2);
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            table.insert(parts[0], parts[1]);
        }
        String[] text = sc.nextLine().split("\\s+");
        for (int i = 0; i < text.length; i++) {
            String zbor = text[i];
            zbor = zbor.replace(",", "");
            zbor = zbor.replace(".", "");
            zbor = zbor.replace("!", "");
            zbor = zbor.replace("?", "");
            zbor = zbor.toLowerCase();
            SLLNode<MapEntry<String, String>> node = null;
            if (n != 0) {
                node = table.search(zbor);
            }
            if (node != null) {
                String preveden = node.element.value;
                if (Character.isUpperCase(text[i].charAt(0)))
                    System.out.print(Character.toUpperCase(preveden.charAt(0)) + preveden.substring(1));
                else
                    System.out.print(preveden);
            } else {
                if (Character.isUpperCase(text[i].charAt(0)))
                    System.out.print(Character.toUpperCase(zbor.charAt(0)) + zbor.substring(1));
                else
                    System.out.print(zbor);
            }
            if (text[i].charAt(text[i].length() - 1) == '.' ||
                    text[i].charAt(text[i].length() - 1) == '!' ||
                    text[i].charAt(text[i].length() - 1) == '?' ||
                    text[i].charAt(text[i].length() - 1) == ',') {
                System.out.print(text[i].charAt(text[i].length() - 1));
            }
            System.out.print(" ");
        }

    }
}
