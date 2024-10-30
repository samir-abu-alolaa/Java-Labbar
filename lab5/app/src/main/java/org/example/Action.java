package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.io.*;


public class Action {

    public static String getDataFolderPath() {
        String currentPath = System.getProperty("user.dir");
        return currentPath + File.separator +"data";
    }

    // Method to create a folder named "data"
    public static void createFolder() {
        

        File file = new File(getDataFolderPath());

        boolean createdFile = file.mkdir();

        if (createdFile) {
            System.out.println("Folder 'data' created successfully.");
        } else {
            System.out.println("Folder 'data' already exists or could not be created.");
        }
    }

    // Method to create 5 receipts and write details into them
    public static void createFiveReceipts() {
        String filePath = getDataFolderPath() + File.separator;

        // Arrays of sample data
        String[] medicineNames = {"Ibuprofen", "Omparazol", "Ativan", "Alvedon", "Waran"};
        double[] prices = {130, 20, 200, 60, 300};
        int[] quantities = {5, 3, 10, 7, 1};
        String[] dosages = {"200mg", "20mg", "4mg", "500mg", "5mg"};

        // Loop to create 5 files and write data to each one
        for (int i = 0; i < 5; i++) {
            File newFile = new File(filePath + "receipt" + i + ".txt");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFile))) {
                boolean createdFile = newFile.createNewFile();

                if (!createdFile) {
                    System.out.println("File 'receipt" + i + ".txt' already exists, overwriting.");
                }

                // Writing the content to the file
                writer.write("Receipt Number: " + (i + 1));
                writer.newLine();
                writer.write("Medicine Name: " + medicineNames[i]);
                writer.newLine();
                writer.write("Price: " + prices[i]+ " Sek");
                writer.newLine();
                writer.write("Quantity Available: " + quantities[i]);
                writer.newLine();
                writer.write("Dosage: " + dosages[i]);
                writer.newLine();

                writer.flush(); // Flush the writer to ensure all data is written
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file: " + e.getMessage());
            }
        }
    }

    public static void deleteAllFilesInFolder() {
        String folderPath = getDataFolderPath();

        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.delete()) {
                        System.out.println(file.getName() + " was deleted.");
                    } else {
                        System.out.println("Failed to delete " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("The folder 'data' does not exist.");
        }
    }

    public static void readAllReceipts() {
 
        String folderPath = getDataFolderPath();

        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    // Ensure we are only reading receipt files
                    if (file.getName().startsWith("receipt") && file.getName().endsWith(".txt")) {
                        System.out.println("Reading file: " + file.getName());

                        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                            String line;
                            while ((line = reader.readLine()) != null) {
                                // Replace the colon with a dash to format the output
                                System.out.println(line);
                            }
                            System.out.println("**************************************");
                        } catch (IOException e) {
                            System.out.println("An error occurred while reading the file: " + e.getMessage());
                        }
                    }
                }
            }
        } else {
            System.out.println("The folder 'data' does not exist.");
        }
    }

    public static void viewRecipt(int reciptNr){
    
        File folder = new File(getDataFolderPath());
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                   if(file.getName().startsWith("receipt"+ reciptNr)){
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                        System.out.println();
                    } catch (IOException e) {
                        System.out.println("An error occurred while reading the file: " + e.getMessage());
                        }
                    } 
                }
            }

        }
    }



    public static void createRecipt() {

        String filePath = getDataFolderPath() +File.separator;

        // Create a Scanner object to get user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter receipt details
        System.out.println("Enter Receipt Number: ");
        int receiptNr = scanner.nextInt(); // Read receipt number
        scanner.nextLine(); // Clear the buffer

        System.out.println("Enter Medicine Name: ");
        String medicineName = scanner.nextLine(); // Read medicine name

        System.out.println("Enter Price: ");
        double price = scanner.nextDouble(); // Read price

        System.out.println("Enter Quantity: ");
        int quantity = scanner.nextInt(); // Read quantity
        scanner.nextLine(); // Clear the buffer

        System.out.println("Enter Dosage (e.g., 500mg): ");
        String dosage = scanner.nextLine(); // Read dosage

        // Create the new receipt file
        File newFile = new File(filePath + "receipt" + receiptNr + ".txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFile))) {
            // Create the file if it doesn't exist, otherwise overwrite
            boolean createdFile = newFile.createNewFile();

            if (!createdFile) {
                System.out.println("File 'receipt" + receiptNr + ".txt' already exists, overwriting.");
            }

            // Write the user input to the file
            writer.write("Receipt Number: " + receiptNr);
            writer.newLine();
            writer.write("Medicine Name: " + medicineName);
            writer.newLine();
            writer.write("Price: " + price + " Sek");
            writer.newLine();
            writer.write("Quantity Available: " + quantity);
            writer.newLine();
            writer.write("Dosage: " + dosage);
            writer.newLine();

            // Flush the writer to ensure all data is written to the file
            writer.flush();
            System.out.println("Receipt created successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file: " + e.getMessage());
        }
    }
}

