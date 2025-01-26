
public class Ticket {
	Passenger passenger;
	Flight flight;
	double price;
	static int number = 1;

	public Ticket(Passenger p, Flight flight, double price) {
		this.passenger = p;
		this.flight = flight;
		this.price = price;
	}

	@Override
	public String toString() {
		String s = String.format(
				"%s, %s, ticket price: $%.2f",
				passenger.getName(),
				flight.toString(),
				price);
		return s;

	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger p) {
		this.passenger = p;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber() {
		number++;
	}

}
