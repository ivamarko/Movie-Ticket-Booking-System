package movieticketbookingsystem;
public class Booking {
private Show show;
private Seat seat;
public Booking(Show show, Seat seat) {
this.show = show;
this.seat = seat;
}
public double getTotalPrice() {
return show.getMovie().getPrice();
}
public void confirmBooking() {
seat.bookSeat();
}
}