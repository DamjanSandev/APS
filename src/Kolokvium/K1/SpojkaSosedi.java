package Kolokvium.K1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Во ДЛЛ со едно изминување да се провере колку броја поголеми може да се најдат од големиот број како слепување од два соседни.
//Ако се спојат два соседни се брише вториот.
//
//Sample input:
//        9 8 7 6 5 4 3 2 1 2 3 4 5 6 7 8 9
//        40
//
//Sample output:
//        98<->76<->54<->3<->2<->1<->2<->3<->45<->67<->89<->
//
public class SpojkaSosedi {

    public static void spojka(DLL<Integer> list, int n) {
        DLLNode<Integer> curr = list.getFirst();
        while (curr.succ != null) {
            int result = Integer.parseInt(curr.element.toString() + curr.succ.element.toString());
            if (result >= n) {
                curr.element = result;
                list.delete(curr.succ);
            }
            if (curr.succ == null) break;
            curr = curr.succ;
        }
        System.out.println(list);

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DLL<Integer> list = new DLL<>();

        String line = br.readLine();
        String[] parts = line.split(" ");
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < parts.length; i++)
            list.insertLast(Integer.parseInt(parts[i]));

        spojka(list, n);

    }
}
