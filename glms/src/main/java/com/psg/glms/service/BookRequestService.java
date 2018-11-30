package com.psg.glms.service;

import java.util.ArrayList;
import java.util.List;

import com.psg.glms.domain.Book;
import com.psg.glms.domain.BookRequest;
import com.psg.glms.domain.Category;
import com.psg.glms.domain.User;
import com.psg.glms.utility.GlobalSettings;

// Service to process Book Assign/Return flow
public class BookRequestService {

	public BookRequestService() {}
	
	public List<BookRequest> addNewRequest(List<BookRequest> bookRequests, BookRequest bookRequest) {
		bookRequests.add(bookRequest);
		return bookRequests;
	}
	
	public void processRequest(int bookId, int userId, List<BookRequest> bookRequests, List<Book> bookList, List<User> usersList) {
		List<Category> categoryList = new ArrayList<Category>();
		int deptId = 0;
		// Remove Book Object from Book Request Queue
		for (int i = 0; i < bookRequests.size(); i++) {
			BookRequest bookRequest = bookRequests.get(i);
			if(bookRequest.getUserId() == userId && bookRequest.getBookId() == bookId)
				bookRequests.remove(i);
		}
		
		// Update the status in Book List Collection
		for (int i = 0; i < bookList.size(); i++) {
			Book bookObj = bookList.get(i);
			if(bookObj.getBookId() == bookId) {
				bookObj.setAvailable(false);
				bookObj.setUserId(userId);
				deptId = bookObj.getDepartmentId();
				categoryList.addAll(bookObj.getCategoryList());
			}
		}
		
		// Update the status of users like Rating etc
		for (int i = 0; i < usersList.size(); i++) {
			User userObj = usersList.get(i);
			if(userObj.getUserId() == userId) {
				userObj.setRewardPoint(userObj.getRewardPoint() + GlobalSettings.RATING_PER_BOOK);
				int count = getNumberOfBooksByDept(userId, deptId);
				if(count >= GlobalSettings.RATING_BY_DEPT_BOOK_COUNT)
					userObj.setRewardPoint(userObj.getRewardPoint() + GlobalSettings.RATING_BY_DEPT);
				
				if(getLastBookCategory(userObj, categoryList))
					userObj.setRewardPoint(userObj.getRewardPoint() + GlobalSettings.RATING_PER_BOOK);
			}
		}
	}
	
	// Get total Number of Books based on Department
	public int getNumberOfBooksByDept(int userId, int deptId) {
		// Fetch data from DB and return count;
		return 1;
	}
	
	// Get Category ID of last book
	public boolean getLastBookCategory(User userObj, List<Category> categoryList) {
		// Iterate through category and if the category is not available in existing transaction, set as true.
		return true;
	}
	
	public void processReturn(int bookId, int userId, List<Book> bookList) {
		
		// Update the status in Book List Collection
		for (int i = 0; i < bookList.size(); i++) {
			Book bookObj = bookList.get(i);
			if(bookObj.getBookId() == bookId) {
				bookObj.setAvailable(true);
				bookObj.setUserId(0);
			}
		}
		
	}
}
