package Kolokvium.K1;

import java.util.Scanner;

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

