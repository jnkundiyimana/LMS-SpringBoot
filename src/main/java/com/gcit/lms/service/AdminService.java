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

import com.gcit.lms.Repositories.AuthorRepository;
import com.gcit.lms.Repositories.BookRepository;
import com.gcit.lms.Repositories.BorrowerRepository;
import com.gcit.lms.Repositories.GenreRepository;
import com.gcit.lms.Repositories.LibraryBranchRepository;
import com.gcit.lms.Repositories.PublisherRepository;
import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.Borrower;
import com.gcit.lms.entity.Genre;
import com.gcit.lms.entity.LibraryBranch;
import com.gcit.lms.entity.Publisher;


/**
 * @author jeanpaul.nkundiyimana
 *
 */
@RestController
public class AdminService {

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
	
	
	//Author
	
	@RequestMapping(value = "/readAuthors", method = RequestMethod.GET, produces = "application/json")
	public List<Author> readAuthors(){
		return authorRepo.findAll();	
	}
	
	@RequestMapping(value = "/readAuthorsByPK", method = RequestMethod.GET, produces = "application/json")
	public Optional<Author> readAuthorsByPK(@RequestParam("authorId") Integer authorId){
		return authorRepo.findById(authorId);	
	}
		
	@RequestMapping(value = "/readAuthorsByName", method = RequestMethod.GET, produces = "application/json")
	public List<Author> readAuthorsByName(@RequestParam("authorName") String authorName ){
		return authorRepo.findByAuthorName(authorName);	
	}
	
	@RequestMapping(value = "/deleteAuthor", method = RequestMethod.DELETE, produces = "application/json")
	public void delteAuthor(@RequestParam("authorId") Integer authorId){
		  authorRepo.deleteById(authorId);	
	}

	@RequestMapping(value = "/updateAuthor", method = RequestMethod.PUT, produces = "application/json")
	public void updateAuthor(@RequestBody Author author){
		 authorRepo.save(author);
	}
	
	@RequestMapping(value = "/addAuthor", method = RequestMethod.POST )
	public Author addAuthor(@RequestBody() Author author){
		 return authorRepo.save(author);
	}

	
	
	
	//Genre
	
	@RequestMapping(value = "/readGenres", method = RequestMethod.GET, produces = "application/json")
	public List<Genre> readGenres(){
		return genreRepo.findAll();	
	}
	
	@RequestMapping(value = "/readGenresByPK", method = RequestMethod.GET, produces = "application/json")
	public Optional<Genre> readGenresByPK(@RequestParam("genreId") Integer genreId){
		return genreRepo.findById(genreId);	
	}
	
