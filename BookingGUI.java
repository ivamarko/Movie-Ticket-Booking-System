package movieticketbookingsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class BookingGUI extends JFrame {
    private Bookingsystem system;
    private JComboBox<String> movieBox;
    private JComboBox<Integer> seatBox;
    private JLabel timeLabel;
    private JLabel priceLabel;
public BookingGUI() {
system = new Bookingsystem();
setTitle("🎬 Movie Ticket Booking System");
setSize(400, 300);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setLayout(new GridLayout(6, 2, 10, 10));
add(new JLabel("Select Movie:"));
movieBox = new JComboBox<>();
for (Show show : system.getShows()) {
movieBox.addItem(show.getMovie().getTitle());
}
add(movieBox);
add(new JLabel("Show Time:"));
timeLabel = new JLabel();
add(timeLabel);
add(new JLabel("Price:"));
priceLabel = new JLabel();
add(priceLabel);
add(new JLabel("Seat Number:"));
seatBox = new JComboBox<>();
add(seatBox);
JButton bookButton = new JButton("Book Ticket");
add(bookButton);
add(new JLabel(""));
updateShowDetails(0);
movieBox.addActionListener(e ->
updateShowDetails(movieBox.getSelectedIndex())
);
bookButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
bookSeat();
}
});
}
private void updateShowDetails(int index) {
Show show = system.getShows().get(index);
timeLabel.setText(show.getTime());
priceLabel.setText("$" + show.getMovie().getPrice());
seatBox.removeAllItems();
for (Seat seat : show.getSeats()) {
if (!seat.isBooked()) {
seatBox.addItem(seat.getSeatNumber());
}
}
}
private void bookSeat() {
int showIndex = movieBox.getSelectedIndex();
Show show = system.getShows().get(showIndex);
Integer seatNumber = (Integer) seatBox.getSelectedItem();
if (seatNumber == null) {
JOptionPane.showMessageDialog(this,"No available seats.","Error",
JOptionPane.ERROR_MESSAGE);
return;
}
Seat seat = show.getSeat(seatNumber);
if (seat.isBooked()) {
JOptionPane.showMessageDialog(this,"Seat already booked.","Error",
JOptionPane.ERROR_MESSAGE);
return;
}
Booking booking = new Booking(show, seat);
booking.confirmBooking();
JOptionPane.showMessageDialog(this,"Booking Confirmed!\n" +"Movie: " + show.getMovie().getTitle() +"\nTime: " + show.getTime() +"\nSeat: " + seatNumber +"\nPrice: $" + booking.getTotalPrice(),"Success",JOptionPane.INFORMATION_MESSAGE);
updateShowDetails(showIndex);
}
public static void main(String[] args) {
SwingUtilities.invokeLater(() -> {
new BookingGUI().setVisible(true);
});
}
}