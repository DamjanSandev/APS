package Kolokvium.K2.Binarni_Drva.Zadaci_Za_Vezbanje;


import Kolokvium.K2.Binarni_Drva.BNode;
import Kolokvium.K2.Binarni_Drva.BTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Z3 {
    public static int fullNode(BNode<String> node) {
        if (node == null)
            return 0;
        if (node.left != null && node.right != null)
            return fullNode(node.left) + fullNode(node.right) + 1;
        if (node.left != null) {
            return fullNode(node.left);
        }
        return fullNode(node.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        sc.nextLine();
        BTree<String> tree = new BTree<>();
        Map<String, BNode<String>> nodeMap = new HashMap<>();
        for (int i = 0; i < n + q; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            if (parts[0].equals("root")) {
                tree.makeRoot(parts[1]);
                nodeMap.put(parts[1], tree.root);
            } else if (parts[0].equals("add")) {
                BNode<String> parentNode = nodeMap.get(parts[1]);
                int where;
                if (parts[3].equals("LEFT")) {
                    where = 1;
                } else {
                    where = 2;
                }
                BNode<String> childNode = tree.addChild(parentNode, where, parts[2]);
                nodeMap.put(parts[2], childNode);
            } else {
                //ask
                System.out.println(fullNode(nodeMap.get(parts[1])));
            }
        }
    }
}
