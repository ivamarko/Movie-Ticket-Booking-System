package movieticketbookingsystem;
import java.util.Scanner;
public class Main {
public static void main(String[] args) {
Bookingsystem system = new Bookingsystem();
Scanner scanner = new Scanner(System.in);
System.out.println("🎬 Welcome to Movie Ticket Booking System");
for (int i = 0; i < system.getShows().size(); i++) {
Show show = system.getShows().get(i);
System.out.println((i + 1) + ". " +
show.getMovie().getTitle() +  " | Time: " + show.getTime() + " | Price: $" + show.getMovie().getPrice());
}
System.out.print("Select show number: ");
int showChoice = scanner.nextInt();
Show selectedShow = system.getShows().get(showChoice - 1);
System.out.println("Available seats:");
for (Seat seat : selectedShow.getSeats()) {
if (!seat.isBooked()) {
System.out.print(seat.getSeatNumber() + " ");
}
}
System.out.print("\nSelect seat number: ");
int seatNumber = scanner.nextInt();
Seat selectedSeat = selectedShow.getSeat(seatNumber);
if (selectedSeat == null || selectedSeat.isBooked()) {
System.out.println("❌ Seat not available.");
} else {
Booking booking = new Booking(selectedShow, selectedSeat);
booking.confirmBooking();
System.out.println("✅ Booking confirmed!");
System.out.println("Movie: " + selectedShow.getMovie().getTitle());
System.out.println("Time: " + selectedShow.getTime());
System.out.println("Seat: " + seatNumber);
System.out.println("Total Price: $" + booking.getTotalPrice());
}
scanner.close();
}
}