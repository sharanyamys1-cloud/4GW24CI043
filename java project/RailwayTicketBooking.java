import java.util.Scanner;

class RailwayTicketBooking {

    static Scanner sc = new Scanner(System.in);

    static String name, train, source, destination;
    static int age, tickets;
    static boolean booked = false;

    // Book Ticket
    static void bookTicket() {
        System.out.print("Enter Name: ");
        name = sc.next();

        System.out.print("Enter Age: ");
        age = sc.nextInt();

        System.out.print("Enter Train Name: ");
        train = sc.next();

        System.out.print("Enter Source: ");
        source = sc.next();

        System.out.print("Enter Destination: ");
        destination = sc.next();

        System.out.print("Enter Number of Tickets: ");
        tickets = sc.nextInt();

        booked = true;
        System.out.println("\nTicket booked successfully!");
    }

    // View Ticket
    static void viewTicket() {
        if (booked) {
            System.out.println("\n--- Ticket Details ---");
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Train: " + train);
            System.out.println("From: " + source);
            System.out.println("To: " + destination);
            System.out.println("Tickets: " + tickets);
        } else {
            System.out.println("\nNo ticket booked yet.");
        }
    }

    // Cancel Ticket
    static void cancelTicket() {
        if (booked) {
            booked = false;
            System.out.println("\nTicket cancelled successfully!");
        } else {
            System.out.println("\nNo ticket to cancel.");
        }
    }

    // Main Menu
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Railway Ticket Booking System =====");
            System.out.println("1. Book Ticket");
            System.out.println("2. View Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    bookTicket();
                    break;
                case 2:
                    viewTicket();
                    break;
                case 3:
                    cancelTicket();
                    break;
                case 4:
                    System.out.println("\nThank you!");
                    System.out.println("Sharanya - 4GW24CIO43");
                    return;
                default:
                    System.out.println("\nInvalid choice! Try again.");
            }
        }
    }
}
