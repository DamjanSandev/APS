package Kolokvium.K1;

import java.util.Scanner;

public class TargetL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<String> list = new SLL<>();
        sc.nextLine(); //mora, isto kako cin.ignore()
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            //nextLine go premestuva citanjeto vo nov red isto kao cin.getline()
            //next cita samo do prazno mesto
            list.insertLast(s);
        }
        int L = sc.nextInt();
        System.out.println(list);
        SLLNode<String> curr = list.getFirst();
        while (curr != null) {
            if (curr.element.length() == L) {
                list.insertAfter("Target", curr);
                curr = curr.succ;
            }
            curr = curr.succ;
        }
        System.out.println(list);
    }
}
