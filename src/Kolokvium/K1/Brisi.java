package Kolokvium.K1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Brisi {

/*
Да се бришат елементи од дадена СЛЛ листа се додека има .. појасно тест пример. Првен еден елемент се печате еден се брише па 2 се печатат
па 1 се брише па 3 се печатат ...

Sample input:
1 2 3 4 5 6 7 8 9

Sample output:
1->3->4->6->7->8->
*/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SLL<Integer> list = new SLL<>();

        String line = br.readLine();
        String[] parts = line.split(" ");
        for (int i = 0; i < parts.length; i++) {
            list.insertLast(Integer.parseInt(parts[i]));
        }
        int klkDaPecati = 1;
        SLLNode<Integer> curr = list.getFirst();
        int counter = 0;
        //3
        //1 2 3 4 5 6 7 8 9
        //0 1 0 1 2 0 1 2 3
        while (curr != null) {
            if (counter == klkDaPecati) {
                klkDaPecati++;
                counter = -1;
                list.delete(curr);
            }
            counter++;

            curr = curr.succ;
        }
        System.out.println(list);

    }
}
