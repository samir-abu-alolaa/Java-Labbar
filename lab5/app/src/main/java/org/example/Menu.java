package org.example;

import java.util.Scanner;

public class Menu {

    public static void displayMenu(){
        System.out.println("1. Remove all receipts");
        System.out.println("2. Initiate the receipt database with 5 example-receipts");
        System.out.println("3. View all receipts");
        System.out.println("4. View a receipt");
        System.out.println("5. Add a new receipt");
        System.out.println("6. Update/change a receipt");
        System.out.println("7. Remove a receipt");
        System.out.println("8. Export all receipts as JSON");
        System.out.println("9. Export all receipts as CSV");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Action.createFolder(); // creat the data file
        while(true){
            displayMenu();
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    Action.deleteAllFilesInFolder();
                    break;
                case 2:
                    // creat a method that create five files with medicin
                    Action.createFiveReceipts();;
                    break;
                case 3:
                    Action.readAllReceipts();
                    // Creat a folder that contains all files and loop through it
                    break;
                case 4:
                    // In all files create a uniqe Id that can be traced
                    System.out.println("Enter the nummber of the wanted recipt");
                    int reciptNr = scanner.nextInt();
                    Action.viewRecipt(reciptNr);
                    break;
                case 5:
                    Action.createRecipt();
                    // Create a function that ask about all info to create a file
                    break;
                case 6:
                    System.out.println("Enter the number of the recipt");
                    int receptNr = scanner.nextInt();
                    Helper.updateRecipt(receptNr);
                    // Create a method that can write inside an existing file
                    break;
                case 7:
                    System.out.println("Enter the number to delet the recipt");
                    int fileNr = scanner.nextInt();
                    Helper.removeRecipt(fileNr);
                    // delet a file
                    break;
                case 8:
                    // loop throgh folder and create json
                    Helper.createJson();
                    break;
                case 9:
                    Helper.createCSV();
                    break;
                default:
                    break;
            }
        
        }
    }
}
