package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Action {

    // Create an empty map
    public static Tile[][] creatEmptyMap() {
        Map map = new Map(10, 10);
        Tile[][] mapList = map.creatMap();
        //map.printMap(mapList);
        return mapList;
    }

    // Get random coordinates for placing objects
    public static ArrayList<Integer> getRandomCoordinates(Tile[][] map) {
        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random();
        while (true) {
            int x = rand.nextInt(10);
            int y = rand.nextInt(10);
            if (map[x][y].getObject() == null) {  // Check if the tile is empty
                list.add(x);
                list.add(y);
                return list;
            }
        }
    }

    // Generate an object of a specified type using reflection
    public static GameObjects getObjectFromType(Class<? extends GameObjects> objectType, int x, int y) {
        try {
            return objectType.getConstructor(int.class, int.class).newInstance(x, y);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Generate 10 random objects ensuring that all types are included
    public static void get10RandomObjects(Tile[][] map) {
        ArrayList<GameObjects> objects = new ArrayList<>();
        Random rand = new Random();

        // Step 1: Create a list of all object types (Dog, Cat, Fox, Rock, Tree, Bush)
        ArrayList<Class<? extends GameObjects>> objectTypes = new ArrayList<>();
        objectTypes.add(Dog.class);
        objectTypes.add(Cat.class);
        objectTypes.add(Fox.class);
        objectTypes.add(Rock.class);
        objectTypes.add(Tree.class);
        objectTypes.add(Bush.class);

        // Step 2: Add one of each type of object
        for (Class<? extends GameObjects> objectType : objectTypes) {
            ArrayList<Integer> coords = getRandomCoordinates(map);
            int x = coords.get(0);
            int y = coords.get(1);
            GameObjects obj = getObjectFromType(objectType, x, y);  // Create the object
            map[x][y].setObject(obj);  // Place it on the map
            objects.add(obj);  // Add it to the list
        }

        // Step 3: Add 4 more random objects
        for (int i = 0; i < 4; i++) {
            GameObjects randomObj = getRandomGameObject(map);  // Get a random object
            map[randomObj.getX()][randomObj.getY()].setObject(randomObj);  // Place it on the map
            objects.add(randomObj);  // Add it to the list
        }

        // Optional: Print the map after adding all 10 objects
        //Map.printMap(map);
    }

    // Generate a random GameObject and place it in a random position on the map
    public static GameObjects getRandomGameObject(Tile[][] map) {
        ArrayList<Integer> coords = getRandomCoordinates(map);
        int x = coords.get(0);
        int y = coords.get(1);
    
        Random rand = new Random();
        // List of all object types
        ArrayList<Class<? extends GameObjects>> objectTypes = new ArrayList<>();
        objectTypes.add(Dog.class);
        objectTypes.add(Cat.class);
        objectTypes.add(Fox.class);
        objectTypes.add(Rock.class);
        objectTypes.add(Tree.class);
        objectTypes.add(Bush.class);
    
        // Select a random object type
        Class<? extends GameObjects> randomType = objectTypes.get(rand.nextInt(objectTypes.size()));
        
        // Create and return the random object
        return getObjectFromType(randomType, x, y);
    }

    public static void removeObject(Tile[][] map){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the position of the animal you want to move:");
        System.out.print("Enter the x-position (1-10): ");
        int x = (scanner.nextInt() - 1);
        System.out.print("Enter the y-position (1-10): ");
        int y = (scanner.nextInt() - 1);
        scanner.nextLine();  // Clear the scanner buffer
    
        // Ensure coordinates are within bounds
        if (x >= 0 && x < 10 && y >= 0 && y < 10 && map[x][y].getObject() != null) {
            map[x][y].setObject(null);
        }
    }

    public static void removeAll(Tile[][] map){
        for(int i = 0; i < map.length; i++){
            for( int x = 0; x < map[i].length; x++){
                map[i][x].setObject(null);
            }
        }
    }
    public static void getAllObject(Tile[][] map) {
        int dogCount = 0;
        int catCount = 0;
        int foxCount = 0;
        int rockCount = 0;
        int treeCount = 0;
        int bushCount = 0;
    
        // Iterate through the map
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                GameObjects obj = map[i][j].getObject();  // Get the object at current tile
                if (obj != null) {
                    // Check the object's type using `instanceof`
                    if (obj instanceof Dog) {
                        dogCount++;
                    } else if (obj instanceof Cat) {
                        catCount++;
                    } else if (obj instanceof Fox) {
                        foxCount++;
                    } else if (obj instanceof Rock) {
                        rockCount++;
                    } else if (obj instanceof Tree) {
                        treeCount++;
                    } else if (obj instanceof Bush) {
                        bushCount++;
                    }
                }
            }
        }
    
        // Print the counts of each object
        System.out.println("Dog count: " + dogCount);
        System.out.println("Cat count: " + catCount);
        System.out.println("Fox count: " + foxCount);
        System.out.println("Rock count: " + rockCount);
        System.out.println("Tree count: " + treeCount);
        System.out.println("Bush count: " + bushCount);
    }
    
    
    public static void moveAnimale(Tile[][] map){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the position of the animal you want to move:");
        System.out.print("Enter the x-position (1-10): ");
        int x = (scanner.nextInt() - 1);
        System.out.print("Enter the y-position (1-10): ");
        int y = (scanner.nextInt() - 1);
        scanner.nextLine();  // Clear the scanner buffer
    
        // Ensure coordinates are within bounds
        if (x >= 0 && x < 10 && y >= 0 && y < 10 && map[x][y].getObject() != null) {
            GameObjects selectedObject = map[x][y].getObject();
    
            // Check if the object is movable
            if (selectedObject.isMovable()) {
                System.out.println("Where do you want to move the animal?");
                System.out.print("Enter the new x-position (1-10): ");
                int newX = (scanner.nextInt() - 1);
                System.out.print("Enter the new y-position (1-10): ");
                int newY = (scanner.nextInt() - 1);
                scanner.nextLine();  // Clear the scanner buffer again
    
                // Ensure the new coordinates are within bounds and the target position is empty
                if (newX >= 0 && newX < 10 && newY >= 0 && newY < 10 && map[newX][newY].getObject() == null) {
                    // Move the object by updating its coordinates
                    selectedObject.setX(newX);
                    selectedObject.setY(newY);
    
                    // Remove the object from the original tile
                    map[x][y].setObject(null);
                    // Place it in the new position
                    map[newX][newY].setObject(selectedObject);
    
                    System.out.println("Animal moved successfully!");
                } else {
                    System.out.println("Invalid target position or it's already occupied!");
                }
            } else {
                System.out.println("The selected object cannot be moved.");
            }
        } else {
            System.out.println("Invalid position or no object found at the given coordinates.");
        }
    }

    public static void getAllInfo(Tile[][] map) {
        // Iterate through the map
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                GameObjects obj = map[i][j].getObject();  // Get the object at current tile
                if (obj != null) {
                    // Extract object details
                    int xPos = obj.getX();
                    int yPos = obj.getY();
                    String symbol = obj.getSymbol();
                    String sound = obj.getSound();
                    String objectType = obj.getClass().getSimpleName();  // Get the object class name
                    
                    // Print the details in a structured way
                    System.out.println("Object: " + objectType + " (Symbol: " + symbol + ")");
                    System.out.println("Location: [x=" + xPos + ", y=" + yPos + "]");
                    System.out.println("Sound: " + sound);
                    System.out.println("-------------------------------------");
                }
            }
        }
    }

    public static void printAllObjectsAsJson(Tile[][] map) {
        System.out.println("[");  // Start of the JSON array
        
        boolean firstObject = true; // To handle comma separation correctly
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                GameObjects obj = map[i][j].getObject();  // Get the object at current tile
                
                if (obj != null) {
                    if (!firstObject) {
                        System.out.println(",");  // Comma between JSON objects
                    }
                    firstObject = false;
                    
                    // Get the object's details
                    String objectType = obj.getClass().getSimpleName();
                    String symbol = obj.getSymbol();
                    int xPos = obj.getX();
                    int yPos = obj.getY();
                    String sound = obj.getSound();
                    
                    // Print in JSON format
                    System.out.println("  {");
                    System.out.println("    \"type\": \"" + objectType + "\",");
                    System.out.println("    \"symbol\": \"" + symbol + "\",");
                    System.out.println("    \"position\": { \"x\": " + xPos + ", \"y\": " + yPos + " },");
                    System.out.println("    \"sound\": \"" + sound + "\"");
                    System.out.print("  }");
                }
            }
        }
        
        System.out.println("\n]");  // End of the JSON array
    }
    
    
}
