package task1;

import task1.Superwomen;
import task1.Superman;
import task1.Person;

public class TestMain {

    public static void main(String[] args) {
        // Create Person, Superman, and Superwomen objects
        Person per1 = new Person("Samir", "OLA", 2001);
        Superman sup1 = new Superman("Red", false, 20, "Clark", "Kent", 2001);
        Superwomen sup2 = new Superwomen("Blue", true, 40, "Lisa", "Ween", 1990);
        SupermanJr sup3 = new SupermanJr("Pink", true, 2, "Hassan", "Jamous", 2000, false, 1);

        
        // Print out their details using toString() method
        System.out.println("Person Details: " + per1.toString());
        System.out.println();
        System.out.println("Superman Details: " + sup1.toString());
        System.out.println();
        System.out.println("Superwomen Details: " + sup2.toString());
        System.out.println();
        System.out.println("SupermanJr Details: " +sup3.toString());
        System.out.println("");
        System.out.println(sup3.startTraining());
        System.out.println("");
        System.out.println("The output after traning");
        System.out.println("SupermanJr Details: " + sup3.toString());
    }
}
