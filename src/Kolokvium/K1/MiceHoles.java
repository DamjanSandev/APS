package Kolokvium.K1;

import java.util.Arrays;
import java.util.Scanner;
/*
На едно поле има N глувци и N отвори во земјата, распоредени по права линија. Во секој отвор може да се смести само 1 глушец.
Секој глушец може да остане на истата позиција, да се помести едно место на десно од x до x+1, или да се помести
 едно место на лево од x до x-1. Секое поместување зема 1 минута. Повеќе глувци може да се движат истовремено.

Да се најде кој глушец во кој отвор да се смести, со тоа што ќе се минимизира вкупното потребно време,
 односно времето до и последниот глушец да дојде до доделениот отвор.

Влез: Во првиот ред одделени со празно место се дадени позициите на глувците, а во вториот ред исто одделени со
 празно место се дадени позициите на отворите.

Излез: Минималното време во минути за да се сместат сите глувци во одреден отвор.
Primer:
input:    -10 -79 -79 67 93 -85 -28 -94
           -2 9 69 25 -31 23 50 78
output:    102


 */
public class MiceHoles {

    //TODO: implement function
    public static int minTime(int mice[], int holes[]) {
        Arrays.sort(mice);
        Arrays.sort(holes);
        int max = 0;

        for (int i = 0; i < mice.length; i++) {
            int razlika = Math.abs(mice[i] - holes[i]);
//            if (razlika > max) {
//                max = razlika;
//            }
            max = Math.max(max, razlika);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String line = input.nextLine();
        String parts[] = line.split(" ");
        int mice[] = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            mice[i] = Integer.parseInt(parts[i]);
        }

        line = input.nextLine();
        parts = line.split(" ");
        int holes[] = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            holes[i] = Integer.parseInt(parts[i]);
        }

        System.out.println(minTime(mice, holes));
    }
}
