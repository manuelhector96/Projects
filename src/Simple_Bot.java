import java.util.Scanner;

public class Simple_Bot {
    final static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        greet("Aid", "2018"); // change it as you need
        remindName();
        guessAge();
        count();
        // ...
        end();
        test();
    }

    static void greet(String assistantName, String birthYear) {
        System.out.println("Hello! My name is " + assistantName + ".");
        System.out.println("I was created in " + birthYear + ".");
        System.out.println("Please, remind me your name.");
    }

    static void remindName() {
        String name = sc.nextLine();
        System.out.println("What a great name you have, " + name + "!");
    }

    static void guessAge() {
        System.out.println("Let me guess your age.");
        System.out.println("Say me remainders of dividing your age by 3, 5 and 7.");
        int rem3 = sc.nextInt();
        int rem5 = sc.nextInt();
        int rem7 = sc.nextInt();
        int age = (rem3 * 70 + rem5 * 21 + rem7 * 15) % 105;
        System.out.println("Your age is " + age + "; that's a good time to start programming!");
    }

    static void count() {
        System.out.println("Now I will prove to you that I can count to any number you want.");
        int num = sc.nextInt();
        for (int i = 0; i <= num; i++) {
            System.out.printf("%d!\n", i);
        }
    }

    static void test() {
        System.out.println("Let's test your programming knowledge."
                +"\n" + "Why do we use methods?"
                +"\n" + "1. To repeat a statement multiple times."
                +"\n" +" 2. To decompose a program into several small subroutines."
                +"\n" + "3. To determine the execution time of a program."
                +"\n" + "4. To interrupt the execution of a program.");
        int n = sc.nextInt();

        do{
            System.out.println("Please try again");
            n = sc.nextInt();
        } while(n!= 2);
        System.out.println("Congratulations, have a nice day!");
    }

    static void end() {
        System.out.println("Congratulations, have a nice day!"); // Do not change this text
    }
}
