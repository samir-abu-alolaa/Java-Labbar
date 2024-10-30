package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Helper {
    
    public static void createJson() {
    String folderPath = Action.getDataFolderPath();
    File jsonFile = new File(folderPath + File.separator + "receipts.json");

    StringBuilder jsonOutput = new StringBuilder();
    jsonOutput.append("{\n"); // Start of the JSON

    File[] files = getReceiptFiles(); // Get all receipt files

    if (files.length > 0) {
        int fileCount = 0;
        for (File file : files) {
            if (fileCount > 0) {
                jsonOutput.append(",\n"); // Separate objects with a comma
            }
            jsonOutput.append("  \"" + file.getName() + "\": {\n");

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                boolean firstLine = true;
                while ((line = reader.readLine()) != null) {
                    // Assuming each line follows the format "Key: Value"
                    String[] parts = line.split(": ", 2);
                    if (parts.length == 2) {
                        String key = parts[0].trim();
                        String value = parts[1].trim();

                        // Add comma for all but the last key-value pair
                        if (!firstLine) {
                            jsonOutput.append(",\n");
                        }

                        jsonOutput.append("    \"" + key + "\": \"" + value + "\"");
                        firstLine = false;
                    }
                }
                jsonOutput.append("\n  }");
            } catch (IOException e) {
                System.out.println("An error occurred while reading the file: " + e.getMessage());
            }
            fileCount++;
        }
    }
    jsonOutput.append("\n}"); // End of the JSON

    // Write the JSON output to a file
    try (FileWriter writer = new FileWriter(jsonFile)) {
        writer.write(jsonOutput.toString());
        System.out.println("JSON file created at: " + jsonFile.getAbsolutePath());
    } catch (IOException e) {
        System.out.println("An error occurred while writing the JSON file: " + e.getMessage());
    }
}


public static void createCSV() {
    String folderPath = Action.getDataFolderPath();
    File csvFile = new File(folderPath + File.separator + "receipts.csv");
    // Use StringBuilder to construct CSV content
    StringBuilder csvOutput = new StringBuilder();

    // Add the header for the CSV
    csvOutput.append("Receipt Number,Medicine Name,Price,Quantity Available,Dosage\n");

    File[] files = getReceiptFiles(); // Get all receipt files

    if (files.length > 0) {
        for (File file : files) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                String receiptNumber = "";
                String medicineName = "";
                String price = "";
                String quantity = "";
                String dosage = "";

                while ((line = reader.readLine()) != null) {
                    // Assuming each line follows the format "Key: Value"
                    String[] parts = line.split(": ", 2);
                    if (parts.length == 2) {
                        String key = parts[0].trim();
                        String value = parts[1].trim();

                        // Store values based on key
                        switch (key) {
                            case "Receipt Number":
                                receiptNumber = value;
                                break;
                            case "Medicine Name":
                                medicineName = value;
                                break;
                            case "Price":
                                price = value;
                                break;
                            case "Quantity Available":
                                quantity = value;
                                break;
                            case "Dosage":
                                dosage = value;
                                break;
                        }
                    }
                }

                // Add the receipt details as a new line in the CSV
                csvOutput.append(receiptNumber)
                        .append(",")
                        .append(medicineName)
                        .append(",")
                        .append(price)
                        .append(",")
                        .append(quantity)
                        .append(",")
                        .append(dosage)
                        .append("\n");

            } catch (IOException e) {
                System.out.println("An error occurred while reading the file: " + e.getMessage());
            }
        }
    }

    // Write the CSV output to the file
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
        writer.write(csvOutput.toString());
        System.out.println("CSV file created at: " + csvFile.getAbsolutePath());
    } catch (IOException e) {
        System.out.println("An error occurred while writing the CSV file: " + e.getMessage());
    }
}
    public static void updateRecipt(int recNr) {
        String filePath = Action.getDataFolderPath() + File.separator + "receipt" + recNr + ".txt";
    
        File file = new File(filePath);
    
        // Check if the receipt file exists
        if (!file.exists()) {
            System.out.println("Receipt " + recNr + " does not exist.");
            return;
        }
    
        Scanner scanner = new Scanner(System.in);
    
        String medicineName = "";
        double price = 0;
        int quantity = 0;
        String dosage = "";
    
        // Read the current contents of the receipt
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Medicine Name: ")) {
                    medicineName = line.split(": ")[1];
                } else if (line.startsWith("Price: ")) {
                    price = Double.parseDouble(line.split(": ")[1].replace(" Sek", ""));
                } else if (line.startsWith("Quantity Available: ")) {
                    quantity = Integer.parseInt(line.split(": ")[1]);
                } else if (line.startsWith("Dosage: ")) {
                    dosage = line.split(": ")[1];
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the receipt: " + e.getMessage());
        }
    
        // Update loop: User chooses what to update
        while (true) {
            System.out.println("What would you like to update? (medicine, price, quantity, dosage, or type 'exit' to quit)");
            String fieldToUpdate = scanner.nextLine().toLowerCase();
    
            switch (fieldToUpdate) {
                case "medicine":
                    System.out.println("Enter new Medicine Name: ");
                    medicineName = scanner.nextLine();
                    break;
    
                case "price":
                    System.out.println("Enter new Price: ");
                    price = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline
                    break;
    
                case "quantity":
                    System.out.println("Enter new Quantity: ");
                    quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    break;
    
                case "dosage":
                    System.out.println("Enter new Dosage: ");
                    dosage = scanner.nextLine();
                    break;
    
                case "exit":
                    System.out.println("Exiting update process.");
                    return;
    
                default:
                    System.out.println("Invalid input. Please enter 'medicine', 'price', 'quantity', 'dosage', or 'exit'.");
                    continue;
            }
    
            // After each update, prompt to either continue updating or stop
            System.out.println("Do you want to update anything else? (yes/no)");
            String answer = scanner.nextLine().toLowerCase();
            if (answer.equals("no")) {
                break;
            }
        }
    
        // Write the updated details back to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("Receipt Number: " + recNr);
            writer.newLine();
            writer.write("Medicine Name: " + medicineName);
            writer.newLine();
            writer.write("Price: " + price + " Sek");
            writer.newLine();
            writer.write("Quantity Available: " + quantity);
            writer.newLine();
            writer.write("Dosage: " + dosage);
            writer.newLine();
    
            writer.flush(); // Ensure everything is written to the file
            System.out.println("Receipt " + recNr + " updated successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while updating the receipt: " + e.getMessage());
        }
    }
    public static File getReceiptFile(int receiptNr) {
        File folder = new File(Action.getDataFolderPath());
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles((dir, name) -> name.startsWith("receipt" + receiptNr) && name.endsWith(".txt"));
            if (files != null && files.length > 0) {
                return files[0];
            }
        }
        return null; // Return null if no matching file is found
    }

    public static File[] getReceiptFiles() {
        File folder = new File(Action.getDataFolderPath());
        if (folder.exists() && folder.isDirectory()) {
            // Return all files that match the pattern "receipt*.txt"
            return folder.listFiles((dir, name) -> name.startsWith("receipt") && name.endsWith(".txt"));
        }
        return new File[0]; // Return an empty array if no files are found
    }
    

    public static void removeRecipt(int reciptNr) {
        File file = getReceiptFile(reciptNr);
    
        if (file != null) {
            if (file.delete()) {
                System.out.println("Receipt " + reciptNr + " deleted successfully.");
            } else {
                System.out.println("Failed to delete receipt " + reciptNr + ".");
            }
        } else {
            System.out.println("Receipt " + reciptNr + " not found.");
        }
    }
}
