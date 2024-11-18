package Kolokvium.K1;

import java.util.Scanner;

import java.util.Stack;

public class validFunctions {
    /*
Даден е код на модифициран програмски јазик каде функциите се претставени
со отворен и затворен таг ("imeFunkcija" и "endimeFunkcija").
 Ваша задача е да дефинирате дали даден програмски код е валиден.

Пример валиден код:

func1
func2
endfunc2
func3
endfunc3
endfunc1

Пример невалиден код (испуштен е затворен таг за func3):

func1
func2
endfunc2
func3
endfunc1

Влез: Код со модифициран програмски јазик, каде секој таг е напишан во нов ред. Се внесуваат тагови се додека не се внесе "x".

Излез: "Valid" - доколку е валиден кодот, "Invalid" - доколку не е валиден кодот.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        Stack<String> stack = new Stack<>();
        while (true) {
            line = sc.nextLine();
            if (line.equals("x")) {
                break;
            }
            if (!line.startsWith("end")) {
                stack.push(line);
            } else {
                if (stack.isEmpty()) {
                    //znaeme deka e invalid,stavame neso na stack
                    //za na kraj da ne bide prazen
                    stack.push("random");
                    break;
                }
                String opening = stack.peek();
                String closing = line.replace("end", "");
                if (opening.equals(closing)) {
                    stack.pop();
                } else {
                    break;
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }

}
