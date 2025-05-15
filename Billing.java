import java.util.*;

public class Billing {
    private static int billIdCounter = 1000;
    private static final List<Billing> billList = new ArrayList<>();

    private final int billId;
    private final String patientName;
    private final double consultationFee;
    private final double medicineCharges;
    private final double labCharges;
    private final double totalAmount;
    private final String billingDate;

    public Billing(String patientName, double consultationFee, double medicineCharges, double labCharges, String billingDate) {
        this.billId = billIdCounter++;
        this.patientName = patientName;
        this.consultationFee = consultationFee;
        this.medicineCharges = medicineCharges;
        this.labCharges = labCharges;
        this.totalAmount = consultationFee + medicineCharges + labCharges; 
        this.billingDate = billingDate;
    }

    public String getPatientName() {
        return patientName;
    }

    public int getBillId() {
        return billId;
    }

    public static void generateBill() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("\n--- Generate Bill ---");
            System.out.print("Patient Name: ");
            String name = sc.nextLine();
            System.out.print("Consultation Fee: ");
            double consultation = sc.nextDouble();
            System.out.print("Medicine Charges: ");
            double medicine = sc.nextDouble();
            System.out.print("Lab Charges: ");
            double lab = sc.nextDouble();
            sc.nextLine();  
            System.out.print("Billing Date (DD-MM-YYYY): ");
            String date = sc.nextLine();

            Billing bill = new Billing(name, consultation, medicine, lab, date);
            billList.add(bill);
            System.out.println("Bill generated. ID: " + bill.getBillId() + ", Total: ₹" + bill.totalAmount);
        }
    }

    public static void viewBills() {
        System.out.println("\n--- All Bills ---");
        if (billList.isEmpty()) {
            System.out.println("No bills available.");
        } else {
            for (Billing b : billList) {
                System.out.println("ID: " + b.billId + ", Patient: " + b.patientName +
                        ", Consultation Fee: ₹" + b.consultationFee + ", Medicine Charges: ₹" + b.medicineCharges +
                        ", Lab Charges: ₹" + b.labCharges + ", Total: ₹" + b.totalAmount + ", Date: " + b.billingDate);
            }
        }
    }

    public static void searchBillByPatient() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Patient Name to search: ");
            String name = sc.nextLine();
            boolean found = false;

            for (Billing b : billList) {
                if (b.getPatientName().equalsIgnoreCase(name)) {
                    System.out.println("ID: " + b.billId + ", Patient: " + b.patientName +
                            ", Consultation Fee: ₹" + b.consultationFee + ", Medicine Charges: ₹" + b.medicineCharges +
                            ", Lab Charges: ₹" + b.labCharges + ", Total: ₹" + b.totalAmount + ", Date: " + b.billingDate);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No bills found for " + name);
            }
        }
    }

    public static void manageBilling() {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n--- Billing & Invoicing ---");
                System.out.println("1. Generate Bill");
                System.out.println("2. View All Bills");
                System.out.println("3. Search Bill by Patient Name");
                System.out.println("4. Back to Main Menu");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> generateBill();
                    case 2 -> viewBills();
                    case 3 -> searchBillByPatient();
                    case 4 -> {
                        return;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            }
        }
    }
}
