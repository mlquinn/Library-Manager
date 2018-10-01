import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Creates the Book objects for the library. 
 */

/**
 * @author Michael Quinn
 *
 */
public class Book implements BookInterface {
	String title, author;
	Boolean available;
	Date dueDate, checkOutDate;
	
	
	/*
	 * Constructs a default book based on BookInterface
	 */
	public Book () {
		this.title = "BLANK";
		this.author = "SOMEONE";
		this.checkOutDate = null;
	}
	
	/*
	 * Creates the book object and sets the title, availability and author of the book
	 */
	public Book (String title, String author) {
		this.title = title;
		this.author = author; 
		this.available = true;
		this.checkOutDate = null;
		this.dueDate =  null;
	}
	
	/**
	 * Provides information on the title of book
	 * @return	title 	title of book
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Allows user to change the title of book
	 * @param title	title of the book
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * provides information on the author of the book
	 * @return	author	who wrote the book
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * ALlows user to set the author of the book
	 * @param author	who wrote the book
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * Allows user to see if the book is available
	 * @return	available	is the book rentable
	 */
	public Boolean getAvailable() {
		return available;
	}

	/**
	 * allows user to change availability of book
	 * @param available	is the book rentable
	 */
	public void setAvailable(Boolean available) {
		this.available = available;
	}

	/**
	 * Provides the due date of the bok
	 * @return	when the book is due
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * Sets the date the book is due
	 * @param dueDate when thebook is due back at the library
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	/**
	 * provides the current checkout date
	 * @return the date the book was checked out
	 */
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	/**
	 * Allows user to set the date of checkout
	 * @param checkOutDate when the book was checkedout
	 */
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
	/**
	 * information about the book
	 * @return A detailed description of book
	 */
	public String toString () {
		return title.toUpperCase() + " By: " + author.toUpperCase() + " Available: " + available + " Due: " + dueDate + "\n";
	}

	/*
	 * Takes the current checkout date of the book and adds 7 days.
	 * @return cal.getTime()
	 */
	public static Date addDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);

		return cal.getTime();
	}
}
