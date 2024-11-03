package Kolokvium.K1.Lab1;

import java.util.Scanner;

public class SLLAV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<Integer> list1 = new SLL<>();
        SLL<Integer> list2 = new SLL<>();
        for (int i = 0; i < n; i++) {
            int broj = sc.nextInt();
            list1.insertLast(broj);
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int broj = sc.nextInt();
            list2.insertLast(broj);
        }
        SLL<Integer> result = new SLL<>();
        SLLNode<Integer> list1Curr = list1.getFirst();
        SLLNode<Integer> list2Curr = list2.getFirst();
        while (list1Curr != null || list2Curr != null) {
            if (list1Curr != null && list2Curr != null) {
                if (list1Curr.element < list2Curr.element) {
                    result.insertLast(list1Curr.element);
                    list1Curr = list1Curr.succ;
                } else {
                    result.insertLast(list2Curr.element);
                    list2Curr = list2Curr.succ;
                }
            } else if (list1Curr == null) {
                result.insertLast(list2Curr.element);
                list2Curr = list2Curr.succ;
            } else {
                result.insertLast(list1Curr.element);
                list1Curr = list1Curr.succ;
            }

        }
        System.out.println(result);
//        int counter = 0;
//        SLLNode<Integer> curr = list.getFirst();
//        while (curr != null) {
//            if (curr.element % 2 == 0) {
//                counter++;
//            }
//            curr = curr.succ;
//        }
//        System.out.println(counter);


    }

}
