import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1) Get random numbers between 1 and 100");
            System.out.println("2) Summarize numbers");
            System.out.println("Qq) Quit");
            System.out.print("Enter your Choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                createNr(scanner);
            } else if (choice.equals("2")) {
                intakeNr(scanner);
            } else if (choice.equalsIgnoreCase("q")) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
        scanner.close();
    }

    public static void createNr(Scanner scanner) {
        List<Integer> list = new ArrayList<>();
        Random rand = new Random();
        System.out.println("Hom many numbers do you want to see?");
        int amount = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Generated numbers: ");
        for (int i = 0; i < amount; i++) {
            int n = rand.nextInt(100) + 1; // Generate random number between 1 and 100
            list.add(n);
            System.out.print(n+" ");
        }
        System.out.println();
        System.out.println("Do you want to summarize the values? Yy/Nn");

        String choice2 = scanner.nextLine();
        if (choice2.equalsIgnoreCase("y")) {
            int result = summarize(list);
            System.out.println("The sum is:" + result);
        }
    }

    public static void intakeNr(Scanner scanner) {
        System.out.println("Enter values separated by a space and end it by a newline");
        String user_input = scanner.nextLine();
        List<Integer> numbers = convertStringToList(user_input);
        int counter = numbers.size();
        System.out.println("You enterd "+ counter +" numbers");
        int result = summarize(numbers);
        System.out.println("The sum is: " + result);
    }

    public static int summarize(List<Integer> input) {
        int result = 0;
        for (int i = 0; i < input.size(); i++) {
            result += input.get(i);
        }
        return result;
    }

    public static List<Integer> convertStringToList(String input) {
        List<Integer> list = new ArrayList<>();
        String[] parts = input.split(" "); // Split by space

        for (String part : parts) {
            list.add(Integer.parseInt(part)); // Convert each substring to an Integer
        }

        return list;
    }
}
