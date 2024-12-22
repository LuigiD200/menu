package main.java.luigid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {
    private record MenuOption(String option, Runnable action) {}
    private String title = "";
    private final List<MenuOption> options = new ArrayList<>();

    public Menu setTitle(String title) {
        this.title = title;
        return this;
    }

    public Menu addOption(String option, Runnable action) {
        options.add(new MenuOption(option, action));
        return this;
    }

    public Menu removeOption(int index) {
        if (index >= 0 && index < options.size()) {
            options.remove(index);
        }
        return this;
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(title);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ") " + options.get(i).option());
        }

        int answer;
        do {
            System.out.print("Answer: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                System.out.print("Answer: ");
                scanner.next();
            }
            answer = scanner.nextInt();
        } while (answer < 1 || answer > options.size());

        options.get(answer - 1).action().run();
    }
}