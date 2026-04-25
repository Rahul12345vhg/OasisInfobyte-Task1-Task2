import java.util.*;

public class OnlineExamSystem {

    static Scanner sc = new Scanner(System.in);

    // User data
    static String username = "student";
    static String password = "1234";

    // Questions & Answers
    static String[] questions = {
            "1. Java is a ___ language?\nA. Programming\nB. Cooking\nC. Dancing\nD. Drawing",
            "2. Which keyword is used for class?\nA. define\nB. class\nC. int\nD. void",
            "3. Which method is entry point?\nA. start()\nB. run()\nC. main()\nD. init()",
            "4. Which is not datatype?\nA. int\nB. float\nC. string\nD. real",
            "5. Java is ___?\nA. Platform dependent\nB. Platform independent\nC. Both\nD. None"
    };

    static char[] answers = { 'A', 'B', 'C', 'D', 'B' };

    public static void main(String[] args) {

        System.out.println("===== Online Examination System =====");

        // Login
        if (!login()) {
            System.out.println("Invalid Login!");
            return;
        }

        while (true) {
            System.out.println("\n1. Start Exam");
            System.out.println("2. Update Profile/Password");
            System.out.println("3. Logout");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    startExam();
                    break;
                case 2:
                    updateProfile();
                    break;
                case 3:
                    System.out.println("Logged out successfully!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Login Method
    static boolean login() {
        System.out.print("Enter Username: ");
        String user = sc.next();

        System.out.print("Enter Password: ");
        String pass = sc.next();

        return user.equals(username) && pass.equals(password);
    }

    // Update Profile
    static void updateProfile() {
        System.out.print("Enter new username: ");
        username = sc.next();

        System.out.print("Enter new password: ");
        password = sc.next();

        System.out.println("Profile Updated Successfully!");
    }

    // Start Exam
    static void startExam() {

        int score = 0;
        long startTime = System.currentTimeMillis();
        long examDuration = 60000; // 60 seconds

        sc.nextLine(); // clear buffer

        for (int i = 0; i < questions.length; i++) {

            long currentTime = System.currentTimeMillis();
            if (currentTime - startTime > examDuration) {
                System.out.println("\n⏰ Time Up! Auto Submitting...");
                break;
            }

            System.out.println("\n" + questions[i]);
            System.out.print("Enter answer (A/B/C/D): ");
            char ans = sc.nextLine().toUpperCase().charAt(0);

            if (ans == answers[i]) {
                score++;
            }
        }

        System.out.println("\n===== Exam Finished =====");
        System.out.println("Your Score: " + score + "/" + questions.length);
    }
}