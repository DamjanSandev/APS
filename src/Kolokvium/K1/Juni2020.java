package Kolokvium.K1;


/*

Дадена е двојно поврзана лсита со n јазли кои содржат природни броеви. Треба да ја модифицирате листата така што
новата вредност на првиот елемент да е еднаква на
сумата од вредноста на последниот јазел во листата и тековната вредност на првиот елемент,
а после него да се вметне јазел во листата со поголемата вредност од вредноста
на последниот јазел и вредноста на првиот; понатаму новата вредност на вториот јазел
да е еднаква на сумата од вредноста на претпоследниот јазел во листата и вредноста на
вториот јазел во листата, а после него да се вметне јазел во листата со поголемата вредност
од вредноста на претпоследниот и вториот јазел. Оваа модификација да се направи
се до средината на листата. Ако n е непарен број, тогаш да не се менува вредноста на средниот јазел во листата.

Sample input:
5
10 4 5 3 6

16 10 7 4 3 6

16 10 7 4 5 3 6

5/2=2

16 10 7 4 5 3 6

Sample output:
16 10 7 4 5 3 6

Sample input:
6
10 4 5 3 6 8

18 10 10 6 8 5 3 6 8

18 10 10 6 8 5 3 6 8

Sample output:
18 10 10 6 8 5 3 6 8
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Juni2020 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DLL<Integer> list = new DLL<>();
        int num = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String[] parts = line.split(" ");
        for (int i = 0; i < parts.length; i++) {
            list.insertLast(Integer.parseInt(parts[i]));
        }

        modified(list);
    }

    public static void modified(DLL<Integer> lista) {
        int n = lista.getSize();
        DLLNode<Integer> pocetok = lista.getFirst();
        DLLNode<Integer> kraj = lista.getLast();
        for (int i = 0; i < n / 2; i++) {
            if (pocetok.element > kraj.element) {
                lista.insertAfter(pocetok.element, pocetok);
            } else {
                lista.insertAfter(kraj.element, pocetok);
            }
            pocetok.element = pocetok.element + kraj.element;

            pocetok = pocetok.succ.succ;
            kraj = kraj.pred;
        }
        System.out.println(lista);
    }

}
