package Kolokvium.K1;

import java.util.Scanner;

public class DeleteSLL {
    //Ako brojot na pojavuvanja na "br" vo listata e neparen da se dodade
    //nov jazel pred prvoto pojavuvanje na "br"
    public static void change(SLL<Integer> list, int br) {
        int counter = 0;
        SLLNode<Integer> curr = list.getFirst();
        while (curr != null) {
            if (curr.element.equals(br)) {
                counter++;
            }
            curr = curr.succ;
        }
        if (counter % 2 != 0) {
            SLLNode<Integer> tmp = list.find(br);
            list.insertBefore(br, tmp);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int n, broj;
        SLL<Integer> list1 = new SLL<Integer>();
        n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            list1.insertLast(scan.nextInt());
        }
        int br = scan.nextInt();
        change(list1, br);
        System.out.println(list1);
    }
}
