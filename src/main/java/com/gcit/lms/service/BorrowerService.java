/**
 * 
 */
package com.gcit.lms.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.lms.Repositories.AuthorRepository;
import com.gcit.lms.Repositories.BookRepository;
import com.gcit.lms.Repositories.BorrowerRepository;
import com.gcit.lms.Repositories.GenreRepository;
import com.gcit.lms.Repositories.LibraryBranchRepository;
import com.gcit.lms.Repositories.PublisherRepository;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.BookLoans;
import com.gcit.lms.entity.Borrower;
import com.gcit.lms.entity.LibraryBranch;

/**
 * @author jeanpaul.nkundiyimana
 *
 */
@RestController
public class BorrowerService {

	
	@Autowired
	AuthorRepository authorRepo;
	
	@Autowired
	PublisherRepository publisherRepo;
	
	@Autowired
	GenreRepository genreRepo;
	
	@Autowired
	BorrowerRepository borrowerRepo;
	
	@Autowired
	LibraryBranchRepository branchRepo;
	
	@Autowired
	BookRepository bookRepo;
	
	@Temporal(TemporalType.TIMESTAMP)
	Timestamp dateOut;
	
	@Temporal(TemporalType.TIMESTAMP)
	Timestamp dueDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	Timestamp dateIn;
	
	
	@RequestMapping(value = "/readBorrowers", method = RequestMethod.GET, produces = "application/json")
	public List<Borrower> readBorrowers(){
		return borrowerRepo.findAll();	
	}
	
	@RequestMapping(value = "/readBranches", method = RequestMethod.GET, produces = "application/json")
	public List<LibraryBranch> readBranchess(){
		return branchRepo.findAll();	
	}
	
	@RequestMapping(value = "/availableBooks/{branchId}", method = RequestMethod.GET, produces = "application/json")
	public List<Book> availableBooksInBranch(@PathVariable Integer branchId){
		return bookRepo.findAvailableBooksInBranch(branchId);
	}
	@Transactional
	@RequestMapping(value = "/checkOut", method = RequestMethod.POST, produces = "application/json")
	public void checkOutBook(@RequestBody BookLoans bookLoans){		
		
		dateOut = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC")));
		dueDate = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC")).plusWeeks(1));		
		
		branchRepo.checkOutBook(bookLoans.getBookId(), bookLoans.getBranchId(), bookLoans.getCardNo(), dateOut,  dueDate);
		branchRepo.removeBookCopiesInBranch(bookLoans.getBookId(), bookLoans.getBranchId());
		
	}
	
	@Transactional
	@RequestMapping(value = "/returnBook", method = RequestMethod.POST, produces = "application/json")
	public void returnBook(@RequestBody BookLoans bookLoans){
		
		dateIn = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC")));
		
		 branchRepo.returnBook(dateIn, bookLoans.getBookId(), bookLoans.getBranchId(), bookLoans.getCardNo());
		 branchRepo.addReturnedBookCopy(bookLoans.getBookId(), bookLoans.getBranchId());
	}
	
	
}
