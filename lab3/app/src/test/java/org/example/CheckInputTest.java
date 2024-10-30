package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CheckInputTest {
    Tile[][] map = Action.creatEmptyMap();
    @Test void testCreatEmptyMap(){
        assertNotNull(map);
        assertEquals(10, map.length);
        assertEquals(10, map[0].length);

        for(Tile[] row : map){
            for(Tile tile: row){
                assertNull(tile.getObject());
            }
        }
    }
    
    @Test
    void checkMoveAnimalWithMockedInput() {
        // Arrange: Create an empty map and place a Dog at (1, 1)
        Tile[][] map = Action.creatEmptyMap();
        Dog dog = new Dog(1, 1);
        map[1][1].setObject(dog);

        // Simulate user input: move the dog from (2, 2) to (4, 4)
        String simulatedInput = "2\n2\n4\n4\n";  // Input for oldX, oldY, newX, newY (1-based index)
        InputStream originalIn = System.in;      // Save original System.in
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));  // Mock input

        try {
            // Act: Call the method that relies on Scanner input
            Action.moveAnimale(map);

            // Assert: Check if the dog has been moved successfully
            assertNull(map[1][1].getObject(), "Old position should be empty");
            assertNotNull(map[3][3].getObject(), "New position should contain the dog");
            assertTrue(map[3][3].getObject() instanceof Dog, "The object at the new position should be a Dog");

            // Check the dog's new coordinates
            assertEquals(3, dog.getX());
            assertEquals(3, dog.getY());

        } finally {
            // Reset System.in to its original state
            System.setIn(originalIn);
        }
    }

    @Test void checkRemoveAll(){
        Tile[][] map = Action.creatEmptyMap();
        Action.get10RandomObjects(map);
        Action.removeAll(map);
        for (Tile[] row : map) {
            for (Tile tile : row) {
                assertNull(tile.getObject());
            }
        }
    }

    @Test
    void testGetAllObject() {
        // Step 1: Create a test map
        Tile[][] map = new Tile[10][10];
        
        // Initialize the map with empty tiles
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                map[i][j] = new Tile(i, j, null);
            }
        }

        // Step 2: Add known objects to the map
        map[0][0].setObject(new Dog(0, 0));
        map[1][1].setObject(new Cat(1, 1));
        map[2][2].setObject(new Fox(2, 2));
        map[3][3].setObject(new Rock(3, 3));
        map[4][4].setObject(new Tree(4, 4));
        map[5][5].setObject(new Bush(5, 5));

        // Step 3: Capture the console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;  // Store the original System.out
        System.setOut(new PrintStream(outputStream));  // Redirect System.out to our stream
        
        // Step 4: Call the method
        Action.getAllObject(map);
        
        // Step 5: Verify the output
        String expectedDogCount = "Dog count: 1";
        String expectedCatCount = "Cat count: 1";
        String expectedFoxCount = "Fox count: 1";
        String expectedRockCount = "Rock count: 1";
        String expectedTreeCount = "Tree count: 1";
        String expectedBushCount = "Bush count: 1";
        
        // Get the actual output and restore System.out
        String actualOutput = outputStream.toString();
        System.setOut(originalOut);  // Reset the System.out back to normal

        // Split the output into lines
        String[] outputLines = actualOutput.split("\n");

        // Assert that each line matches the expected output
        assertEquals(expectedDogCount, outputLines[0].trim());
        assertEquals(expectedCatCount, outputLines[1].trim());
        assertEquals(expectedFoxCount, outputLines[2].trim());
        assertEquals(expectedRockCount, outputLines[3].trim());
        assertEquals(expectedTreeCount, outputLines[4].trim());
        assertEquals(expectedBushCount, outputLines[5].trim());
    }

    @Test
