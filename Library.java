import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;


/**
 * This is the main controller for the Library Management System. It contains the main method.
 */

/**
 * @author Michael Quinn
 *
 */
public class Library{
	private static  ArrayList patrons = new ArrayList();
	private static  ArrayList books = new ArrayList();	
	
	static Scanner input = new Scanner (System.in); 
	
	public static void main (String [] args) {
		int userSelection = 0, run = 1;
		
		while(run == 1) {
			//Display the Main Menu
			System.out.print(showMainMenu());
			//Wait for user input
			userSelection = input.nextInt();
			//Call the appropriate action based on input
			switch (userSelection){
				//Adds a new patron to the list
				case 1 : addPatron();
						break;
				//Adds a new book to the list
				case 2 : addBook();
						break;
						
				//Allows the user to edit an existing patron account
				case 3 : editPatron();
						break;
						
				//Allows the user to edit an existing book
				case 4 : editBook();
						break;
						
				//Prints all patrons on the list
				case 5 : displayAllPatrons();
						break;
						
				//Prints all books and availability
				case 6 : displayAllBooks();
						break;
						
				//Allows user to check out a book
				case 7 : checkOutBook();
						break;
						
				//Allows user to check in a book
				case 8 : checkInBook();
						break;
						
				//Exits the program
				case 9 : System.out.println("\nGoodbye.");
						run = 0;
						break;
					
				default : 
						System.out.println("Please enter a valid selection.");
			}
			
			
		}
		input.close();
	}

public static void checkInBook () {
		int bookSel, accSel;
		//Select an account
		System.out.println("Please select an account (0 - " + (patrons.size() - 1) + ")");
		displayAllPatrons();
		accSel = input.nextInt();
		//select a book
		System.out.println("Please select a book");
		System.out.print(((Patron) patrons.get(accSel)).getBooksCheckedOut());
		bookSel = input.nextInt(); 
		
		Book choice = (Book) books.get(bookSel);
		choice.available = true;
		choice.dueDate = null;
		choice.checkOutDate = null;
		((Patron) patrons.get(accSel)).removeBooksCheckedOut(choice);
	} 


public static void checkOutBook () {
	int bookSel, accSel;
	//Select an account
	System.out.println("Please select an account (0 - " + (patrons.size() - 1) + ")");
	displayAllPatrons();
	accSel = input.nextInt();
	//select a book
	System.out.println("Please select a book (0 - " + (books.size() - 1) +")");
	displayAllBooks();
	bookSel = input.nextInt(); 
	
	Book choice = (Book) books.get(bookSel);
	if (choice.available == true) {
		choice.available = false;
		choice.checkOutDate = new Date();
		choice.setDueDate(choice.addDays(choice.checkOutDate, 7));
		Patron acc = (Patron) patrons.get(accSel);
		acc.addBooksCheckedOut(choice);
	}
	else {
		System.out.println("That book is unavailable.");
	}

}

/*
 * Allows editing of the book author and title.
 */
public static void editBook() {
	int sel;
	String newTitle, newAuthor;
	
	System.out.println("Please select a book. (0 - " + (books.size() - 1) + ")");
	displayAllBooks();
	sel = input.nextInt();
	System.out.println("Please enter a new book title. (\"-\" in place of spaces.)");
	newTitle = input.next();
	System.out.println("Please enter the author. (\"-\" in place of spaces.)");
	newAuthor = input.next();
	
	((Book) books.get(sel)).setTitle(newTitle);
	((Book) books.get(sel)).setAuthor(newAuthor);
	System.out.println("Confirmed. \n");
}


/*
 * Method for printing out available books
 */
public static void displayAllBooks () {
	System.out.print(books.toString() + "\n");
}	
	
/*
 * Prints out all of the patrons on the list
 */
public static void displayAllPatrons () {
	System.out.print(patrons.toString() + "\n");
}
/*
 * Allows the user to edit an existing user account.
 * @param sel		User Selection
 */
public static void editPatron() {
	String newfirst, newlast; 
	int sel;
	//Prints the list of patrons
	displayAllPatrons();
	System.out.println("Please select a user. (0 - " + (patrons.size() - 1) + ")");
	sel = input.nextInt();
	//Grabs the correct account
	patrons.get(sel);
	System.out.println("Please enter new first name: \n");
	newfirst = input.next();
	System.out.println("Please enter new last name: \n");
	newlast = input.next();
	
	//Updates the account
	 ((Patron) patrons.get(sel)).setFirstName(newfirst);
	 ((Patron) patrons.get(sel)).setLastName(newlast);
	 System.out.println("Confirmed.\n");
	
}

/* 
 * Allows the user to add a new book to the library
 * @param title		title of book
 * 		  author	author of book
 */
public static void addBook () {
	String title, author;

	System.out.println("Please enter the title of the book (use \"-\" in place of Spaces)");
	title = input.next();
	System.out.println("Please enter the author or the book");
	author = input.next();
	Book b1 = new Book (title, author);
	books.add(b1);
	
}
	
/* 
 * This method allows the user to add a new patron to the list. 
 * @param first 	first name of patron
 *  	  last		last name of patron
 *  	  rent		eligibility for renting
 */
public static void addPatron () {
	String first, last;
	Boolean rent = null;
	System.out.println("Please enter a first name.");
	first = input.next();
	System.out.println("Please enter a last name.");
	last = input.next();
	rent = true;
	
	Patron p1 = new Patron (first, last, rent);
	patrons.add(p1);
}

/*
 * This method displays the main menu for the user to select. 
 * @return The contents of the menu. 
 */
public static String showMainMenu () {
	return "***MAIN MENU***\n" 
			+ "1. Add new patron\n"
			+ "2. Add new book\n"
			+ "3. Edit patron\n"
			+ "4. Edit book\n"
			+ "5. Display all patrons\n"
			+ "6. Display all books\n"
			+ "7. Check out book\n"
			+ "8. Check in book\n"
			+ "9. Exit";
	}



}