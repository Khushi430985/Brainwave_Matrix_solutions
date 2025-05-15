import java.util.*;

public class Appointment {
    private static int appointmentIdCounter = 500;
    private static final List<Appointment> appointmentList = new ArrayList<>();

    private final int appointmentId;
    private final String patientName;
    private final String doctorName;
    private final String date;
    private final String time;

    public Appointment(String patientName, String doctorName, String date, String time) {
        this.appointmentId = appointmentIdCounter++;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
        this.time = time;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    private static final Scanner sc = new Scanner(System.in);

    public static void bookAppointment() {
        System.out.println("\n--- Book Appointment ---");
        System.out.print("Patient Name: ");
        String patientName = sc.nextLine();
        System.out.print("Doctor Name: ");
        String doctorName = sc.nextLine();
        System.out.print("Date (DD-MM-YYYY): ");
        String date = sc.nextLine();
        System.out.print("Time (e.g., 10:00 AM): ");
        String time = sc.nextLine();

        Appointment a = new Appointment(patientName, doctorName, date, time);
        appointmentList.add(a);
        System.out.println("Appointment booked! ID: " + a.getAppointmentId());
    }

    public static void viewAppointments() {
        System.out.println("\n--- All Appointments ---");
        if (appointmentList.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            for (Appointment a : appointmentList) {
                System.out.println("ID: " + a.appointmentId + ", Patient: " + a.patientName +
                        ", Doctor: " + a.doctorName + ", Date: " + a.date + ", Time: " + a.time);
            }
        }
    }

    public static void cancelAppointment() {
        System.out.print("Enter Appointment ID to cancel: ");
        int id = sc.nextInt();
        boolean found = false;

        Iterator<Appointment> it = appointmentList.iterator();
        while (it.hasNext()) {
            Appointment a = it.next();
            if (a.getAppointmentId() == id) {
                it.remove();
                System.out.println("Appointment ID " + id + " cancelled.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Appointment not found.");
        }
    }

    public static void manageAppointments() {
        while (true) {
            System.out.println("\n--- Appointment Scheduling ---");
            System.out.println("1. Book Appointment");
            System.out.println("2. View Appointments");
            System.out.println("3. Cancel Appointment");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> bookAppointment();
                case 2 -> viewAppointments();
                case 3 -> cancelAppointment();
                case 4 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
