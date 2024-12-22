package main.java.luigid;

import java.lang.reflect.Field;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1, num2;
        Field[] menuField = Menu.class.getDeclaredFields();

        System.out.print("Enter first number: ");
        num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        num2 = scanner.nextInt();

        Menu menu = new Menu().setTitle("Choose one of the following:")
                .addOption("Sum", () -> sum(num1, num2))
                .addOption("Difference", () -> difference(num1, num2))
                .addOption("Product", () -> product(num1, num2))
                .addOption("Division", () -> division(num1, num2));

        menu.display();
    }





    public static void sum(int a, int b) {
        System.out.println(a+b);
    }
    public static void difference(int a, int b) {
        System.out.println(a-b);
    }
    public static void product(int a, int b) {
        System.out.println(a*b);
    }
    public static void division(double a, double b) {
        System.out.println(a/b);
    }
}

