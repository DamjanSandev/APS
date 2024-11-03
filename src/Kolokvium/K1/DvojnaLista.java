package Kolokvium.K1;

//Дадени се две сортирани двојно поврзани листи, при што, првата листа е сортирана во растечки редослед,
//        а втората е сортирана во опаѓачки редослед. Да се конструира нова двојно поврзана
//        листа којашто ќе ги содржи сите елементи од двете листи и тоа во опаѓачки редослед.
//        При решавањето на задачата не смее да се користи сортирање на листи.
//
//
//        Влез: Во првиот ред дадени се два броја: M и N, коишто ги означуваат должините на листите, соодветно.
//        Во вториот ред се дадени М броеви - елементите на првата листа. Во третиот ред дадени се N броеви - елементите на втората листа.
//
//
//        Излез: Броевите од финалната листа. Во првиот ред се печатат по редослед од прв до последен, а во вториот обратно, од последен до прв.
//
//
//        Забелешка: Даден е основниот код од задачата со имплементиран влез и излез како и структурата која треба да се користи.
//        Дадена е и класата  DvojnaLista, во која  на точно означеното место ќе трeба да се имплементират бараните услови.
//        Вашиот код треба да биде напишан само таму, без измени во останатиот дел од кодот.
//


import java.util.Scanner;

public class DvojnaLista {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //citanje na broj na elementi
        int m = input.nextInt();
        int n = input.nextInt();

        DLL<Integer> lista1 = new DLL<Integer>();
        DLL<Integer> lista2 = new DLL<Integer>();
        DLL<Integer> lista3 = new DLL<Integer>();


        //citaj listi, edna po edna
        for (int i = 0; i < m; i++) {
            int el = input.nextInt();
            lista1.insertLast(el);
        }

        for (int i = 0; i < n; i++) {
            int el = input.nextInt();
            lista2.insertLast(el);
        }

        //vasiot kod tuka ...

        DLLNode<Integer> current1 = lista1.getLast(); //desno kon levo
        DLLNode<Integer> current2 = lista2.getFirst();//levo kon desno
        while (current1 != null && current2 != null) {
            if (current1.element > current2.element) {
                lista3.insertLast(current1.element);
                current1 = current1.pred;
            } else {
                lista3.insertLast(current2.element);
                current2 = current2.succ;
            }
        }
        while (current1 != null) {
            lista3.insertLast(current1.element);
            current1 = current1.pred;
        }
        while (current2 != null) {
            lista3.insertLast(current2.element);
            current2 = current2.succ;
        }

        //pecatenje
        System.out.println(lista3.toString());
    }

}

