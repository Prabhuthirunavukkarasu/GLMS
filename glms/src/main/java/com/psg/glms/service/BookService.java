package com.psg.glms.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.psg.glms.domain.Book;
import com.psg.glms.domain.User;
import com.psg.glms.utility.GlobalSettings;

// Service only to take care of Book related Transactional activities
public class BookService {
	
	public BookService() {
	}
	
	public List<Book> searchBook(final List<Book> bookRepo, User user, Object keyword, String type) {
		List<Book> resultObj = null; //For the sake of simplicity, made object as null so we can reduce LoC
		if(bookRepo!=null && bookRepo.size()>0) {
			resultObj = searchBooks(bookRepo, keyword, type);
		}
		return resultObj;
	}
	
	// Base search Method
	List<Book> searchBooks(final List<Book> bookRepo, Object keyword, String type) {
		List<Book> tempBookList = new ArrayList<Book>();
		for (Iterator<Book> iterator = bookRepo.iterator(); iterator.hasNext();) {
			Book tempBook = (Book) iterator.next();
			if(keyword.toString().equalsIgnoreCase(tempBook.getTitle()))
				tempBookList.add(tempBook);
		}
		return tempBookList;
	}
	
	// Search book by Book Title/Author/Department
	List<Book> searchByType(String type, Object keyword, Book bookObj, List<Book> tempBookList) {
		if(type.equalsIgnoreCase(GlobalSettings.TYPE_TITLE)) {
			if(keyword.toString().equalsIgnoreCase(bookObj.getTitle()))
				tempBookList.add(bookObj);
		}
		if(type.equalsIgnoreCase(GlobalSettings.TYPE_AUTHOR)) {
			if(keyword.toString().equalsIgnoreCase(bookObj.getAuthor()))
				tempBookList.add(bookObj);
		}
		if(type.equalsIgnoreCase(GlobalSettings.TYPE_DEPT)) {
			int deptId = Integer.parseInt((String)keyword);
			if(deptId == bookObj.getDepartmentId())
				tempBookList.add(bookObj);
		}
		return tempBookList;
	}
}
