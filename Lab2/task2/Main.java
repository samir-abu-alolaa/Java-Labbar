package task2;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {  // Class names should start with a capital letter
    // Method to create a list of default persons
    public ArrayList<Person> createDefault() {
        Person p1 = new Person("Samir", "Ola", 2001);
        Person p2 = new Person("Saffe", "AlHassan", 2001);
        Person p3 = new Person("Maya", "Ola", 2003);
        Person p4 = new Person("Robeen", "Ola", 1999);
        Person p5 = new Person("Kamleh", "Ola", 1950);

        ArrayList<Person> dummyList = new ArrayList<>();
        dummyList.add(p1);
        dummyList.add(p2);
        dummyList.add(p3);
        dummyList.add(p4);
        dummyList.add(p5);
        return dummyList;
    }

    public static Person addPerson() {
        Scanner scanner = new Scanner(System.in);
        String firstName, lastName;
        int birthYear = 0;
    
        System.out.println("Enter first name:");
        firstName = scanner.nextLine();
        
        System.out.println("Enter last name:");
        lastName = scanner.nextLine();
        
        // Input validation for birth year (int)
        while (true) {
            System.out.println("Enter birth year:");
            try {
                birthYear = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid birth year. Please enter a valid number.");
            }
        }
    
        // Create the new person
        return new Person(firstName, lastName, birthYear);
    }
    
    public static Person addSuperman() {
        Scanner scanner = new Scanner(System.in);
        String firstName, lastName, costumeColor;
        boolean xRay = false; // Boolean for x-ray vision
        int strengthLevel = 0, birthYear = 0;
    
        // Input for firstName, lastName, and costumeColor
        System.out.println("Enter first name:");
        firstName = scanner.nextLine();
        System.out.println("Enter last name:");
        lastName = scanner.nextLine();
        System.out.println("Enter costume color:");
        costumeColor = scanner.nextLine();
    
        // Input validation for xRay vision (boolean)
        while (true) {
            System.out.println("Enter true or false for xRay vision:");
            String input = scanner.nextLine().toLowerCase(); // Convert input to lowercase for easier comparison
            if (input.equals("true")) {
                xRay = true;
                break;
            } else if (input.equals("false")) {
                xRay = false;
                break;
            } else {
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
            }
        }
    
        // Input validation for strength level (int)
        while (true) {
            System.out.println("Enter strength level:");
            try {
                strengthLevel = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid strength level. Please enter a valid number.");
            }
        }
    
        // Input validation for birth year (int)
        while (true) {
            System.out.println("Enter birth year:");
            try {
                birthYear = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid birth year. Please enter a valid number.");
            }
        }
    
        return new Superman(costumeColor, xRay, strengthLevel, firstName, lastName, birthYear);
    }
    

    public static Person addSupermanJr() {
        Scanner scanner = new Scanner(System.in);
        String firstName, lastName, costumeColor;
        boolean xRay = false, training = false;
        int strengthLevel = 0, experienceLevel = 0, birthYear = 0;
    
        // Input for firstName, lastName, and costumeColor
        System.out.println("Enter first name:");
        firstName = scanner.nextLine();
        
        System.out.println("Enter last name:");
        lastName = scanner.nextLine();
        
        System.out.println("Enter costume color:");
        costumeColor = scanner.nextLine();
        
        // Input validation for xRay vision (boolean)
        while (true) {
            System.out.println("Enter true or false for xRay vision:");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("true")) {
                xRay = true;
                break;
            } else if (input.equals("false")) {
                xRay = false;
                break;
            } else {
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
            }
        }
    
        // Input validation for training (boolean)
        while (true) {
            System.out.println("Enter true or false for training with Superman:");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("true")) {
                training = true;
                break;
            } else if (input.equals("false")) {
                training = false;
                break;
            } else {
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
            }
        }
        
        // Input validation for strength level (int)
        while (true) {
            System.out.println("Enter strength level:");
            try {
                strengthLevel = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid strength level. Please enter a valid number.");
            }
        }
    
        // Input validation for experience level (int)
        while (true) {
            System.out.println("Enter experience level:");
            try {
                experienceLevel = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid experience level. Please enter a valid number.");
            }
        }
    
        // Input validation for birth year (int)
        while (true) {
            System.out.println("Enter birth year:");
            try {
                birthYear = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid birth year. Please enter a valid number.");
            }
        }
    
        // Create the new SupermanJr and return
        return new SupermanJr(costumeColor, xRay, strengthLevel, firstName, lastName, birthYear, training, experienceLevel);
    }
    
    public static Person addSuperwomen() {
        Scanner scanner = new Scanner(System.in);
        String firstName, lastName, costumeColor;
        boolean canFly = false;
        int speed = 0, birthYear = 0;
    
        // Input for firstName, lastName, and costumeColor
        System.out.println("Enter first name:");
        firstName = scanner.nextLine();
        
        System.out.println("Enter last name:");
        lastName = scanner.nextLine();
        
        System.out.println("Enter costume color:");
        costumeColor = scanner.nextLine();
        
        // Input validation for flying ability (boolean)
        while (true) {
            System.out.println("Enter true or false for flying ability:");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("true")) {
                canFly = true;
                break;
            } else if (input.equals("false")) {
                canFly = false;
                break;
            } else {
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
            }
        }
    
        // Input validation for speed level (int)
        while (true) {
            System.out.println("Enter speed level:");
            try {
                speed = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid speed level. Please enter a valid number.");
            }
        }
    
        // Input validation for birth year (int)
        while (true) {
            System.out.println("Enter birth year:");
            try {
                birthYear = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid birth year. Please enter a valid number.");
            }
        }
    
        // Create the new Superwoman and return
        return new Superwomen(costumeColor, canFly, speed, firstName, lastName, birthYear);
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Team team = new Team("Heros");  // Create an instance of the Team class
        Main mainProgram = new Main();  // Create an instance of the current class to call createDefault()

        while (true) {
            // Print the menu
            System.out.println("");
            System.out.println("1) Add 5 pre-defined persons (all different Person types should be added) to the team");
            System.out.println("2) Print the team and its members");
            System.out.println("3) Remove all from the team");
            System.out.println("4) Create a new Person and add to the team");
            System.out.println("5) Exit");
            System.out.println("Enter your choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    // Add 5 pre-defined persons to the team
                    ArrayList<Person> dummyList = mainProgram.createDefault();  // Call the createDefault method
                    for (Person person : dummyList) {
                        team.addMember(person);  // Add each person to the team
                    }
                    System.out.println("5 pre-defined persons have been added to the team.");
                    break;

                case "2":
                    // Print the team and its members
                    if (team.getAll().isEmpty()) {
                        System.out.println("The team has no members.");
                    } else {
                        System.out.println("Team members:");
                        for (Person person : team.getAll()) {
                            System.out.println(person);
                        }
                    }
                    break;

                case "3":
                    // Remove all persons from the team
                    team.removeAll();
                    System.out.println("All members have been removed from the team.");
                    break;

                case "4":
                    // Create a new Person and add to the team
                    System.out.println("Enter Person, Superman, Superwomen or SupermanJr to create a disired charachter");
                    String addedType = scanner.nextLine();
                    if(addedType.equals("Person")){
                    Person newPerson = addPerson();
                    team.addMember(newPerson);
                    System.out.println("New person has been added to the team.");
                    } else if(addedType.equals("Superman")){
                    Person newPerson = addSuperman();
                    team.addMember(newPerson);
                    System.out.println("A new legend has been born.");
                    } else if(addedType.equals("Superwomen")){
                        Person newPerson = addSuperwomen();
                        team.addMember(newPerson);
                        System.out.println("A new legend has been born.");
                    } else if(addedType.equals("SupermanJr")){
                        Person newPerson = addSupermanJr();
                        team.addMember(newPerson);
                        System.out.println("A new legend has been born.");
                    }
                    break;
                case "5":
                    System.exit(0);
                    break;

                default:
                    // Handle invalid input
                    System.out.println("Incorrect input. Please choose one of the options.");
                    break;
            }
        }
    }
}
