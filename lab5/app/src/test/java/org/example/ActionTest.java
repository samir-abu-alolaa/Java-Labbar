package org.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ActionTest {
    private final String folderName = "data";
    private String currentPath;
    private String folderPath;

    @BeforeEach
    public void setUp() {
        // Use File.separator for platform independence
        String currentPath = System.getProperty("user.dir");
        folderPath = currentPath + File.separator + "src" + File.separator + 
                     "main" + File.separator + "resources" + File.separator + folderName;

        // Print paths for debugging
        System.out.println("Folder Path: " + folderPath);

        // Clean up folder before each test
        File folder = new File(folderPath);
        if (folder.exists()) {
            Action.deleteAllFilesInFolder(); // Clean up existing files
            System.out.println("Cleaned existing files in folder: " + folderPath);
        } else {
            boolean folderCreated = folder.mkdir(); // Create the folder if it doesn't exist
            if (folderCreated) {
                System.out.println("Created new folder: " + folderPath);
            } else {
                System.out.println("Failed to create folder: " + folderPath);
            }
        }
    }

    @AfterEach
    public void tearDown() {
        Action.deleteAllFilesInFolder(); // Clean up after each test
        System.out.println("Cleaned up files after test.");
    }

    @Test
    public void testCreateFolder() {
        // Attempt to create the folder
        Action.createFolder();

        // Verify if the folder was created successfully
        File folder = new File(folderPath);
        boolean folderExists = folder.exists();
        System.out.println("Folder exists after creation attempt: " + folderExists + " at " + folderPath);

        // Optionally, you can assert the folder creation
        assertTrue(folderExists, "Folder should exist after creation.");
    }

    // Test method for createFiveReceipts()
    @Test
    public void testCreateFiveReceipts() {
        Action.createFiveReceipts();
        
        for (int i = 0; i < 5; i++) {
            File receipt = new File(folderPath + File.separator + "receipt" + (i+1) + ".txt");
            assertTrue(receipt.exists(), "Receipt 'receipt" + (i+1) + ".txt' should be created.");
        }
    }

    // Test method for deleteAllFilesInFolder()
    @Test
    public void testDeleteAllFilesInFolder() {
        Action.createFiveReceipts(); // Create files to delete
        Action.deleteAllFilesInFolder();
        
        File folder = new File(folderPath);
        assertTrue(folder.exists() && folder.isDirectory(), "'data' folder should exist after deletion of files.");
        
        // Check if the folder is empty
        File[] files = folder.listFiles();
        assertNotNull(files);
        assertEquals(0, files.length, "All files should be deleted from the 'data' folder.");
    }

    // Test method for readAllReceipts()
    @Test
    public void testReadAllReceipts() {
        Action.createFiveReceipts();
        Action.readAllReceipts();

        // Check if all receipt files still exist (after reading)
        for (int i = 0; i < 5; i++) {
            File receipt = new File(folderPath + File.separator + "receipt" + i + ".txt");
            assertTrue(receipt.exists(), "Receipt 'receipt" + i + ".txt' should still exist after reading.");
        }
    }

    // Test method for viewRecipt()
    @Test
    public void testViewReceipt() {
        Action.createFiveReceipts();
        Action.viewRecipt(1); // Viewing the first receipt

        File receipt = new File(folderPath + File.separator + "receipt0.txt");
        assertTrue(receipt.exists(), "Receipt 'receipt0.txt' should exist.");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(receipt))) {
            String line = reader.readLine();
            assertEquals("Receipt Number: 1", line, "The first line should match 'Receipt Number: 1'.");
        } catch (IOException e) {
            fail("Error reading the receipt file: " + e.getMessage());
        }
    }

    // Test method for createRecipt()
    
    @Test
