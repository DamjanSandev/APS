import Kolokvium.K1.DLL;
import Kolokvium.K1.DLLNode;
import Kolokvium.K1.SLL;
import Kolokvium.K1.SLLNode;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLL<String> lista = new SLL<>();
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            lista.insertLast(line);
        }
        int len = sc.nextInt();
        System.out.println(lista);
        SLLNode<String> curr = lista.getFirst();
        while (curr != null) {
            if (curr.element.length() == len) {
                lista.insertAfter("Target", curr);
                curr = curr.succ;
            }
            curr = curr.succ;
        }
        //Sky->SkyBlu->Target->target->Blue->Cloud
        //L=6
        System.out.println(lista);
    }
}
