package Kolokvium.K2.Binarni_Drva;

import java.util.*;

//za daden jazol da se presmeta prosekot na dlabocinite na jazlite vo negovoto poddrvo vklucuvajki go samiot toj jazel
public class K2_Vlezna_2024_Januari {
    public static void averageDepth(BNode<Integer> node, List<Integer> levelOfNodes, int level) {
        if (node != null) {
            levelOfNodes.add(level);
            averageDepth(node.left, levelOfNodes, level + 1);
            averageDepth(node.right, levelOfNodes, level + 1);
        }
    }

    //modifikacija na findNode no tuka vrakame levelot namesto jazelot
    public static int getLevel(BNode<Integer> root, BNode<Integer> node, int level) {
        if (root == null) {
            return 0;
        }
        if (node.info.equals(root.info)) {
            return level;
        }
        int leftSearch = getLevel(root.left, node, level + 1);
        if (leftSearch != 0) {
            return leftSearch;
        }
        return getLevel(root.right, node, level + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        sc.nextLine();
        BTree<Integer> tree = new BTree<>();
        Map<Integer, BNode<Integer>> nodeMap = new HashMap<>();
        for (int i = 0; i < n + q; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            if (parts[0].equals("root")) {
                tree.makeRoot(Integer.parseInt(parts[1]));
                nodeMap.put(Integer.parseInt(parts[1]), tree.root);
            } else if (parts[0].equals("add")) {
                BNode<Integer> parentNode = nodeMap.get(Integer.parseInt(parts[1]));
                int where;
                if (parts[3].equals("LEFT")) {
                    where = 1;
                } else {
                    where = 2;
                }
                BNode<Integer> childNode = tree.addChild(parentNode, where, Integer.parseInt(parts[2]));
                nodeMap.put(Integer.parseInt(parts[2]), childNode);
            } else {
                //ask
                List<Integer> levelOfNodes = new ArrayList<>();
                int levelofNode = getLevel(tree.root, nodeMap.get(Integer.parseInt(parts[1])), 1);
                averageDepth(nodeMap.get(Integer.parseInt(parts[1])), levelOfNodes, levelofNode);
                int sum = 0;
                for (Integer level : levelOfNodes) {
                    sum += level;
                }
                System.out.println((double) sum / levelOfNodes.size());
            }
        }
    }
}
