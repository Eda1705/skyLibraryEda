package com.sky.library;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SkylibraryApplicationTests {

	BookRepositoryStub stub = new BookRepositoryStub();
	Book book = new Book();


	@Test
	public void contextLoads()  {
		book = new Book();
		book = stub.retrieveBook("BOOK-GRUFF472");
		try {
			validateBookName(book);
			printBook("[BOOK-GRUFF472]" , book);
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		}


		book = new Book();
		book = stub.retrieveBook("EDA");
		try {
			validateBookName(book);
			printBook("[EDA]" , book);
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		}


		book = new Book();
		book = stub.retrieveBook("EDA_BOOK");
		try {
			validateBookName(book);
			printBook("[EDA_BOOK]" , book);
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		}


		book = new Book();
		book = stub.retrieveBook("EMRE");
		try {
			validateBookName(book);
			printBook("[EMRE]" , book);
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		}


		book = new Book();
		book = stub.retrieveBook("BOOK-POOH222");
		try {
			validateBookName(book);
			printBook("[BOOK-POOH222]" , book);
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		}


		book = new Book();
		book = stub.retrieveBook("BOOK-POOH222");
		try {
			validateBookName(book);
			printBook("[EDA]" , book);
		} catch (BookNotFoundException e) {
			e.printStackTrace();
		}


	}

	private void validateBookName(Book book) throws BookNotFoundException{

		if (book==null) {
			throw new BookNotFoundException("Book Not Found");
		}
		else if(!book.getReference().startsWith("BOOK-")){
			throw new BookNotFoundException("Book reference must begin with 'BOOK-'");
		}
	}

	private void printBook(String reference, Book book){
		System.out.println(reference + book.getTitle() + " - " + book.getReview());
	}


}
