package Kolokvium.K1;

// Дадена е двострано поврзана листа чии што јазли содржат по еден знак (буква). Листата треба да се подели на две резултантни листи, т.ш. во првата резултантна
// листа ќе бидат бидат сместени самогласките од влезната листа, а во втората – согласките. Јазлите во резултантните листи се додаваат наизменично почнувајќи од почетокот и крајот на влезната листа (т.е. прво се разгледува првиот елемент од листата и се додава во соодветната резултантна листа, па последниот, па вториот итн...)
// Во првиот ред од влезот се дадени буквите од кои се составени јазлите по редослед од влезната листа.
// Во првиот ред од излезот треба да се испечатат јазлите по редослед од првата резултантна листа (т.е. самогласките),
// во вториот ред од втората (т.е. согласките) .
// Име на класа (за Java): PodeliSamoglaski
// Делумно решение: Задачата се смета за делумно решена доколку се поминати 7 тест примери.
// Забелешка: При реализација на задачите МОРА да се користат дадените структури, а не да користат помошни структури како низи или сл.
//
//         Input:
// a b c d e f g h i j
// Output:
// a i e
// j b c h d g f

//Јазлите во резултантните листи се додаваат наизменично почнувајќи од почетокот и крајот на влезната листа
// (т.е. прво се разгледува првиот елемент од листата и се додава во соодветната резултантна листа, па последниот, па вториот итн...)

import java.util.Scanner;

public class PodeliSamoglaski {
    public static boolean daliESamoglaska(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void SamoglaskiSoglaski(DLL<String> lista) {

        DLL<String> lista1 = new DLL<String>();
        DLL<String> lista2 = new DLL<String>();

        DLLNode<String> current = lista.getFirst();
        DLLNode<String> currentOdKraj = lista.getLast();
        String flag = "pocetok";
        for (int i = 0; i < lista.getSize(); i++) {
            if (flag.equals("pocetok")) {
                if (daliESamoglaska(current.element.charAt(0))) {
                    lista1.insertLast(current.element);
                } else {
                    lista2.insertLast(current.element);
                }
                current = current.succ;
                flag = "kraj";
            }
            else{
                if (daliESamoglaska(currentOdKraj.element.charAt(0))) {
                    lista1.insertLast(currentOdKraj.element);
                } else {
                    lista2.insertLast(currentOdKraj.element);
                }
                currentOdKraj=currentOdKraj.pred;
                flag="pocetok";
            }

        }

        System.out.println(lista1);
        System.out.println(lista2);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DLL<String> lista = new DLL<String>();
        String line = sc.nextLine();
        String[] bukvi = line.split(" ");

        for (int i = 0; i < bukvi.length; i++) {
            lista.insertLast(bukvi[i]);
        }

        //System.out.println(lista);
        SamoglaskiSoglaski(lista);
    }
}