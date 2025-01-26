
public class Ticket{
	Passenger passenger;
	Flight flight;
	double price;
	int number;

	public Ticket(Passenger p, Flight flight, double price){
		this.passenger = p;
		this.flight = flight;
		this.price = price;
	}

	public Passenger getPassenger(){
		return passenger;
	}

	public void setPassenger(Passenger p){
		this.passenger = p;
	}

	public Flight getFlight(){
		return flight;
	}

	public void setFlight(Flight flight){
		this.flight = flight;
	}

	public double getPrice(){
		return price;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public int getNumber(){
		return return number;
	}

	public void setNumber(int number){
		this.number = number;
	}

}
