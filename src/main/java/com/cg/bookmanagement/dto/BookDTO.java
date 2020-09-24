package com.cg.bookmanagement.dto;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "book_info")
public class BookDTO {

	@Id
	private String bookId;
	@NotNull(message="Title cannot be null")
	private String title;
	@NotNull(message="author cannot be null")
	private String author;
	private String description;
	@NotNull(message="isbn cannot be null")
	@Size(min=8,max=16,message="Isbn must be equal or greater than 8 digits and less than 16 digits")
	private String isbn;
	@NotNull(message="price cannot be null")
	private Float price;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate publishDate;
	@NotNull(message="bookCategory cannot be null")
	private String bookcategory;
	


	public BookDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookDTO(String bookId, String title, String author, String description, String isbn, Float price,
			LocalDate publishDate, String bookcategory) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.description = description;
		this.isbn = isbn;
		this.price = price;
		this.publishDate = publishDate;
		this.bookcategory = bookcategory;
	}


	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", description=" + description
				+ ", isbn=" + isbn + ", price=" + price + ", publishDate=" + publishDate + ", bookcategory=" + bookcategory + "]";
	}


	public String getBookId() {
		return bookId;
	}


	public void setBookId(String bookId) {
		this.bookId = bookId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public Float getPrice() {
		return price;
	}


	public void setPrice(Float price) {
		this.price = price;
	}


	public LocalDate getPublishDate() {
		return publishDate;
	}


	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public String getBookcategory() {
		return bookcategory;
	}


	public void setBookcategory(String bookcategory) {
		this.bookcategory = bookcategory;
	}

	

}