public void testCreateReceipt() {
    // Simulate the user input for the receipt fields
    String simulatedInput = "1\nIbuprofen\n130\n5\n200mg\n";
    ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
    System.setIn(in); // Set the input stream to our simulated input

    // Now call the method that expects user input
    Action.createRecipt();

    // Verify the new receipt exists (assuming receipt number starts from 1)
    File newReceipt = new File(folderPath + File.separator + "receipt1.txt");
    assertTrue(newReceipt.exists(), "New receipt should be created.");

    // Optionally, verify the contents of the newly created receipt
    try (BufferedReader reader = new BufferedReader(new FileReader(newReceipt))) {
        assertEquals("Receipt Number: 1", reader.readLine(), "The receipt number should be 1.");
        assertEquals("Medicine Name: Ibuprofen", reader.readLine(), "The medicine name should be 'Ibuprofen'.");
        assertEquals("Price: 130.0 Sek", reader.readLine(), "The price should be '130'.");
        assertEquals("Quantity Available: 5", reader.readLine(), "The quantity should be '5'.");
        assertEquals("Dosage: 200mg", reader.readLine(), "The dosage should be '200mg'.");
    } catch (IOException e) {
        fail("Error reading the receipt file: " + e.getMessage());
    } finally {
        // Reset System.in to its original state after the test
        System.setIn(System.in);
    }
}

    
@Test
public void testUpdateReceipt() {
    // Simulate the user input for updating medicine name and exiting the update loop
    String simulatedInput = "medicine\nnew medicin\nno\n"; // Update 'medicine' to 'new medicin' and then exit
    ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
    System.setIn(in); // Set the input stream to our simulated input

    // Create initial receipts
    Action.createFiveReceipts(); // Create five receipts first
    
    // Now update the receipt with receipt number 1 (which corresponds to receipt1.txt)
    Action.updateRecipt(1); // Update receipt number 1 (receipt1.txt)

    // Verify the updated receipt exists
    File receipt = new File(folderPath + File.separator + "receipt1.txt");
    assertTrue(receipt.exists(), "Updated receipt should exist.");

    // Verify the updated content of the receipt
    try (BufferedReader reader = new BufferedReader(new FileReader(receipt))) {
        assertEquals("Receipt Number: 1", reader.readLine(), "The receipt number should still be 1.");
        assertEquals("Medicine Name: new medicin", reader.readLine(), "The medicine name should be updated to 'new medicin'.");
        assertEquals("Price: 20.0 Sek", reader.readLine(), "The price should remain '20.0 Sek'.");
        assertEquals("Quantity Available: 3", reader.readLine(), "The quantity should remain '3'.");
        assertEquals("Dosage: 20mg", reader.readLine(), "The dosage should remain '20mg'.");
    } catch (IOException e) {
        fail("Error reading the updated receipt file: " + e.getMessage());
    } finally {
        // Reset System.in to its original state after the test
        System.setIn(System.in);
    }
}


    // Test method for removeRecipt()
    @Test
    public void testRemoveReceipt() {
        Action.createFiveReceipts();
        
        // Remove a receipt by number
        Action.removeRecipt(0);

        // Verify that the receipt no longer exists
        File receipt = new File(folderPath + File.separator + "receipt0.txt");
        assertFalse(receipt.exists(), "Receipt 'receipt0.txt' should be deleted.");
    }
    @Test
    public void testMenuDisplay() {
        // Set up to capture the output of System.out
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Menu.displayMenu(); // A new method to print the menu instead of the infinite loop

        // Restore original System.out
        System.setOut(originalOut);

        // Get the captured output and check for expected menu options
        String output = outputStream.toString();

        // Verify that the output contains all expected menu items
        assertTrue(output.contains("1. Remove all receipts"), "Menu should contain option to remove all receipts.");
        assertTrue(output.contains("2. Initiate the receipt database with 5 example-receipts"), "Menu should contain option to initiate receipts.");
        assertTrue(output.contains("3. View all receipts"), "Menu should contain option to view all receipts.");
        assertTrue(output.contains("4. View a receipt"), "Menu should contain option to view a receipt.");
        assertTrue(output.contains("5. Add a new receipt"), "Menu should contain option to add a new receipt.");
        assertTrue(output.contains("6. Update/change a receipt"), "Menu should contain option to update/change a receipt.");
        assertTrue(output.contains("7. Remove a receipt"), "Menu should contain option to remove a receipt.");
        assertTrue(output.contains("8. Export all receipts as JSON"), "Menu should contain option to export receipts as JSON.");
        assertTrue(output.contains("9. Export all receipts as CSV"), "Menu should contain option to export receipts as CSV.");
    }

    @Test
    void checkJson(){
        String simulatedInput = "8\n"; // Update 'medicine' to 'new medicin' and then exit
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in); // Set the input stream to our simulated input

    // Create initial receipts
        Action.createJson();

        File receipt = new File(folderPath + File.separator + "receipts.json");
        assertTrue(receipt.exists(), "Receipt 'receipts.json' should exist.");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(receipt))) {
            String line = reader.readLine();
            assertEquals("{", line, "The first line should match {'.");
        } catch (IOException e) {
            fail("Error reading the receipt file: " + e.getMessage());
        }
    }
    @Test
    void checkCSV(){
        String simulatedInput = "9\n"; // Update 'medicine' to 'new medicin' and then exit
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in); // Set the input stream to our simulated input

    // Create initial receipts
        Action.createCSV();

        File receipt = new File(folderPath + File.separator + "receipts.csv");
        assertTrue(receipt.exists(), "Receipt 'receipts.csv' should exist.");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(receipt))) {
            String line = reader.readLine();
            assertEquals("Receipt Number,Medicine Name,Price,Quantity Available,Dosage", line, "The first line should match Recipt Number,Medicine Name,Price,Quantity Available,Dosage'.");
        } catch (IOException e) {
            fail("Error reading the receipt file: " + e.getMessage());
        }
    }
}
