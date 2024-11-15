package Kolokvium.K1;

import java.util.Scanner;

public class PutWordsTogether {
    public static void putWordsTogether(SLL<String> list) {
        System.out.println(list);
        //Pomosna lista
//        SLL<String> result = new SLL<>();
//        String zbor = "";
//        SLLNode<String> curr = list.getFirst();
//        while (curr != null) {
//            if (curr.element.equals(",")) {
//                result.insertLast(zbor);
//                zbor = "";
//            } else {
//                zbor += curr.element;
//                //"cat"
//            }
//            curr = curr.succ;
//        }
//        result.insertLast(zbor);
//        System.out.println(result);


        //Bez Pomosna lista
        SLLNode<String> curr = list.getFirst();
        String zbor = "";
        while (curr != null) {
            if (curr.element.equals(",")) {
                curr.element = zbor;
                zbor = "";
            } else {
                list.delete(curr);
                zbor += curr.element;
            }
            curr = curr.succ;
        }
        list.insertLast(zbor);
        System.out.println(list);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();//cin.getLine()
        //sc.next() e isto so cin>>string
        //c a t , d o g , c o w == line
        // parts[0]=c  parts[1]=a  parts[2]=t  parts[3]=,  .... parts[parts.length-1]=w
        SLL<String> lista = new SLL<>();
        String[] parts = line.split("\\s+");//\\s+ znaci edno ili poveke prazni mesta
        for (int i = 0; i < parts.length; i++) {
            lista.insertLast(parts[i]);
        }
        putWordsTogether(lista);
    }
}
