import java.util.ArrayList;


/**
 * 
 */

/**
 * @author Michael Quinn
 *
 */
public class Patron {
	
	private String firstName = "Ted";
	private String lastName = "Fringley";
	public ArrayList booksCheckedOut = new ArrayList();
	private boolean canRent;
	
	public Patron () {
		this.firstName = "Ted";
		this.lastName = "Fringley";
		this.canRent = true; 
	}
	
	public Patron (String first, String last, Boolean rent) {
		this.firstName = first;
		this.lastName = last;
		this.canRent = rent;
	}
	
	
	/*
	 * Returns the first name of the patron. 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/*
	 * Sets the first name of the patron. 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/*
	 * Returns the last name of the patron. 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}	
	 /*
	 * Sets the last name of the patron. 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/*
	 * Returns the books currently checked out by the patron.
	 * @return Print statement about patron.
	 */
	public ArrayList getBooksCheckedOut() {
		return booksCheckedOut;
	}
	/*
	 * Updates the list of currently checked out books. 
	 * @param booksCheckedOut
	 */
	public void addBooksCheckedOut(Book choice) {
		booksCheckedOut.add(choice);
	}
/* Updates the list of currently checked out books. 
* @param booksCheckedOut
*/
	public void removeBooksCheckedOut(Book choice) {
		this.booksCheckedOut.remove(choice);
	}
	/*
	 * Returns if the patron can rent new books.
	 * @return canRent
	 */
	public boolean isCanRent() {
		return canRent;
	}
	/*
	 * Sets if the patron can rent books
	 * @param canRent
	 */
	public void setCanRent(boolean canRent) {
		this.canRent = canRent;
	}
	
	/**
	 * returns information about the  patron
	 * @return A detailed description of patrons
	 */
	public String toString () {
		return firstName.toUpperCase() + " " + lastName.toUpperCase() + " " + " Rented: " + booksCheckedOut.size() + "\n";
		
	}
	
}
