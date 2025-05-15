import java.util.*;

public class EHR {
    private static final List<EHR> ehrList = new ArrayList<>();

    private final String patientName;
    private final String diagnosis;
    private final String prescription;
    private final String date;

    public EHR(String patientName, String diagnosis, String prescription, String date) {
        this.patientName = patientName;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.date = date;
    }

    public String getPatientName() {
        return patientName;
    }

    public static void addRecord() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("\n--- Add Health Record ---");
            System.out.print("Patient Name: ");
            String patientName = sc.nextLine();
            System.out.print("Diagnosis: ");
            String diagnosis = sc.nextLine();
            System.out.print("Prescription: ");
            String prescription = sc.nextLine();
            System.out.print("Date (DD-MM-YYYY): ");
            String date = sc.nextLine();

            EHR record = new EHR(patientName, diagnosis, prescription, date);
            ehrList.add(record);
            System.out.println("Health record added successfully.");
        }
    }

    public static void viewRecords() {
        System.out.println("\n--- All EHR Records ---");
        if (ehrList.isEmpty()) {
            System.out.println("No health records found.");
        } else {
            for (EHR e : ehrList) {
                System.out.println("Patient: " + e.patientName + ", Diagnosis: " + e.diagnosis +
                        ", Prescription: " + e.prescription + ", Date: " + e.date);
            }
        }
    }

    public static void searchRecords() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Patient Name to Search: ");
            String name = sc.nextLine();
            boolean found = false;

            for (EHR e : ehrList) {
                if (e.getPatientName().equalsIgnoreCase(name)) {
                    System.out.println("Patient: " + e.patientName + ", Diagnosis: " + e.diagnosis +
                            ", Prescription: " + e.prescription + ", Date: " + e.date);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No records found for patient: " + name);
            }
        }
    }

    public static void manageEHR() {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n--- Electronic Health Records ---");
                System.out.println("1. Add New Record");
                System.out.println("2. View All Records");
                System.out.println("3. Search by Patient Name");
                System.out.println("4. Back to Main Menu");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine();  // Consume newline

                switch (choice) {
                    case 1 -> addRecord();
                    case 2 -> viewRecords();
                    case 3 -> searchRecords();
                    case 4 -> {
                        return;
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }
}
