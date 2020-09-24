package com.cg.bookmanagement.repository;



import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bookmanagement.dto.BookDTO;
@Repository
public interface BookRepository extends CrudRepository<BookDTO, String> {

	@Modifying
	@Query("UPDATE BookDTO bok SET bok.title=:title,bok.price=:price WHERE bok.bookId=:bookId")
	@Transactional
	void updateInBook(String bookId, String title,Float price);

	


}