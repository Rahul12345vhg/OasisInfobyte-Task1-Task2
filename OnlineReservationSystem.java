import java.util.*;

class OnlineReservationSystem {

    static Scanner sc = new Scanner(System.in);

    // Login credentials
    static String username = "rahul";
    static String password = "1234";

    // Database using HashMap
    static HashMap<Integer, String> database = new HashMap<>();

    public static void main(String[] args) {

        System.out.println("===== Online Reservation System =====");

        // Login
        System.out.print("Enter Username: ");
        String user = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        if (!login(user, pass)) {
            System.out.println("Invalid Login!");
            return;
        }

        System.out.println("Login Successful!");

        while (true) {
            System.out.println("\n1. Reservation");
            System.out.println("2. Cancellation");
            System.out.println("3. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    reservation();
                    break;

                case 2:
                    cancellation();
                    break;

                case 3:
                    System.out.println("Thank You!");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    // Login Method
    static boolean login(String user, String pass) {
        return user.equals(username) && pass.equals(password);
    }

    // Reservation Method
    static void reservation() {
        System.out.println("\n--- Reservation Form ---");

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Train Number: ");
        String trainNo = sc.nextLine();

        String trainName = getTrainName(trainNo);
        System.out.println("Train Name: " + trainName);

        System.out.print("Enter Class Type: ");
        String classType = sc.nextLine();

        System.out.print("Enter Date of Journey: ");
        String date = sc.nextLine();

        System.out.print("From: ");
        String from = sc.nextLine();

        System.out.print("To: ");
        String to = sc.nextLine();

        int pnr = new Random().nextInt(10000);

        String details = "Name: " + name +
                ", Train: " + trainName +
                ", From: " + from +
                ", To: " + to +
                ", Date: " + date;

        database.put(pnr, details);

        System.out.println("Reservation Successful!");
        System.out.println("Your PNR Number: " + pnr);
    }

    // Cancellation Method
    static void cancellation() {
        System.out.print("\nEnter PNR Number: ");
        int pnr = sc.nextInt();

        if (database.containsKey(pnr)) {
            System.out.println("Details: " + database.get(pnr));

            System.out.print("Confirm Cancel (yes/no): ");
            sc.nextLine();
            String confirm = sc.nextLine();

            if (confirm.equalsIgnoreCase("yes")) {
                database.remove(pnr);
                System.out.println("Ticket Cancelled!");
            } else {
                System.out.println("Cancellation Aborted!");
            }
        } else {
            System.out.println("Invalid PNR!");
        }
    }

    // Auto Train Name
    static String getTrainName(String trainNo) {
        switch (trainNo) {
            case "101":
                return "Express A";
            case "102":
                return "Superfast B";
            case "103":
                return "Passenger C";
            default:
                return "Unknown Train";
        }
    }
}