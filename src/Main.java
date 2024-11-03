import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a); //vo rastecki redosled
        for (int i = a.length - 1; i >= 0; i--) {
            System.out.printf("%d", a[i]);
        }
    }
}
