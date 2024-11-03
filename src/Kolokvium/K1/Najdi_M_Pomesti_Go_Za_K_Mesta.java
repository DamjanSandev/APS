package Kolokvium.K1;

import java.util.Scanner;



public class Najdi_M_Pomesti_Go_Za_K_Mesta {
    public static void shiftLeft(DLL<Integer> lista, DLLNode<Integer> node) {
        if (lista.getFirst().equals(node)) {
            lista.insertLast(node.element);
            lista.deleteFirst();
            return;
        }
        DLLNode<Integer> pred = node.pred;
        lista.insertBefore(node.element, pred);
        lista.delete(node);
    }


    static void Najdi_M_Pomesti_Go_Za_K(DLL<Integer> lista, int M, int k) {
        DLLNode<Integer> mEl = lista.find(M);
        if (mEl == null) {
            return;
        }
        for (int i = 0; i < k; i++) {
            mEl = lista.find(mEl.element); //bez ova nema da raboti
            shiftLeft(lista, mEl);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        DLL<Integer> lista = new DLL<Integer>();

        for (int i = 0; i < n; i++) {
            lista.insertLast(sc.nextInt());
        }
        System.out.println(lista);
        int M = sc.nextInt();

        int k = sc.nextInt();

        Najdi_M_Pomesti_Go_Za_K(lista, M, k);
        System.out.println(lista);
    }
}
