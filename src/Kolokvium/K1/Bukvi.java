package Kolokvium.K1;

import java.util.Scanner;

/* Да се напише функција која како аргумент прима DLL.
Инфото на секој јазел е буква распоредена во растечки редослед ( може да има и дупликати ).
Да се отстранат дупликатите, и јазлите да се распределат наизменично ( ако има две согласки или самогласки додруго, втората се брише).

Sample input:
a a e k k l i i s s
a e k l i s

Sample output:
a<->k<->i<->s

 */
public class Bukvi {
    public static boolean daliESamoglaska(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static <E> void printDLL(DLL<E> list) {
        DLLNode<E> curr = list.getFirst();
        while (curr != null) {
            System.out.print(curr.element + " ");
            curr = curr.succ;
        }
        System.out.println();
    }

    public static <E> void removeDuplicates(DLL<E> list) {
        DLLNode<E> i = list.getFirst();
        while (i.succ != null) {
            DLLNode<E> j = i.succ;
            while (j != null) {
                if (j.element.equals(i.element)) {
                    list.delete(j);
                }
                j = j.succ;
            }
            if (i.succ == null) break;
            i = i.succ;
        }
    }

    //    Sample input:
//    a a e k k l i i s s
//    a k i s
//
//    Sample output:
//    a<->k<->i<->s
    public static void alternateCharacters(DLL<String> list) {
        DLLNode<String> curr = list.getFirst();
        while (curr.succ != null) {
            if (daliESamoglaska(curr.element.charAt(0)) && daliESamoglaska(curr.succ.element.charAt(0))) {
                list.delete(curr.succ);
            } else if (!daliESamoglaska(curr.element.charAt(0)) && !daliESamoglaska(curr.succ.element.charAt(0))) {
                list.delete(curr.succ);
            } else {
                curr = curr.succ;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] parts = sc.nextLine().split("\\s+");
        DLL<String> list = new DLL<>();
        for (String part : parts) {
            list.insertLast(part);
        }
        removeDuplicates(list);
        alternateCharacters(list);
        printDLL(list);

    }
}
