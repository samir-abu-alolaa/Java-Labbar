package task1;
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

}
