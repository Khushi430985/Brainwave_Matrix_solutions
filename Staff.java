import java.util.*;

public class Staff {
    private static final List<Staff> staffList = new ArrayList<>();

    private final String name;
    private final String role;
    private final String contact;
    private final String email;
    private final double salary;

    public Staff(String name, String role, String contact, String email, double salary) {
        this.name = name;
        this.role = role;
        this.contact = contact;
        this.email = email;
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public static void addStaff() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("\n--- Add New Staff ---");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Role (Doctor/Nurse/Admin/etc.): ");
            String role = sc.nextLine();
            System.out.print("Contact Number: ");
            String contact = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            staffList.add(new Staff(name, role, contact, email, salary));
            System.out.println("Staff member added successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
        }
    }

    public static void viewAllStaff() {
        System.out.println("\n--- All Staff Members ---");
        if (staffList.isEmpty()) {
            System.out.println("No staff available.");
        } else {
            for (Staff s : staffList) {
                System.out.println("Name: " + s.name + ", Role: " + s.role +
                        ", Contact: " + s.contact + ", Email: " + s.email + ", Salary: ₹" + s.salary);
            }
        }
    }

    public static void searchByRole() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Role to Search: ");
            String searchRole = sc.nextLine();
            boolean found = false;

            for (Staff s : staffList) {
                if (s.getRole().equalsIgnoreCase(searchRole)) {
                    System.out.println("Name: " + s.name + ", Contact: " + s.contact + ", Email: " + s.email + ", Salary: ₹" + s.salary);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No staff found with role: " + searchRole);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid role.");
        }
    }

    public static void removeStaff() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Staff Name to Remove: ");
            String name = sc.nextLine();
            boolean removed = staffList.removeIf(s -> s.getName().equalsIgnoreCase(name));

            if (removed) {
                System.out.println("Staff removed successfully.");
            } else {
                System.out.println("Staff not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid staff name.");
        }
    }

    public static void manageStaff() {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n--- Staff Management ---");
                System.out.println("1. Add Staff");
                System.out.println("2. View All Staff");
                System.out.println("3. Search Staff by Role");
                System.out.println("4. Remove Staff");
                System.out.println("5. Back to Main Menu");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> addStaff();
                    case 2 -> viewAllStaff();
                    case 3 -> searchByRole();
                    case 4 -> removeStaff();
                    case 5 -> {
                        return;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid choice.");
        }
    }
}
