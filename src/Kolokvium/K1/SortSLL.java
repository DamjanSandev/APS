package Kolokvium.K1;

import javax.xml.crypto.AlgorithmMethod;
import java.util.Scanner;

public class SortSLL {
    public static void main(String[] args) {
        SLL<Integer> lista = new SLL<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            lista.insertLast(sc.nextInt());
        }
        SLLNode<Integer> i = lista.getFirst();
        while (i.succ != null) {
            SLLNode<Integer> j = i.succ;
            while (j != null) {
                if (i.element > j.element) {
                    Integer tmp = i.element;
                    i.element = j.element;
                    j.element = tmp;
                }
                j = j.succ;
            }
            i = i.succ;
        }
        System.out.println(lista);
    }
}
