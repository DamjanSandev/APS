package Kolokvium.K2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;

class Lek {
    String ime;
    int pozLista;
    int cena;
    int kolicina;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public int getPozLista() {
        return pozLista;
    }

    public Lek(String ime, int pozLista, int cena, int kolicina) {
        this.ime = ime.toUpperCase();
        this.pozLista = pozLista;
        this.cena = cena;
        this.kolicina = kolicina;
    }

    @Override
    public String toString() {
        if (pozLista == 1) return ime + "\n" + "POZ\n" + cena + "\n" + kolicina;
        else return ime + "\n" + "NEG\n" + cena + "\n" + kolicina;
    }
}

class LekKluch {
    String ime;

    public LekKluch(String ime) {
        this.ime = ime.toUpperCase();
    }

    @Override
    public int hashCode() {
        // TODO implement
        return (29 * (29 * ((int) (ime.charAt(0))) + (int) (ime.charAt(1))) + (int) (ime.charAt(2))) % 102780;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LekKluch lekKluch = (LekKluch) o;
        return Objects.equals(ime, lekKluch.ime);
    }
}

public class Apteka {
    public static void main(String[] args) throws IOException {
        // TODO implement
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        OBHT<LekKluch, Lek> table = new OBHT<>(n * 2);
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\\s+");
            String ime = parts[0].toUpperCase();
            int pozLista = Integer.parseInt(parts[1]);
            int cena = Integer.parseInt(parts[2]);
            int kolicina = Integer.parseInt(parts[3]);
            LekKluch kluch = new LekKluch(ime);
            Lek lek = new Lek(ime, pozLista, cena, kolicina);
            table.insert(kluch, lek);
        }

        while (true) {
            String imeNaLek = sc.nextLine().toUpperCase();
            if (imeNaLek.equals("KRAJ")) {
                break;
            }
            int klkNaracuva = sc.nextInt();
            sc.nextLine();
            LekKluch kluch = new LekKluch(imeNaLek);
            int index = table.search(kluch);
            if (index == -1) {
                System.out.println("Nema takov lek");
            } else {
                Lek lek = table.getBucket(index).value;
                System.out.println(lek);
                if (klkNaracuva > lek.getKolicina()) {
                    System.out.println("Nema dovolno lekovi");
                } else {
                    lek.setKolicina(lek.getKolicina() - klkNaracuva);
                    System.out.println("Napravena naracka");
                }
            }
        }
    }
}