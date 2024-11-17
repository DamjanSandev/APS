package Kolokvium.K1;

import java.util.Scanner;

public class AlternatelyDeleteSLLElements {

    // TODO: implement function
    //Naizmenicno se cuvaat m elementi pa se brisat n elementi od listata
    //pr. 1 2 3 4 5 6 7 8 m=2 n=3 -> 1 2 6 7
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
