package movieticketbookingsystem;
import java.util.ArrayList;
import java.util.List;
public class Bookingsystem {
private List<Show> shows;
public Bookingsystem() {
shows = new ArrayList<>();
seedData();
}
private void seedData() {
movie m1 = new movie(1, "Titanic", 8.5);
movie m2 = new movie(2, "ShutterIsland", 9.0);
shows.add(new Show(m1, "18:00", 10));
shows.add(new Show(m2, "21:00", 10));
}
public List<Show> getShows() {
return shows;
}
}