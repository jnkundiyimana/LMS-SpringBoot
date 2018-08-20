/**
 * 
 */
package com.gcit.lms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.lms.Repositories.BookRepository;
import com.gcit.lms.Repositories.LibraryBranchRepository;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.BookCopies;
import com.gcit.lms.entity.LibraryBranch;

/**
 * @author jeanpaul.nkundiyimana
 *
 */
@RestController
public class LibrarianService {

	@Autowired
	AdminService adminService;
	
	@Autowired
	LibraryBranchRepository branchRepo;
	
	@Autowired
	BookRepository bookRepo;
	
	
	//Branches
		
		@RequestMapping(value = "/librarian/branches", method = RequestMethod.GET)
		public List<LibraryBranch> readBranches(){
			return branchRepo.findAll();	
		}
		
		@RequestMapping(value = "/librarian/branches/{branchId}", method = RequestMethod.GET)
		public Optional<LibraryBranch> readBranchesByPK(@PathVariable("branchId") Integer branchId){
			return adminService.readBranchesByPK(branchId);	
		}
	
	@RequestMapping(value = "/librarian/updateBranch", method = RequestMethod.PUT)
	public void updateBranch(@RequestBody LibraryBranch branch){
		adminService.updateBranch(branch);
	}
	
	
	@RequestMapping(value = "/librarian/books", method = RequestMethod.GET)
	public List<Book> readBooks(){
		return bookRepo.findAll();	
	}
	
	@RequestMapping(value = "/librarian/books/{branchId}", method = RequestMethod.GET)
	public List<Book> readBookByBranch(@PathVariable Integer branchId){
		return bookRepo.findBooksByBranch(branchId);
	}
	
	@Transactional
	@RequestMapping(value = "/librarian/addBookCopies", method = RequestMethod.POST )
	public void addBookCopies(@RequestBody() BookCopies bookCopies){
		 branchRepo.addBookCopiesInBranch(bookCopies.getNoOfCopies(), bookCopies.getBookId(), bookCopies.getBranchId());
	}
	
	@RequestMapping(value = "/checkedOutbooksPerBranch/{branchId}", method = RequestMethod.GET)
	public List<Book> readCcheckedOutBooks(@RequestParam Integer branchId){
		return bookRepo.findCheckedOutBooksPerBranch(branchId);	
	}
	
	
	
}
