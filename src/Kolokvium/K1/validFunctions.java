package Kolokvium.K1;

import java.util.Scanner;

public class validFunctions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        Stack<String> stack = new ArrayStack<>(10000);
        while (true) {
            line = sc.nextLine();
            if (line.equals("x")) {
                break;
            }
            if (!line.contains("end")) {
                stack.push(line);
            } else {
                String filtered = line.replace("end", "");
                if (stack.isEmpty()) {
                    stack.push("x");
                    break;
                }
                if (filtered.equals(stack.peek())) {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty())
            System.out.println("Valid");
        else
            System.out.println("Invalid");
    }
}
