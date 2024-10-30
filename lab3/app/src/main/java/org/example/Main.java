package org.example;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tile[][] map = null;  // No map is created initially

        while (true) {
            // Display menu
            displayMenu();

            // Get user's choice
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    map = Action.creatEmptyMap();
                    System.out.println("Map printed:");
                    Map.printMap(map);
                    break;

                case "2":
                    if (map == null) {
                        System.out.println("Error: The forest (map) has not been created yet. Please select option 1 first.");
                    } else {
                        GameObjects obj = Action.getRandomGameObject(map);
                        map[obj.getX()][obj.getY()].setObject(obj);
                        System.out.println("Random object inserted:");
                        Map.printMap(map);
                    }
                    break;

                    case "3":
                    // Ensure map is created
                    if (map == null) {
                        System.out.println("Error: The forest (map) has not been created yet. Please select option 1 first.");
                    } else {
                        // Insert 10 random objects, ensuring all object types are included
                        Action.get10RandomObjects(map);  // Modify the map
                        System.out.println("10 random objects inserted:");
                        Map.printMap(map);  // Print updated map
                    }
                    break;

                case "4":
                    // Ensure map is created
                    if (map == null) {
                        System.out.println("Error: The forest (map) has not been created yet. Please select option 1 first.");
                    } else {
                        Action.moveAnimale(map);
                        Map.printMap(map);
                    }
                    break;

                case "5":
                    // Ensure map is created
                    if (map == null) {
                        System.out.println("Error: The forest (map) has not been created yet. Please select option 1 first.");
                    } else {
                        Action.removeObject(map);
                        System.out.println("The object has been removed.");
                        Map.printMap(map);
                    }
                    break;

                case "6":
                    // Ensure map is created
                    if (map == null) {
                        System.out.println("Error: The forest (map) has not been created yet. Please select option 1 first.");
                    } else {
                        Action.removeAll(map);
                        System.out.println("All object are removed");
                        Map.printMap(map);
                    }
                    break;

                case "7":
                    // Ensure map is created
                    if (map == null) {
                        System.out.println("Error: The forest (map) has not been created yet. Please select option 1 first.");
                    } else {
                        System.out.println("Objects in the forest:");
                        Action.getAllObject(map);
                        Map.printMap(map);
                    }
                    break;

                case "8":
                    // Ensure map is created
                    if (map == null) {
                        System.out.println("Error: The forest (map) has not been created yet. Please select option 1 first.");
                    } else {
                        System.out.println("Details of all objects:");
                        Action.getAllInfo(map);
                    }
                    break;

                case "9":
                    // Ensure map is created
                    if (map == null) {
                        System.out.println("Error: The forest (map) has not been created yet. Please select option 1 first.");
                    } else {
                        Action.printAllObjectsAsJson(map);
                    }
                    break;
                case "10":
                    System.out.println("Exiting the program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }

    // New method to display the menu
    public static void displayMenu() {
        System.out.println("1. Create a \"forest\" as a 10x10 area and print it out. It is empty to start with.");
        System.out.println("2. Insert a random object/animal with a random position.");
        System.out.println("3. Insert 10 random object/animal with a random position, ensure that all types of objects/animals are inserted.");
        System.out.println("4. Move an object/animal (if it supports it).");
        System.out.println("5. Remove an object/shape.");
        System.out.println("6. Remove all objects/animals.");
        System.out.println("7. Print all objects/animals in the forest.");
        System.out.println("8. Print all details on all \"objects\", including how they sound.");
        System.out.println("9. Print all details on all \"objects\", in a JSON format.");
        System.out.println("10. to exit the program.\n");
    }
}
