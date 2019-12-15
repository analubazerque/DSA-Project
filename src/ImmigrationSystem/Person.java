package ImmigrationSystem;

public class Person {

	// Atributes of the Person
	private String firstName;
	private String lastName;
	private String dateOfArrival;
	private String passportNumber;
	private int id;
	private static int IdCounter = 0;

	// Person's constructor
	public Person(String firstName, String lastName, String dateOfArrival, String passportNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfArrival = dateOfArrival;
		this.passportNumber = passportNumber;
		id = ++IdCounter;
	}
	public Person(){

	}

	///////GETTERS AND SETTERS///////

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfArrival() {
		return dateOfArrival;
	}

	public void setDateOfArrival(String dateOfArrival) {
		this.dateOfArrival = dateOfArrival;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", dateOfArrival=" + dateOfArrival
				+ ", passportNumber=" + passportNumber + "]";
	}
}