package Kolokvium.K1;

import java.util.Scanner;

public class ListaOdListi {
    //Zadaci za prv kolokvim 2ra
    public static long findMagicNumber(DLL<DLL<Integer>> list) {
        long product = 1;
        DLLNode<DLL<Integer>> listiNode = list.getFirst();
        while (listiNode != null) {
            DLLNode<Integer> curr = listiNode.element.getFirst();
            int sum = 0;
            while (curr != null) {
                sum += curr.element;
                curr = curr.succ;
            }
            product *= sum;
            listiNode = listiNode.succ;
        }
        return product;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        DLL<DLL<Integer>> list = new DLL<>();
        for (int i = 0; i < n; i++) {
            DLL<Integer> tmp = new DLL<>();
            for (int j = 0; j < m; j++) {
                tmp.insertLast(in.nextInt());
            }
            list.insertLast(tmp);
        }
        in.close();
        System.out.println(findMagicNumber(list));
    }

}