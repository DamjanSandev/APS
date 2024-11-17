package Kolokvium.K1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class StackPathDirectory {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<String> stack = new ArrayStack<>(1000);
        // /abc///cde/xyz/.1/asdf//a1.b2/newdir/.2/a/
        // /abc/cde/asdf/a


        String filteredLine = "";
        for (int i = 0; i < line.length() - 1; i++) {
            char c = line.charAt(i);
            if (c == '/' && line.charAt(i + 1) != '/') {
                filteredLine += c;
            } else if (c != '/') {
                filteredLine += c;
            }
        }
        if (line.charAt(line.length() - 1) != '/') {
            filteredLine += line.charAt(line.length() - 1);
        }
        String[] parts = filteredLine.split("/");
        for (int i = 1; i < parts.length; i++) {
            String path = parts[i];
            if (path.startsWith(".")) {
                int toDelete = Integer.parseInt(path.substring(1));
                for (int j = 0; j < toDelete; j++) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                }
            } else {
                stack.push(path);
            }
        }
        Stack<String> result = new ArrayStack<>(10000);
        while (!stack.isEmpty()) {
            result.push(stack.pop());
        }
        String pathFinal = "";
        while (!result.isEmpty()) {
            pathFinal += "/";
            pathFinal += result.pop();
        }
        if (pathFinal.isEmpty()) {
            pathFinal = "/";
        }
        System.out.println(pathFinal);
    }
}
