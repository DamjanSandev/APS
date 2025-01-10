package Kolokvium.K2.Binarni_Drva;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PreorderNonRecursive {
    public static void printPreorderNonRecursive(BNode<String> root) {
        Stack<BNode<String>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BNode<String> node = stack.pop();
            System.out.print(node.info + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<BNode<String>> listaJazli = new ArrayList<>();
        BTree<String> tree = new BTree<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            if (parts[2].equals("ROOT")) {
                tree.makeRoot(parts[1]);
                listaJazli.add(tree.root);
            } else {
                int indexParent = Integer.parseInt(parts[3]);
                BNode<String> parentNode = listaJazli.get(indexParent);
                String value = parts[1];
                if (parts[2].equals("LEFT")) {
                    tree.addChild(parentNode, 1, value);
                    listaJazli.add(parentNode.left);
                } else {
                    tree.addChild(parentNode, 2, value);
                    listaJazli.add(parentNode.right);
                }
            }
        }
        printPreorderNonRecursive(tree.root);
    }
}

