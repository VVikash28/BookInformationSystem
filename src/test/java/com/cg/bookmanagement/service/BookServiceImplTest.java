package com.cg.bookmanagement.service;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.bookmanagement.dto.BookDTO;
import com.cg.bookmanagement.repository.BookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookServiceImplTest {
	
	@InjectMocks
	BookServiceImpl bookservice;
	
	@Mock
	BookRepository bookRepository;

	
	
	  @BeforeEach void setUp() throws Exception {
	  MockitoAnnotations.initMocks(this); }
	 
	 
	
	
	@Test public void testgetAllBooks() {
	 
	 when(bookRepository.findAll()).thenReturn(Stream.of(new
	 BookDTO("BOOK12","the man", "pratik", "the drama based story",
	 "123456789",(float) 45, LocalDate.parse("2014-05-04"), "something"), new
	   BookDTO("BOOK11","the man","pratik", "the drama based story", "123456789",
	  (float) 45,LocalDate.parse("2014-05-04"), "something"))
	  .collect(Collectors.toList()));
	  
	  
	  assertEquals(0, bookservice.getAllBook().size());
	 
	
	 }
	 
	 
	 
	@Test
	public void testaddBook()
	{
		BookDTO book = new BookDTO("BOOK10", "the man", "pratik", "the drama based story", "123456789", (float) 45,
				LocalDate.parse("2014-05-04"), "something");
		when(bookservice.addBook(book)).thenReturn(book);
		assertEquals(book, bookservice.addBook(book));
	}
	

}