	@RequestMapping(value = "/deleteGenre", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteGenre(@RequestParam("genreId") Integer genreId){
		genreRepo.deleteById(genreId);	
	}
	
	@RequestMapping(value = "/updateGenre", method = RequestMethod.PUT, produces = "application/json")
	public void updateGenre(@RequestBody() Genre genre){
		genreRepo.save(genre);
	}
	
	@RequestMapping(value = "/addGenre", method = RequestMethod.POST )
	public void addGenre(@RequestBody()Genre genre){
		genreRepo.save(genre);
	}
	
	
	
	
	//Publisher
	
	@RequestMapping(value = "/readPublishers", method = RequestMethod.GET, produces = "application/json")
	public List<Publisher> readPublishers(){
		return publisherRepo.findAll();	
	}
	
	@RequestMapping(value = "/readPublisherByPK", method = RequestMethod.GET, produces = "application/json")
	public Optional<Publisher> readPublisherByPK(@RequestParam("publisherId") Integer publisherId){
		return publisherRepo.findById(publisherId);	
	}
	
	@RequestMapping(value = "/deletePublisher", method = RequestMethod.DELETE, produces = "application/json")
	public void deletePublisher(@RequestParam("publisherId") Integer publisherId){
		publisherRepo.deleteById(publisherId);	
	}
	
	@RequestMapping(value = "/updatePublisher", method = RequestMethod.PUT, produces = "application/json")
	public void updatePublisher(@RequestBody() Publisher publisher){
		publisherRepo.save(publisher);
	}
	
	@RequestMapping(value = "/addPublisher", method = RequestMethod.POST )
	public void addGenre(@RequestBody()Publisher publisher){
		publisherRepo.save(publisher);
	}
	
	
	
	
	
	//Borrower
	
	@RequestMapping(value = "/borrowers", method = RequestMethod.GET, produces = "application/json")
	public List<Borrower> readBorrowers(){
		return borrowerRepo.findAll();	
	}
	
	@RequestMapping(value = "/readBorrowersByPK", method = RequestMethod.GET, produces = "application/json")
	public Optional<Borrower> readBorrowersByPK(@RequestParam("cardNo") Integer cardNo){
		return borrowerRepo.findById(cardNo);	
	}
	
	@RequestMapping(value = "/deleteBorrower", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteBorrower(@RequestParam("cardNo") Integer cardNo){
		borrowerRepo.deleteById(cardNo);	
	}
	
	@RequestMapping(value = "/updateBorrower", method = RequestMethod.PUT, produces = "application/json")
	public void updateBorrower(@RequestBody Borrower borrower){
		borrowerRepo.save(borrower);	
	}
	
	@RequestMapping(value = "/addBorrower", method = RequestMethod.POST, produces = "application/json")
	public void addBorrower(@RequestBody Borrower borrower){
		borrowerRepo.save(borrower);	
	}
	
	
	
	//Branches
	
	@RequestMapping(value = "/readAllbranches", method = RequestMethod.GET, produces = "application/json")
	public List<LibraryBranch> readBranchess(){
		return branchRepo.findAll();	
	}
	
	@RequestMapping(value = "/readBranchByPK", method = RequestMethod.GET, produces = "application/json")
	public Optional<LibraryBranch> readBranchesByPK(@RequestParam("branchId") Integer branchId){
		return branchRepo.findById(branchId);	
	}
	
	@RequestMapping(value = "/deleteBranch", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteBranch(@RequestParam("branchId") Integer branchId){
		 branchRepo.deleteById(branchId);	
	}
	
	@RequestMapping(value = "/updateBranch", method = RequestMethod.PUT, produces = "application/json")
	public void updateBranch(@RequestBody LibraryBranch branch){
		branchRepo.save(branch);	
	}
	
	
	@RequestMapping(value = "/addBranch", method = RequestMethod.POST, produces = "application/json")
	public void addBranch(@RequestBody LibraryBranch branch){
		branchRepo.save(branch);	
	}
	
	
	
	
	//Books
	
	@RequestMapping(value = "/books", method = RequestMethod.GET, produces = "application/json")
	public List<Book> readBooks(){
		return bookRepo.findAll();	
	}
	
	@RequestMapping(value = "/checkedOutbooks", method = RequestMethod.GET, produces = "application/json")
	public List<Book> readCcheckedOutBooks(){
		return bookRepo.findCheckedOutBooks();	
	}
	
	@RequestMapping(value = "/readBooks/author/{authorId}", method = RequestMethod.GET, produces = "application/json")
	public List<Book> readBooksByAuthor(@PathVariable Integer authorId){
		return bookRepo.findByBookAuthor(authorId);	
	}
	
	@RequestMapping(value = "/readBookByPublisher", method = RequestMethod.GET, produces = "application/json")
	public List<Book> readBookByPublisher(@RequestParam() Integer pubId){
		return bookRepo.findByBookPublisher(pubId);
	}
	
	
	@RequestMapping(value = "/addBook", method = RequestMethod.POST, produces = "application/json")
	public void addBook(@RequestBody Book book){
		bookRepo.save(book);	
	}
	
	
	@RequestMapping(value = "/deleteBook", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteBook(@RequestParam("bookId") Integer bookId){
		 bookRepo.deleteById(bookId);	
	}
	
	@Transactional
	@RequestMapping(value = "/updateBook", method = RequestMethod.PUT, produces = "application/json")
	public void updateBook(@RequestBody Book book){
		bookRepo.save(book);	
	}
	
	
	
	
	
}
