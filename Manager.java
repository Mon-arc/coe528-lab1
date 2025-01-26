import java.util.Scanner;
import java.util.ArrayList;
// Author: Hassan Elshikh, 501263004
// All files written by me

public class Manager {
	private ArrayList<Flight> flights = new ArrayList<Flight>();
	private ArrayList<Ticket> tickets = new ArrayList<Ticket>();

	Scanner in = new Scanner(System.in);

	// To test the main method, input one or both flights to be Toronto to
	// Vancouver,
	// for ease of testing, let the price be 100 to be able to verify the discount
	// with ease.
	// If you want both the bookings to work successfully, set the first
	// flightnumber to 1
	// and the second flightnumber to 2. This is because the main method is
	// expecting these flight
	// numbers to be able to book the seats and display the ticket info. Purely for
	// testing purposes.
	public static void main(String[] args) {
		Manager manager = new Manager();

		// create flights
		manager.createFlights();

		// Test displaying flights
		System.out.println("Available flights from Toronto to Vancouver:");
		manager.displayAvailableFlights("Toronto", "Vancouver");

		// Book seats
		Member member = new Member("Hassan Elshikh", 30, 6); // 6 year membership
		// Should get 50% discount
		NonMember nonMember = new NonMember("Nate B", 70); // Senior member
		// Should get 10% discount
		System.out.println("Booking:"); // Assuming 1 and 2 are valid flight numbers
		manager.bookSeat(1, member);
		manager.bookSeat(2, nonMember);
	}

	public void createFlights() {

		System.out.println("How many flights would you like to create?");
		int numOfFlights = in.nextInt();
		String prompt = "Please input the";
		for (int i = 1; i <= numOfFlights; i++) {
			System.out.printf("Flight %d: %s Flight Number:\n", i, prompt);
			int flightNum = in.nextInt();
			System.out.printf("Flight %d: %s capactiy:\n", i, prompt);
			int capacity = in.nextInt();
			System.out.printf("Flight %d: %s origin:\n", i, prompt);
			String origin = in.next();
			System.out.printf("Flight %d: %s destination:\n", i, prompt);
			String destination = in.next();
			in.nextLine(); // Consume left over \n because in.nextLine will skip otherwise
			System.out.printf("Flight %d: %s Departure Time (format is MM/DD/YY 12:00 pm):\n", i, prompt);
			String departureTime = in.nextLine();
			System.out.printf("Flight %d: %s Original price:\n", i, prompt);
			double originalPrice = in.nextDouble();
			flights.add(new Flight(flightNum, capacity, origin, destination, departureTime, originalPrice));
		}
	}

	public void displayAvailableFlights(String origin, String destination) {
		for (Flight flight : flights) {
			if (flight.origin.equalsIgnoreCase(origin) &&
					flight.destination.equalsIgnoreCase(destination) &&
					flight.getNumberOfSeatsLeft() > 0)
				System.out.printf("- %s\n", flight.toString());
		}
	}

	public Flight getFlight(int flightNumber) {
		for (Flight flight : flights)
			if (flight.getFlightNumber() == flightNumber)
				return flight;
		throw new IllegalArgumentException("Flight with number " + flightNumber + " not found.");
	}

	public void bookSeat(int flightNumber, Passenger p) {
		try {
			Flight flight = getFlight(flightNumber);
			if (flight.bookASeat()) {
				double discountedPrice = p.applyDiscount(flight.getOriginalPrice());

				Ticket ticket = new Ticket(p, flight, discountedPrice);
				tickets.add(ticket);
				System.out.println("Booking successful! Ticket details:");
				System.out.println(ticket);
			}

			else
				System.out.println("Sorry, flight is full");
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
}
