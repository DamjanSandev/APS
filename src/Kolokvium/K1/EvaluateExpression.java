package Kolokvium.K1;

import java.util.Scanner;
import java.util.Stack;

/*
Да се напише алгоритам кој ќе пресметува (евалуира) математички израз
 составен од броеви и операциите за собирање (+) и множење (*).

Забелешка: Операцијата множење има предност пред операцијата собирање.

For example:
Input	Result
2+2*2*2*2*2*2+2*2
70


 */
public class EvaluateExpression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char operator = ' ';
        String formNumber = "";
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                formNumber += input.charAt(i);
            } else {
                if (operator == '+') {
                    stack.push(Integer.parseInt(formNumber));
                } else {
                    int broj = 1;
                    if (!stack.isEmpty()) {
                        broj = stack.pop();
                    }
                    stack.push(broj * Integer.parseInt(formNumber));
                }
                operator = input.charAt(i);
                formNumber = "";
            }
        }
        if (operator == '+') {
            stack.push(Integer.parseInt(formNumber));
        } else {
            stack.push(Integer.parseInt(formNumber) * stack.pop());
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}
