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
		
		@RequestMapping(value = "/allBranches", method = RequestMethod.GET, produces = "application/json")
		public List<LibraryBranch> readBranches(){
			return branchRepo.findAll();	
		}
		
		@RequestMapping(value = "/librarian/readBranchByPK", method = RequestMethod.GET, produces = "application/json")
		public Optional<LibraryBranch> readBranchesByPK(@RequestParam("branchId") Integer branchId){
			return adminService.readBranchesByPK(branchId);	
		}
	
	@RequestMapping(value = "/librarian/updateBranch", method = RequestMethod.PUT, produces = "application/json")
	public void updateBranch(@RequestBody LibraryBranch branch){
		adminService.updateBranch(branch);
	}
	
	
	@RequestMapping(value = "/readBooks", method = RequestMethod.GET, produces = "application/json")
	public List<Book> readBooks(){
		return bookRepo.findAll();	
	}
	
	@RequestMapping(value = "/readBooks/{branchId}", method = RequestMethod.GET, produces = "application/json")
	public List<Book> readBookByBranch(@PathVariable Integer branchId){
		return bookRepo.findBooksByBranch(branchId);
	}
	
	@Transactional
	@RequestMapping(value = "/addBookCopies", method = RequestMethod.POST )
	public void addBookCopies(@RequestBody() BookCopies bookCopies){
		 branchRepo.addBookCopiesInBranch(bookCopies.getNoOfCopies(), bookCopies.getBookId(), bookCopies.getBranchId());
	}
	
	@RequestMapping(value = "/checkedOutbooksPerBranch/{branchId}", method = RequestMethod.GET, produces = "application/json")
	public List<Book> readCcheckedOutBooks(@RequestParam Integer branchId){
		return bookRepo.findCheckedOutBooksPerBranch(branchId);	
	}
	
	
	
}
