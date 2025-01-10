package Kolokvium.K2.Hash;

// Следните класи веќе се импортирани, не е дозволено копирање на класи овде, директно користејте ги како кога се достапни во други локални фајлови:

// CBHT, OBHT, MapEntry, SLLNode веќе се импортирани

import Kolokvium.K1.SLLNode;

import java.util.Scanner;

// Овде креирајте ги помошните класи за клуч и вредност
// Исполнете ги барaањата од текстот за toString методите
// Дополнително осигурете се дека вашата клуч класа ќе ги имплементира потребните
// hashCode и equals методи

class Person {
    // поставете ги потребните полиња овде
    private String name;
    private int age;

    // имплементирајте соодветен конструктор
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        // имплементирајте го toString методот според барањето во текстот
        //%s string, %d int , %f za realni broevi, %c za karakteri
        return String.format("<%s, %d>", name, age);
//        String str = "<" + name + ", " + age + ">";
//        return str;
    }


    // имплементирајте ги следните два методи за да работи табелата правилно
    @Override
    public boolean equals(Object o) {
        Person p = (Person) o;
        return name.equals(p.name) && age == p.age;
    }

    @Override
    public int hashCode() {
        return age * (int) name.charAt(0);
    }
}

class Project {
    private int rabotnoVreme, plataPoCas;

    Project(int rabotnoVreme, int plata) {
        this.rabotnoVreme = rabotnoVreme;
        this.plataPoCas = plata;
    }

    int getPlata() {
        return plataPoCas * rabotnoVreme;
    }


    @Override
    public String toString() {
        return String.format("<%d, %d>", rabotnoVreme, plataPoCas);
    }
}

public class Lab_6_Doma_2024 {
    public static void main(String[] args) {
        // Креирајте ја табелата според барањата
        Scanner in = new Scanner(System.in);
        CBHT<Person, Project> table = new CBHT<Person,Project>(10);


        // Прочитајте ги податоците од влезот и пополнете ја табелата
        int n = in.nextInt();
        //5
        //sadasdasdsadsa
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            String[] parts = line.split("\\s+");
            String name = parts[0];
            int age = Integer.parseInt(parts[1]);
            int rabVreme = Integer.parseInt(parts[2]);
            int plata = Integer.parseInt(parts[3]);
            Person p = new Person(name, age);
            Project pt = new Project(rabVreme, plata);
            SLLNode<MapEntry<Person, Project>> node = table.search(p);
            if (node == null) {
                table.insert(p, pt);
            } else {
                Project project = node.element.value;
                if (pt.getPlata() > project.getPlata()) {
                    table.insert(p, pt);
                }
            }
        }


        // отпечатете ја вашата табела
        System.out.println(table);
    }
}


