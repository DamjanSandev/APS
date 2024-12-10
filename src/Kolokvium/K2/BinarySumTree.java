package Kolokvium.K2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BinarySumTree {
    public static int sumSubtree(BNode<Integer> root, int where) {
        Stack<BNode<Integer>> stack = new Stack<>();
        int sum = 0;
        BNode<Integer> curr = null;
        if (where == 1) {
            curr = root.left;
        } else {
            curr = root.right;
        }
        stack.push(curr);
        while (!stack.isEmpty()) {
            BNode<Integer> node = stack.pop();
            if (where == 1) {
                if (node.info < root.info) {
                    sum += node.info;
                }
            } else {
                if (node.info > root.info) {
                    sum += node.info;
                }
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<BNode<Integer>> listaJazli = new ArrayList<>();
        BTree<Integer> tree = new BTree<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            if (parts[2].equals("ROOT")) {
                tree.makeRoot(Integer.parseInt(parts[1]));
                listaJazli.add(tree.root);
            } else {
                int indexParent = Integer.parseInt(parts[3]);
                BNode<Integer> parentNode = listaJazli.get(indexParent);
                Integer value = Integer.parseInt(parts[1]);
                if (parts[2].equals("LEFT")) {
                    tree.addChild(parentNode, 1, value);
                    listaJazli.add(parentNode.left);
                } else {
                    tree.addChild(parentNode, 2, value);
                    listaJazli.add(parentNode.right);
                }
            }
        }
        int jazel = sc.nextInt();
        BNode<Integer> najdenJazel = tree.findNodeNonRecursive(jazel);
        int sumaLevoPodDrvo = sumSubtree(najdenJazel, 1);
        int sumaDesnoPodDrvo = sumSubtree(najdenJazel, 2);
        System.out.println(sumaLevoPodDrvo + " " + sumaDesnoPodDrvo);
    }
}
