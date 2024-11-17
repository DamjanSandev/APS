package Kolokvium.K1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

public class CheckXML {
    /*
     Даден е некој модифициран XML код. Модифицираниот XML код ги користи симболите '[' и ']', за отварање и затворање на таг, соодветно, наместо стандардните '<' и '>'. Треба да се провери дали сите тагови во кодот се правилно вгнездени (дали кодот е валиден) т.е. дали секој отворен таг има соодветен затворен таг со истото име на соодветното место во кодот. За поедноставување, дадено е дека секој отворен таг мора да има свој затворен таг и дека таговите немаат атрибути.

На влез е даден бројот на редови во кодот и самиот XML со секој таг во посебен ред, а на излез треба да се испечати 1 или 0 за валиден или невалиден код, соодветно.

Објаснување: Во модифицираниот XML код секој отворен таг е во облик [imeNaTag], а соодветниот затворен таг е во облик [/imeNaTag].

Пример за правилно вгнездени тагови во XML e:

[tag1]
[tag2]
Podatok
[/tag2]
[/tag1]
Пример за неправилно вгнездени тагови во XML e:

[tag1]
[tag2]
Podatok
[/tag1]
[/tag2]
     */

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
