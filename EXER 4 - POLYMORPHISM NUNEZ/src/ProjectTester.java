// Polymorphism ProjectTester for Exer4
import model.*;
import java.util.*;

public class ProjectTester {
    public static void main(String[] args) {
        // Demonstrate runtime polymorphism with User references
        User[] users = new User[] {
            new Admin("Alice Admin", "admin123", "alice@lto.com"),
            new Officer("Bob Officer", "officer123", "bob@lto.com"),
            new Driver("Charlie Driver", "driver123", "charlie@lto.com", "DL-12345")
        };

        System.out.println("--- Polymorphism: User Menus ---");
        for (User user : users) {
            // Calls the correct overridden method based on actual object type
            user.displayMenu();
        }

        // Demonstrate interface polymorphism with Payable
        System.out.println("\n--- Polymorphism: Payable Interface ---");
        Violation violation = new Violation(1, "Charlie Driver", "DL-12345", ViolationType.DUI, 0, true);
        Payable payable = violation; // Polymorphic reference
        System.out.println("Payable amount: ₱" + payable.getAmount());
        System.out.println("Is paid? " + payable.isPaid());
        payable.processPayment();
        System.out.println("Is paid after payment? " + payable.isPaid());

        // Demonstrate Recordable interface
        System.out.println("\n--- Polymorphism: Recordable Interface ---");
        Recordable rec = violation;
        System.out.println("CSV: " + rec.toCSV());
    }
}
