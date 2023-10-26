package computerSpare;

public class Booking {
	
	private static int idbooking;
	private String date;
	private String destination;
	private String requests;

	public Booking(int idbooking, String date, String destination, String requests) {
		
		//create constructor
		this.idbooking = idbooking;
		this.date = date;
		this.destination = destination;
		this.requests = requests;

	}
	
	public Booking() {
		// TODO Auto-generated constructor stub
	}

	//create getters
	public int getId() {
		return idbooking;
	}

	public String getDate() {
		return date;
	}

	public String getDestination() {
		return destination;
	}

	public String getRequests() {
		return requests;
	}

}
