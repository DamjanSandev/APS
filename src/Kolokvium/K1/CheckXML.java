package Kolokvium.K1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

public class CheckXML {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String[] redovi = new String[n];

        for (int i = 0; i < n; i++)
            redovi[i] = br.readLine();

        int valid = 0;

        Stack<String> stack = new ArrayStack<>(redovi.length);

        for (int i = 0; i < redovi.length; i++) {
            if (redovi[i].contains("[/")) {
                String openingTag = stack.peek();
                redovi[i] = redovi[i].replace("/", "");
            if (openingTag.equals(redovi[i])) {
                stack.pop();
            }
        } else if (redovi[i].contains("[")) {
            stack.push(redovi[i]);
        }

    }
        if(stack.isEmpty())

    {
        valid = 1;
    }


        System.out.println(valid);

        br.close();
}
}
