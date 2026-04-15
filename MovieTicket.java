import java.util.*;

class Movie {
    int id;
    String name;
    int seats;
    boolean booked;

    Movie(int id, String name, int seats) {
        this.id = id;
        this.name = name;
        this.seats = seats;
        booked = false;
    }

    void display() {
        System.out.println(id + " | " + name + " | Seats: " + seats + " | Booked: " + booked);
    }
}

public class MovieTicket {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Movie> movies = new ArrayList<>();

        while (true) {

            System.out.println("\nMovie Ticket Menu");
            System.out.println("1. Add Movie");
            System.out.println("2. Display Movies");
            System.out.println("3. Book Ticket");
            System.out.println("4. Cancel Ticket");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter Movie ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Movie Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Total Seats: ");
                int seats = sc.nextInt();

                movies.add(new Movie(id, name, seats));
                System.out.println("Movie added successfully.");

            }
            else if (choice == 2) {

                if (movies.isEmpty()) {
                    System.out.println("No movies available.");
                } else {
                    System.out.println("\nID | Movie Name | Seats | Booked");
                    for (Movie m : movies) {
                        m.display();
                    }
                }

            }
            else if (choice == 3) {

                System.out.print("Enter Movie ID to book: ");
                int id = sc.nextInt();

                boolean found = false;

                for (Movie m : movies) {
                    if (m.id == id) {
                        if (!m.booked) {
                            m.booked = true;
                            System.out.println("Ticket booked successfully.");
                        } else {
                            System.out.println("Ticket already booked.");
                        }
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("Movie ID not found.");
                }

            }
            else if (choice == 4) {

                System.out.print("Enter Movie ID to cancel: ");
                int id = sc.nextInt();

                boolean found = false;

                for (Movie m : movies) {
                    if (m.id == id) {
                        m.booked = false;
                        System.out.println("Ticket cancelled successfully.");
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("Movie ID not found.");
                }

            }
            else if (choice == 5) {

                System.out.println("Thank you for using Movie Ticket System.");
                break;

            }
            else {

                System.out.println("Invalid choice.");

            }

        }

        sc.close();
    }
}