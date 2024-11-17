package Kolokvium.K1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NoSuchElementException;


public class PostFixEvaluation {
/*
<p>Да се напише алгоритам кој ќе врши евалуација на израз во постфикс нотација.</p>

<p>На влез се чита низа од знаци за изразот (стринг), а на излез се печати вредноста на изразот по евалуацијата.</p>

<p>Име на класата (Java): PostFixEvaluation</p>

----------

<p>Write an algorithm that will evaluate an expression in postfix notation.</p>

<p>A sequence of characters for the expression (string) is read at the input, and the value of the expression after evaluation is printed at the output.</p>

<p>Class Name (Java): PostFixEvaluation</p>

For example:

Input	Result
1 2 +
3
28 72 * 13 + 20 67 * +
3369

 */
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