USE MovieTicketBookingSystem;
GO

CREATE TABLE Movies (
    movie_id INT IDENTITY(1,1) PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    price DECIMAL(5,2) NOT NULL
);

CREATE TABLE Shows (
    show_id INT IDENTITY(1,1) PRIMARY KEY,
    movie_id INT NOT NULL,
    show_time VARCHAR(20) NOT NULL,
    total_seats INT NOT NULL,
    FOREIGN KEY (movie_id) REFERENCES Movies(movie_id)
);

CREATE TABLE Seats (
    seat_id INT IDENTITY(1,1) PRIMARY KEY,
    show_id INT NOT NULL,
    seat_number INT NOT NULL,
    booked BIT DEFAULT 0,
    FOREIGN KEY (show_id) REFERENCES Shows(show_id)
);

CREATE TABLE Bookings (
    booking_id INT IDENTITY(1,1) PRIMARY KEY,
    show_id INT NOT NULL,
    seat_id INT NOT NULL,
    total_price DECIMAL(5,2) NOT NULL,
    booking_status VARCHAR(30) DEFAULT 'Confirmed',
    FOREIGN KEY (show_id) REFERENCES Shows(show_id),
    FOREIGN KEY (seat_id) REFERENCES Seats(seat_id)
);
GO