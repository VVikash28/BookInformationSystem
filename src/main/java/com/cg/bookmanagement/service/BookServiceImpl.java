package com.cg.bookmanagement.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cg.bookmanagement.dto.BookDTO;
import com.cg.bookmanagement.exception.BookAlreadyExistException;
import com.cg.bookmanagement.exception.BookNotFoundException;
import com.cg.bookmanagement.exception.EmptyBookListException;

import com.cg.bookmanagement.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<BookDTO> getAllBook() {
		if(bookRepository.count()==0)
		{
			throw new EmptyBookListException("No book exists in the database");
		}
		return (List<BookDTO>) bookRepository.findAll();
	}

	@Override
	public Optional<BookDTO> getBookById(String bookId) {
		if (!bookRepository.existsById(bookId)) 
		{
			throw new BookNotFoundException("Book with Id " + bookId + " Not Found");
		}
		return bookRepository.findById(bookId);
	}

	@Override
	public BookDTO addBook(BookDTO books)  {
		if(bookRepository.existsById(books.getBookId()))
		{
			throw new BookAlreadyExistException("Book with id "+books.getBookId()+" Already exist.");
		}
		return bookRepository.save(books);

	}

	@Override
	public BookDTO deleteBookById(String bookId) {
		if (!bookRepository.existsById(bookId)) 
		{
			throw new BookNotFoundException("Book with Id " + bookId + " Not Found");
		}
		BookDTO books=bookRepository.findById(bookId).get();
		bookRepository.delete(books);
		return books;

	}

	@Override
	public boolean updateBook(BookDTO bookItem) {
		bookRepository.updateInBook(bookItem.getBookId(),bookItem.getTitle(),bookItem.getPrice());
		return true;
	}



}
