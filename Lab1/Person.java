import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

public class Person {
    private String firstName;
    private String lastName;
    private int birthYear; 

    // Constructor to initialize a Person object
    public Person(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public void setBirthYear(int newBirthYear) {
        this.birthYear = newBirthYear;
    }

    // Method to generate an MD5 hash from the person's details
    public String hashMd5() {
        try {
            String data = this.firstName + " " + this.lastName + " " + this.birthYear;
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(data.getBytes());
            byte[] digest = md.digest();
            String base64Hash = Base64.getEncoder().encodeToString(digest);
            return base64Hash;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Person: " + firstName + " " + lastName + ", born " + birthYear + " (turning " + (2024 - birthYear) + " this year), md5: " + hashMd5();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person person = null; // Variable to hold the created person object
        
        System.out.println("Enter p1 to create a person with default values, p2 to customize your person, or p3 to print details of the person.");

        while (true) {
            String input = scanner.nextLine().trim();

            if (input.equals("p1")) {
                System.out.println("A person is created with default values");
                person = new Person("John", "Doe", 1990); // Default values
                System.out.println(person);
            } else if (input.equals("p2")) {
                System.out.println("Your choice is " + input);
                System.out.println("Enter firstname, lastname and birth year of the person.");

                System.out.print("Enter the firstname: ");
                String inputFirstName = scanner.nextLine().trim();

                System.out.print("Enter the lastname: ");
                String inputLastName = scanner.nextLine().trim();

                System.out.print("Enter the birth year: ");
                int inputBirthYear = scanner.nextInt();
                scanner.nextLine();  // Consume the leftover newline

                person = new Person(inputFirstName, inputLastName, inputBirthYear);
                System.out.println(person);
            } else if (input.equals("p3")) {
                if (person != null) {
                    System.out.println("Your choice: " + input);
                    System.out.println(person); // Print details of the existing person
                } else {
                    System.out.println("No person has been created yet.");
                }
            } else {
                System.out.println("Invalid option. Please enter p1, p2, or p3.");
            }
        }
    }
}
