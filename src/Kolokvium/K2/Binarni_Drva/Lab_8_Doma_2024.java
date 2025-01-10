package Kolokvium.K2.Binarni_Drva;

import java.util.Scanner;

public class Lab_8_Doma_2024 {
    public static int depth(BNode<Integer> node, int element) {

        if (element == node.info) {
            return 1;
        }
        if (element < node.info) {
            return 1 + depth(node.left, element);
        } else {
            return 1 + depth(node.right, element);
        }
    }

    public static int depthNonRecursive(BNode<Integer> node, int element) {
        int counter = 1;
        while (node.info != element) {
            if (element < node.info) {
                node = node.left;
            } else {
                node = node.right;
            }
            counter++;
        }
        return counter;
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
                System.out.println(depthNonRecursive(tree.getRoot(), Integer.parseInt(parts[1])));
            }

        }

    }

}
