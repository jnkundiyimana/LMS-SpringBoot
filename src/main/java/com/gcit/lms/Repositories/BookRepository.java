/**
 * 
 */
package com.gcit.lms.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;

/**
 * @author jeanpaul.nkundiyimana
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query("from Book where title like %:title%")
	public List<Book> findByBookTitle(@Param("title") String title);
	
	@Query(value = "SELECT * FROM tbl_book WHERE bookId IN (SELECT bookId FROM tbl_book_authors WHERE authorId = ?)", nativeQuery = true)
	public List<Book> findByBookAuthor(Integer authorId);
	
	@Query(value = "SELECT * FROM tbl_book WHERE pubId =?", nativeQuery = true)
	public List<Book> findByBookPublisher(Integer pubId);
	
	@Query(value = "SELECT * FROM tbl_book WHERE bookId IN (SELECT bookId FROM tbl_book_copies WHERE tbl_book_copies.branchId = ?)", nativeQuery = true)
	public List<Book> findBooksByBranch(Integer branchId);
	
	
	@Query(value = "SELECT * FROM tbl_book WHERE bookId IN (SELECT bookId FROM tbl_book_copies WHERE branchId = ?1 AND noOfCopies >0)", nativeQuery = true)
	public List<Book> findAvailableBooksInBranch(Integer branchId);
	

	@Query(value = "SELECT * FROM tbl_book WHERE bookId IN (SELECT bookId FROM tbl_book_loans WHERE dateIn = NULL)", nativeQuery = true)
	public List<Book> findCheckedOutBooks();
	
	@Query(value = "SELECT * FROM tbl_book WHERE bookId IN (SELECT bookId FROM tbl_book_loans WHERE dateIn = NULL AND branchId =?)", nativeQuery = true)
	public List<Book> findCheckedOutBooksPerBranch(Integer branchId);
	
}
