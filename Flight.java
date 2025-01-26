
public class Flight {
	int flightNumber, capacity, numberOfSeatsLeft;
	String origin, destination, departureTime;
	double originalPrice;

	public Flight(
			int flightNumber, int capacity, String origin,
			String destination, String departureTime,
			double originalPrice) {
		if (origin.equals(destination))
			throw new IllegalArgumentException();

		this.flightNumber = flightNumber;
		this.capacity = capacity;
		this.numberOfSeatsLeft = capacity;
		this.origin = origin;
		this.destination = destination;
		this.departureTime = departureTime;
		this.originalPrice = originalPrice;
	}

	public boolean bookASeat() {
		if (numberOfSeatsLeft > 0) {
			numberOfSeatsLeft--;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("Flight %d, %s to %s, %s, original price: %.0f$",
				flightNumber, origin, destination, departureTime, originalPrice);
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getNumberOfSeatsLeft() {
		return numberOfSeatsLeft;
	}

	public void setNumberOfSeatsLeft(int numberOfSeatsLeft) {
		this.numberOfSeatsLeft = numberOfSeatsLeft;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}
}
