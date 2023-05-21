import java.util.*;

public class Menu {

    Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n------ MENU ------");
            System.out.println("1. Insert a location");
            System.out.println("2. Delete a location");
            System.out.println("3. Search for a location");
            System.out.println("4. Print the graph");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

    }
}
        