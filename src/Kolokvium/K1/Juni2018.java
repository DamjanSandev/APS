package Kolokvium.K1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Juni2018 {
    //1 2 6 7 8
    //3
   /*
    Даена беше еднострано поврзана листа, се бараше N пати да се избрише средината.
    Ако листата е со парен број елементи од 2та средишни елементи се брише помалиот, а ако се исти се брише првиот.
    Влез: првата линија број на елементи на листата,вториот ред елементите на листата и во третиот ред број колку пати да се избрише средината.
            */
    public static void juni(SLL<Integer> list, int delMid) {
        for (int i = 0; i < delMid; i++) {
            if (list.getFirst() == null) {
                break;
            }
            int n = list.length();
            //0 1 2 3 4 5
            //6 /2 =3-1=2
            SLLNode<Integer> curr = list.getFirst();
            if (n % 2 != 0) {
                for (int j = 0; j < n / 2; j++) {
                    curr = curr.succ;
                }
                list.delete(curr);
            } else {
                for (int j = 0; j < n / 2 - 1; j++) {
                    curr = curr.succ;
                }
                if (curr.element <= curr.succ.element) {
                    list.delete(curr);
                } else {
                    list.delete(curr.succ);
                }
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SLL<Integer> list = new SLL<>();

        int brElem = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String[] parts = line.split(" ");
        int delMid = Integer.parseInt(br.readLine());

        for (int i = 0; i < brElem; i++) {
            list.insertLast(Integer.parseInt(parts[i]));
        }
        juni(list, delMid);
    }
}
