package Kolokvium.K2.Binarni_Drva;

import java.util.Scanner;

public class Lab_8_Vo_Lab_2024 {
    public static int smallerThanGivenNode(BNode<Integer> node) {
        if (node == null) {
            return 0;
        }
        return 1 + smallerThanGivenNode(node.left) + smallerThanGivenNode(node.right);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        sc.nextLine();
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int i = 0; i < n + q; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            if (parts[0].equals("insert")) {
                tree.insert(Integer.parseInt(parts[1]));
            } else {
                BNode<Integer> node = tree.find(Integer.parseInt(parts[1]));
                System.out.println(smallerThanGivenNode(node.left));
            }

        }
    }
}
