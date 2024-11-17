package Kolokvium.K1;

import java.util.Scanner;
/*
Луѓето доаѓаат наутро во МВР за да извадат еден или повеќе документи.

Документите може да бидат:
1. Лична карта
2. Пасош
3. Возачка дозвола

Кога се отвора шалтерот прво се услужуваат луѓето кои чекаат за лична карта, па потоа оние за пасош и на крај оние за возачка дозвола.
Секој човек кога ќе дојде си застанува во редицата за соодветната исправа која ја вади (т.е. или во редицата за лични карти или во редицата за пасоши или во редицата за возачки дозволи). Доколку еден човек има повеќе документи за вадење прво вади лична карта, па пасош и на крај возачка. Така ако еден човек треба да вади и лична карта и возачка дозвола прво застанува во редицата за лични карти и откако ќе заврши таму оди на крајот на редицата за возачки дозволи.

Влез: Првиот ред означува колку луѓе вкупно дошле во МВР. Потоа за секој човек се внесуваат четири реда, во првиот е името и презимето на човекот, а во останатите три реда се кажува кој документ соодветно (лична карта, пасош и возачка) треба да се земе, притоа 1 значи дека треба да се земе тој документ, 0 значи дека не треба да се земе.

На пример:

Aleksandar Aleksandrovski
1
0
1
означува дека Александар Александровски ќе вади и лична карта и возачка дозвола, но нема да вади пасош.
Излез: Ги печати имињата на луѓето по редоследот по кој завршуваат со вадење на документи.
 */
class Gragjanin {
    String imePrezime;
    int lKarta, pasos, vozacka;

    public Gragjanin(String imePrezime, int lKarta, int pasos, int vozacka) {
        this.imePrezime = imePrezime;
        this.lKarta = lKarta;
        this.pasos = pasos;
        this.vozacka = vozacka;
    }
}

public class MVR {

    public static void main(String[] args) {

        Scanner br = new Scanner(System.in);

        int N = Integer.parseInt(br.nextLine());
        ArrayQueue<Gragjanin> lkartaRedica = new ArrayQueue<>(N);
        ArrayQueue<Gragjanin> pasosRedica = new ArrayQueue<>(N);
        ArrayQueue<Gragjanin> vozackaRedica = new ArrayQueue<>(N);
        for (int i = 1; i <= N; i++) {
            String imePrezime = br.nextLine();
            int lKarta = Integer.parseInt(br.nextLine());
            int pasos = Integer.parseInt(br.nextLine());
            int vozacka = Integer.parseInt(br.nextLine());
            Gragjanin covek = new Gragjanin(imePrezime, lKarta, pasos, vozacka);
            if (covek.lKarta == 1) {
                lkartaRedica.enqueue(covek);
            } else if (covek.pasos == 1) {
                pasosRedica.enqueue(covek);
            } else if (covek.vozacka == 1) {
                vozackaRedica.enqueue(covek);
            }
        }
        while (!lkartaRedica.isEmpty()) {
            Gragjanin covek = lkartaRedica.dequeue();
            if (covek.pasos == 1) {
                pasosRedica.enqueue(covek);
            } else if (covek.vozacka == 1) {
                vozackaRedica.enqueue(covek);
            } else
                System.out.println(covek.imePrezime);
        }
        while (!pasosRedica.isEmpty()) {
            Gragjanin covek = pasosRedica.dequeue();
            if (covek.vozacka == 1) {
                vozackaRedica.enqueue(covek);
            } else {
                System.out.println(covek.imePrezime);
            }
        }
        while (!vozackaRedica.isEmpty()) {
            Gragjanin covek = vozackaRedica.dequeue();
            System.out.println(covek.imePrezime);
        }
    }

}

