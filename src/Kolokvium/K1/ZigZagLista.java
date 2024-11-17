package Kolokvium.K1;

import java.util.Scanner;

public class ZigZagLista {
    //Listata treba da se napravi zig zag
    //1. Dokolku elementot e 0 se brise
    //2.Ako ima dva pozitivni eden do drug se brise vtoriot
    //3.AKo ima dva negativni eden do drug izmegju se niv dodava nov jazel so vrednost absoluten broj od prviot jazel
    //input: 4 7 -3 -2 0 7 7 9
    //output: 4 -3 3 -2 7
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