void testGetAllInfo() {
    // Step 1: Create a test map
    Tile[][] map = Action.creatEmptyMap();

    // Step 2: Add known objects to the map
    Dog dog = new Dog(1, 1);  // Assuming Dog constructor takes x, y
    Cat cat = new Cat(2, 2);
    Fox fox = new Fox(3, 3);
    
    map[1][1].setObject(dog);
    map[2][2].setObject(cat);
    map[3][3].setObject(fox);

    // Step 3: Capture the console output
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;  // Store the original System.out
    System.setOut(new PrintStream(outputStream));  // Redirect System.out to our stream
    
    // Step 4: Call the method
    Action.getAllInfo(map);
    
    // Step 5: Get the actual output and restore System.out
    String actualOutput = outputStream.toString();
    System.setOut(originalOut);  // Reset the System.out back to normal

    // Step 6: Expected output as a string
    String expectedOutput = 
        "Object: Dog (Symbol: 🐶)\n" +
        "Location: [x=1, y=1]\n" +
        "Sound: Wouf\n" +
        "-------------------------------------\n" +
        "Object: Cat (Symbol: 🐱)\n" +
        "Location: [x=2, y=2]\n" +
        "Sound: Meow\n" +
        "-------------------------------------\n" +
        "Object: Fox (Symbol: 🦊)\n" +
        "Location: [x=3, y=3]\n" +
        "Sound: Weaah\n" +
        "-------------------------------------\n";

    // Step 7: Split both expected and actual output into arrays of strings by line
    String[] expectedArray = expectedOutput.split("\n");
    String[] actualArray = actualOutput.split("\n");

    // Step 8: Compare each line of the arrays after trimming to remove extra spaces
    assertEquals(expectedArray.length, actualArray.length, "The number of lines in the output do not match.");

    for (int i = 0; i < expectedArray.length; i++) {
        assertEquals(expectedArray[i].trim(), actualArray[i].trim(), "Line " + (i + 1) + " does not match.");
    }
}
@Test
void checkPrintAllAsJson() {
    // Step 1: Create a test map
    Tile[][] map = Action.creatEmptyMap();

    // Step 2: Add a Dog object to the map
    Dog dog = new Dog(0, 0);
    map[0][0].setObject(dog);

    // Step 3: Expected JSON output
    String expectedString = "[\n {\r\n" + //
        "    \"type\": \"Dog\",\r\n" + //
        "    \"symbol\": \"🐶\",\r\n" + //
        "    \"position\": { \"x\": 0, \"y\": 0 },\r\n" + //
        "    \"sound\": \"Wouf\"\r\n" + //
        "  }\n ]";

    // Step 4: Capture the actual output
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;  // Store the original System.out
    System.setOut(new PrintStream(outputStream));  // Redirect System.out to our stream

    // Call the method that prints the JSON
    Action.printAllObjectsAsJson(map);

    // Get the actual output and restore System.out
    String actualOutput = outputStream.toString();
    System.setOut(originalOut);  // Reset System.out back to normal

    // Step 5: Split the strings into lines for comparison
    String[] expectedStrings = expectedString.split("\n");
    String[] actualStrings = actualOutput.split("\n");

    // Step 6: Filter out empty lines from both expected and actual outputs
    List<String> filteredExpected = Arrays.stream(expectedStrings)
        .map(String::trim)  // Remove leading/trailing spaces
        .filter(line -> !line.isEmpty())  // Ignore empty lines
        .toList();
    
    List<String> filteredActual = Arrays.stream(actualStrings)
        .map(String::trim)  // Remove leading/trailing spaces
        .filter(line -> !line.isEmpty())  // Ignore empty lines
        .toList();

    // Debugging: Print both filtered arrays to identify differences
    System.out.println("Filtered Expected Lines:");
    filteredExpected.forEach(System.out::println);

    System.out.println("Filtered Actual Lines:");
    filteredActual.forEach(System.out::println);

    // Step 7: Assert the filtered arrays are equal
    assertEquals(filteredExpected.size(), filteredActual.size(), "The number of non-empty lines does not match.");

    for (int i = 0; i < filteredExpected.size(); i++) {
        assertEquals(filteredExpected.get(i), filteredActual.get(i), "Line " + (i + 1) + " does not match.");
    }
}

}
