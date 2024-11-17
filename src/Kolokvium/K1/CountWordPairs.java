package Kolokvium.K1;

import java.util.Scanner;

public class CountWordPairs {
/*
Дадени се N зборови (N>=2). Најдете го бројот на парови од зборови коишто почнуваат на иста буква.

Влез: Во првиот ред од влезот е даден бројот на зборови (N). Потоа, во следните N редови влез, се дадени самите зборови.

Излез: На излез треба да се испечати бројот на парови од зборови коишто почнуваат на иста буква.
Primer:
input:
8
carrot
dog
banana
elephant
cherry
boat
dolphin
cat
output:
5

 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        //PRV NACIN
//        String[] words = new String[n];
//        for (int i = 0; i < n; i++) {
//            words[i] = sc.nextLine();
//        }
        //int counter = 0;
//        for (int i = 0; i < words.length; i++) {
//            for (int j = i + 1; j < words.length; j++) {
//                if (words[i].charAt(0) == words[j].charAt(0)) {
//                    counter++;
//                }
//            }
//        }

        //VTOR NACIn
        int counter = 0;
        int a[] = new int[26];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            a[s.charAt(0) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            int brojPovajuvanja = a[i];
            brojPovajuvanja = brojPovajuvanja * (brojPovajuvanja - 1) / 2;
            counter += brojPovajuvanja;
        }
        System.out.println(counter);
        //a=65 - 65 = 0
        //b=66 - 65 = 1
        //c=67 - 65 = 2

    }
}
