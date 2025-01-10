package Kolokvium.K2.Drva;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Kolokvium.K2.Drva.SLLTree.SLLNode;

public class Lab_7_Doma_2024 {
    public static int countLeafNodes(SLLNode<Integer> node) {
        if (node == null) return 0;
        SLLNode<Integer> child = node.firstChild;
        if (child == null) return 1;
        int count = 0;
        while (child != null) {
            count += countLeafNodes(child);
            child = child.sibling;
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        sc.nextLine();
        SLLTree<Integer> tree = new SLLTree<>();
        List<SLLNode<Integer>> listaJazli = new ArrayList<>();
        for (int i = 0; i < n + q; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            if (parts[0].equals("root")) {
                tree.makeRoot(1);
                listaJazli.add(tree.root);
            } else if (parts[0].equals("add")) {
                int indexParent = Integer.parseInt(parts[1]);
                SLLNode<Integer> node = null;
                for (int j = 0; j < listaJazli.size(); j++) {
                    if (listaJazli.get(j).element.equals(indexParent)) {
                        node = listaJazli.get(j);
                        break;
                    }
                }
                tree.addChild(node, Integer.parseInt(parts[2]));
                listaJazli.add(node.firstChild);
            } else {
                int index = Integer.parseInt(parts[1]);
                SLLNode<Integer> node = null;
                for (int j = 0; j < listaJazli.size(); j++) {
                    if (listaJazli.get(j).element.equals(index)) {
                        node = listaJazli.get(j);
                        break;
                    }
                }
                System.out.println(countLeafNodes(node));
            }
        }

    }
}
