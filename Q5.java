class Answer{
	private String FirstName ;
	private String LastName;
	private String collageName;
	private int studentID;
	private String Zip;
	
	
	public String getFirstName() {
		return FirstName;
	}
	public String getLastName() {
		return LastName;
	}
	public String getcollageName() {
		return collageName;
	}
	public int getstudentID() {
		return studentID;
	}
	public String getZip() {
		return Zip;
	}
	
	public void setFirstName (String newValue) {
		FirstName = newValue;
	}
	public void setLastName (String newValue) {
		LastName = newValue;
	}
	public void setcollageName (String newValue) {
		collageName = newValue;
	}
	public void setstudentID (int newValue) {
		studentID= newValue;
	}
	public void setZip (String newValue) {
		Zip = newValue;
	}
	
}


public class Q5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Answer obj = new Answer();
		obj.setFirstName ("Little");
		obj.setLastName("Spark");
		obj.setcollageName("Swarthmore College");
		obj.setstudentID(100235);
		obj.setZip("K1Y-8X7");
		
		
		System.out.println("First Name  -  " + obj.getFirstName());
		System.out.println("Last Name   -  "+ obj.getLastName());
		System.out.println("Collage     -  " + obj.getcollageName());
		System.out.println("Student ID  -  "+ obj.getstudentID());
		System.out.println("Zipcode     -  "+ obj.getZip());
	}

}
