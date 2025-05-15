import java.util.*;
import java.util.logging.*;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n=== Hospital Management System ===");
                System.out.println("1. Patient Registration");
                System.out.println("2. Appointment Scheduling");
                System.out.println("3. Electronic Health Records");
                System.out.println("4. Billing & Invoicing");
                System.out.println("5. Inventory Management");
                System.out.println("6. Staff Management");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                try {
                    switch (choice) {
                        case 1 -> Patient.managePatients();
                        case 2 -> Appointment.manageAppointments();
                        case 3 -> EHR.manageEHR();
                        case 4 -> Billing.manageBilling();
                        case 5 -> Inventory.manageInventory();
                        case 6 -> Staff.manageStaff();
                        case 7 -> { System.out.println("Exiting..."); return; }
                        default -> throw new IllegalArgumentException("Invalid choice! Try again.");
                    }
                } catch (IllegalArgumentException | InputMismatchException e) {
                    logger.log(Level.WARNING, "Exception occurred", e);
                }
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error occurred", e);
        }
    }
}
