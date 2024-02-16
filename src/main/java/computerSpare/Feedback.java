package computerSpare;

public class Feedback {
	
	private static int idbooking;
	private String date;
	private String name;
	private String feedback;

	public Feedback(int idbooking, String date, String name, String feedback) {
		
		//create constructor
		this.idbooking = idbooking;
		this.date = date;
		this.name = name;
		this.feedback = feedback;
         }
	
	public Feedback() {
		// TODO Auto-generated constructor stub
	}

	//create getters
	public int getId() {
		return idbooking;
	}

	public String getDate() {
		return date;
	}

	public String getname() {
		return name;
	}

	public String getfeedbacks() {
		return feedback;
	}


}
