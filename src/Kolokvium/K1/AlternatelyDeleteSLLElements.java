package Kolokvium.K1;

import java.util.Scanner;

public class AlternatelyDeleteSLLElements {

    // TODO: implement function
    public static void keepDelete(SLL<Integer> list, int m, int n) {
        int countM = 0, countN = 0;
        SLLNode<Integer> curr = list.getFirst();
        while (curr != null) {
            if (countM < m) {
                countM++;
                countN = 0;
            } else {
                countN++;
                list.delete(curr);
            }
            if (n == countN) {
                countM = 0;
            }
            curr = curr.succ;
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int numElements;
        SLL<Integer> list1 = new SLL<Integer>();
        numElements = scan.nextInt();
        for (int i = 0; i < numElements; i++) {
            list1.insertLast(scan.nextInt());
        }
        int m = scan.nextInt();
        int n = scan.nextInt();
        keepDelete(list1, m, n);
        System.out.println(list1);


    }
}
