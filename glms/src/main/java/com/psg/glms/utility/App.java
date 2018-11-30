package com.psg.glms.utility;

import java.util.*;
import com.psg.glms.domain.*;
import com.psg.glms.service.BookRequestService;
import com.psg.glms.service.BookService;

public class App {
	
	static List<User> users = new ArrayList<User>();
	static List<Book> books = new ArrayList<Book>();
	static List<BookRequest> bookRequests = new ArrayList<BookRequest>();
	static int bookRequestId = 0; //Primary Key
	
    public static void main(String[] args) {
    	prepareMaster();
    	BookRequestService bookRequestService = new BookRequestService();
    	List<Book> bookSearch = new ArrayList<Book>();
    	BookService bookService = new BookService();
    	
    	//User search for new Book
    	bookSearch = bookService.searchBook(books, users.get(0), "OOPS", GlobalSettings.TYPE_TITLE);
    	
    	//Get Results
    	if(bookSearch.size()>0) {
    		int userId = users.get(0).getUserId();
    		for (Iterator<Book> iterator = bookSearch.iterator(); iterator.hasNext();) {
				Book book = (Book) iterator.next();
				
				// Raise a request for the book requested by user
				BookRequest bookRequest = new BookRequest(bookRequestId+1, userId, book.getBookId());
				bookRequestService.addNewRequest(bookRequests, bookRequest);
				
				if(book.isAvailable()) {
					// If book is available, then process the request. Ratings will be computed in this service.				
					bookRequestService.processRequest(book.getBookId(), userId, bookRequests, books, users);
				}
			}
    	}
    	
    	//User return all the books he procured
    	if(bookSearch.size()>0) {
    		int userId = users.get(0).getUserId();
    		for (Iterator<Book> iterator = bookSearch.iterator(); iterator.hasNext();) {
				Book book = (Book) iterator.next();
				bookRequestService.processReturn(book.getBookId(), userId, books);
    		}
    	}
    	
    	// Get user Badge Name
    	System.out.println(GlobalSettings.getBadgeName(users.get(0).getRewardPoint()));
    	
    }
    
    static void prepareMaster() {
    	// Book Master
    	Book book1 = new Book(1, "OOPS", "James Martin", 1);
    	Book book2 = new Book(2, "Data Structures", "Kevin", 1);
    	books.add(book2);
    	books.add(book1);
    	
    	// User Master
    	User user1 = new User(1, "Ramesh");
    	User user2 = new User(1, "Suresh");
    	users.add(user1);
    	users.add(user2);
    	
		GlobalSettings globalSettings = new GlobalSettings();
		globalSettings.prepareMaster();
    }
    
}
