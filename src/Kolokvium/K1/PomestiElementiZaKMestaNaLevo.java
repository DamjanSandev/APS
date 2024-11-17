package Kolokvium.K1;

import java.util.Scanner;

public class PomestiElementiZaKMestaNaLevo {
    //Od Zadaci za vezbanje na Nizi i Listi postaveni na courses
    public static void shiftByOneToLeft(DLL<Integer> lista) {
        lista.insertLast(lista.getFirst().element);//stavas prviot kako posleden
        lista.deleteFirst();//brisis prviot i avtomatski site posle se pomestuvaat na levo
    }

    public static void PomestiElementi(DLL<Integer> lista, int n, int k) {
        for (int i = 0; i < k; i++) {
            shiftByOneToLeft(lista);
        }
        System.out.println(lista);
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DLL<Integer> lista = new DLL<Integer>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            lista.insertLast(sc.nextInt());
        }

        int k = sc.nextInt();

        //System.out.println(lista); // ne treba

        PomestiElementi(lista, n, k);


    }
}
