package Kolokvium.K1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NoSuchElementException;


public class PostFixEvaluation {

    static int evaluatePostfix(String[] izraz, int n) {
        Stack<Integer> stack = new ArrayStack<>(n);
        for (int i = 0; i < izraz.length; i++) {
            if (izraz[i].equals("+")) {
                int desen = stack.pop();
                int levo = stack.pop();
                stack.push(levo + desen);
            } else if (izraz[i].equals("-")) {
                int desen = stack.pop();
                int levo = stack.pop();
                stack.push(levo - desen);
            } else if (izraz[i].equals("*")) {
                int desen = stack.pop();
                int levo = stack.pop();
                stack.push(levo * desen);
            } else if (izraz[i].equals("/")) {
                int desen = stack.pop();
                int levo = stack.pop();
                if (desen != 0)
                    stack.push(levo / desen);
            } else {
                stack.push(Integer.parseInt(izraz[i]));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        String[] parts = expression.split("\\s+");
        int rez = evaluatePostfix(parts, parts.length);
        System.out.println(rez);

        br.close();

    }

}