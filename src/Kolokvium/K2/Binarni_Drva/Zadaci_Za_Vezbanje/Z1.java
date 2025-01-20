package Kolokvium.K2.Binarni_Drva.Zadaci_Za_Vezbanje;


import Kolokvium.K2.Binarni_Drva.BNode;
import Kolokvium.K2.Binarni_Drva.BTree;
import Kolokvium.K2.Drva.SLLTree;
import Kolokvium.K2.Drva.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Z1 {
    public static int countLeafNodes(SLLTree.SLLNode<Integer> node) {
        if (node.firstChild == null) {
            return 1;
        }
        SLLTree.SLLNode<Integer> tmp = node.firstChild;
        int count = 0;
        while (tmp != null) {
            count += countLeafNodes(tmp);
            tmp = tmp.sibling;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        sc.nextLine();
        SLLTree<Integer> tree = new SLLTree<>();
        Map<Integer, Tree.Node<Integer>> nodesMap = new HashMap<>();
        for (int i = 0; i < n + q; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            //add 1 2 parts[0]=add ...
            if (parts[0].equals("root")) {
                tree.makeRoot(Integer.parseInt(parts[1]));
                nodesMap.put(Integer.parseInt(parts[1]), tree.root());
            } else if (parts[0].equals("add")) {
                int parent = Integer.parseInt(parts[1]);
                int child = Integer.parseInt(parts[2]);
                Tree.Node<Integer> parentNode = nodesMap.get(parent);
                Tree.Node<Integer> childNode = tree.addChild(parentNode, child);
                nodesMap.put(child, childNode);
            } else {
                //ask
                int parent = Integer.parseInt(parts[1]);
                SLLTree.SLLNode<Integer> parentNode = (SLLTree.SLLNode<Integer>) nodesMap.get(parent);
                System.out.println(countLeafNodes(parentNode));
            }
        }
    }
}
