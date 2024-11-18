package Kolokvium.K1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZalutaniBroevi {
    //Od Zadaci za vezbanje za tehniki na algoritmi na courses
    public static void main(String[] args) {
        //1 3 4 5 2 6 8 7
        // 3 1
        //4 3
        //5 4
        //i 2  j - > 5 4 3 1
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        List<int[]> zalutani = new ArrayList<>();
        //
        //[0,1]
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        //
        for (int i = 1; i < n; i++) {
            int counter = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] < arr[j]) {
                    counter++;
                } else {
                    break;
                }
            }
            if (counter > 0) {
                int[] niza = new int[2];
                niza[0] = arr[i];
                niza[1] = counter;
                zalutani.add(niza);
            }
        }
        System.out.println(zalutani.size());
        for (int i = 0; i < zalutani.size(); i++) {
            System.out.println(zalutani.get(i)[0] + " " + zalutani.get(i)[1]);
        }
    }
}
