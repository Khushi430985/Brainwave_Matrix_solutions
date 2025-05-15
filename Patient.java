import java.util.*;

public class Patient {
    private static final List<Patient> patientList = new ArrayList<>();
    private static int idCounter = 1001;

    private final int patientId;
    private final String name;
    private final int age;
    private final String gender;
    private final String contact;
    private final String address;
    private final String disease;

    public Patient(String name, int age, String gender, String contact, String address, String disease) {
        this.patientId = idCounter++;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
        this.address = address;
        this.disease = disease;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public static void registerPatient() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("\n--- Register New Patient ---");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Gender: ");
            String gender = sc.nextLine();
            System.out.print("Contact Number: ");
            String contact = sc.nextLine();
            System.out.print("Address: ");
            String address = sc.nextLine();
            System.out.print("Disease/Symptoms: ");
            String disease = sc.nextLine();

            Patient p = new Patient(name, age, gender, contact, address, disease);
            patientList.add(p);
            System.out.println("Patient Registered with ID: " + p.patientId);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
        }
    }

    public static void viewAllPatients() {
        System.out.println("\n--- All Registered Patients ---");
        if (patientList.isEmpty()) {
            System.out.println("No patients registered.");
        } else {
            for (Patient p : patientList) {
                System.out.println("ID: " + p.patientId + ", Name: " + p.name + ", Age: " + p.age +
                        ", Gender: " + p.gender + ", Contact: " + p.contact + ", Address: " + p.address +
                        ", Disease: " + p.disease);
            }
        }
    }

    public static void searchPatientById() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Patient ID to Search: ");
            int id = sc.nextInt();
            boolean found = false;

            for (Patient p : patientList) {
                if (p.getPatientId() == id) {
                    System.out.println("ID: " + p.patientId + ", Name: " + p.name + ", Age: " + p.age +
                            ", Gender: " + p.gender + ", Contact: " + p.contact + ", Address: " + p.address +
                            ", Disease: " + p.disease);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Patient with ID " + id + " not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid patient ID.");
        }
    }

    public static void managePatients() {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n--- Patient Management ---");
                System.out.println("1. Register New Patient");
                System.out.println("2. View All Patients");
                System.out.println("3. Search Patient by ID");
                System.out.println("4. Back to Main Menu");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> registerPatient();
                    case 2 -> viewAllPatients();
                    case 3 -> searchPatientById();
                    case 4 -> {
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
