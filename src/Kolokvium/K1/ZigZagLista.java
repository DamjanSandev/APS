package Kolokvium.K1;

import java.util.Scanner;

public class ZigZagLista {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<Integer> lista = new SLL<>();
        for (int i = 0; i < n; i++) {
            lista.insertLast(sc.nextInt());
        }
        SLLNode<Integer> curr = lista.getFirst();
        while (curr.succ != null) {
            if (curr.element.equals(0)) {
                lista.delete(curr);
                curr = curr.succ;
            } else if (curr.element < 0 && curr.succ.element < 0) {
                lista.insertAfter(curr.element * (-1), curr);
                curr = curr.succ;
            } else if (curr.element > 0 && curr.succ.element > 0) {
                lista.delete(curr.succ);
            } else {
                curr = curr.succ;
            }
        }
        if (curr.element.equals(0)) {
            lista.delete(curr);
        }
        System.out.println(lista);
    }
}
