package Kolokvium.K1;

import java.util.Scanner;

public class ListaOdListi {

    public static long findMagicNumber(DLL<DLL<Integer>> list) {
        //Vashiot kod tuka...
        long product = 1;
        DLLNode<DLL<Integer>> listiJazel = list.getFirst();
        while (listiJazel != null) {
            DLLNode<Integer> elementiNaListaJazel = listiJazel.element.getFirst();
            Integer suma = 0;
            while (elementiNaListaJazel != null) {
                suma += elementiNaListaJazel.element;
                elementiNaListaJazel = elementiNaListaJazel.succ;
            }
            product *= suma;
            listiJazel = listiJazel.succ;
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