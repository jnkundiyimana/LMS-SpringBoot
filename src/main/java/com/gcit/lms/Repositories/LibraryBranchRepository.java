package com.gcit.lms.Repositories;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gcit.lms.entity.LibraryBranch;

@Repository
public interface LibraryBranchRepository extends JpaRepository<LibraryBranch, Integer> {

	@Query("from LibraryBranch where branchName like %:branchName%")
	public List<LibraryBranch> findByBranchName(@Param("branchName") String branchName);
	
	@Query("from LibraryBranch where branchAddres like %:branchAddres%")
	public List<LibraryBranch> findByBranchAddress(@Param("branchAddres") String branchAddres);
	
	@Modifying
	@Query(value = "UPDATE tbl_book_copies SET  tbl_book_copies.noOfCopies  = (tbl_book_copies.noOfCopies + ?1) WHERE tbl_book_copies.bookId = ?2 AND tbl_book_copies.branchId = ?3", nativeQuery = true)
	public void addBookCopiesInBranch(Integer noOfCopies, Integer bookId, Integer branchId );
	

	
	@Modifying
	@Query(value = "INSERT INTO tbl_book_loans (bookId, branchId, cardNo, dateOut, dueDate, dateIn) VALUES (?,?,?,?,?,NULL) ", nativeQuery = true)
	public void checkOutBook(Integer bookId, Integer branchId,  Integer cardNo, Timestamp dateOut, Timestamp dueDate);
	
	@Modifying
	@Query(value = "UPDATE tbl_book_copies SET  noOfCopies  = (noOfCopies - 1) WHERE bookId = ?1 AND branchId = ?2", nativeQuery = true)
	public void removeBookCopiesInBranch(Integer bookId, Integer branchId);
	
	@Modifying
	@Query(value = "UPDATE tbl_book_loans SET  dateIn = ?1 WHERE  bookId = ?2 AND  branchId = ?3 AND cardNo = ?4 ", nativeQuery = true)
	public void returnBook(Timestamp dateIn, Integer bookId, Integer branchId,  Integer cardNo);
	
	@Modifying
	@Query(value = "UPDATE tbl_book_copies SET noOfCopies = (noOfCopies + 1) WHERE bookId = ?1 AND branchId = ?2", nativeQuery = true)
	public void addReturnedBookCopy(Integer bookId, Integer branchId);
		
}
