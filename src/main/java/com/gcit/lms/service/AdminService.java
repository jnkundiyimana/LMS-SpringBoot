/**
 * 
 */
package com.gcit.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
@CrossOrigin(origins = "http://localhost:4200")
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
	@ResponseBody
	@RequestMapping(value = "/admin/authors", method = RequestMethod.GET)
	public List<Author> readAuthors(){
		
		List<Author> authors = new ArrayList<>();
		authors= authorRepo.findAll();
		
		for(Author a: authors) {
			a.setBooks(bookRepo.findByBookAuthor(a.getAuthorId()));
		}
		return authors;
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/authors/{authorId}", method = RequestMethod.GET)
	public Optional<Author> readAuthorsByPK(@PathVariable("authorId") Integer authorId){
		return authorRepo.findById(authorId);	
	}
		
	@ResponseBody
	@RequestMapping(value = "/admin/authors/{authorName}", method = RequestMethod.GET)
	public List<Author> readAuthorsByName(@PathVariable("authorName") String authorName ){
		return authorRepo.findByAuthorName(authorName);	
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/deleteAuthor/{authorId}", method = RequestMethod.DELETE)
	public void delteAuthor(@PathVariable("authorId") Integer authorId){
		  authorRepo.deleteById(authorId);	
	}

	@ResponseBody
	@RequestMapping(value = "/admin/updateAuthor", method = RequestMethod.PUT)
	public void updateAuthor(@RequestBody Author author){
		 authorRepo.save(author);
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/addAuthor", method = RequestMethod.POST )
	public Author addAuthor(@RequestBody() Author author){
		 return authorRepo.save(author);
	}

	
	
	
	//Genre
	
	@RequestMapping(value = "/admin/genres", method = RequestMethod.GET)
	public List<Genre> readGenres(){
		return genreRepo.findAll();	
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/genres/{genreId}", method = RequestMethod.GET)
	public Optional<Genre> readGenresByPK(@PathVariable("genreId") Integer genreId){
		return genreRepo.findById(genreId);	
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/deleteGenre/{genreId}", method = RequestMethod.DELETE)
	public void deleteGenre(@PathVariable("genreId") Integer genreId){
		genreRepo.deleteById(genreId);	
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/updateGenre", method = RequestMethod.PUT)
	public void updateGenre(@RequestBody() Genre genre){
		genreRepo.save(genre);
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/addGenre", method = RequestMethod.POST )
	public void addGenre(@RequestBody()Genre genre){
		genreRepo.save(genre);
	}
	
	
	
	
	//Publisher
	
	@ResponseBody
	@RequestMapping(value = "/admin/publishers", method = RequestMethod.GET)
	public List<Publisher> readPublishers(){
		return publisherRepo.findAll();	
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/publishers/{publisherId}", method = RequestMethod.GET)
	public Optional<Publisher> readPublisherByPK(@PathVariable("publisherId") Integer publisherId){
		return publisherRepo.findById(publisherId);	
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/deletePublisher/{publisherId}", method = RequestMethod.DELETE)
	public void deletePublisher(@PathVariable("publisherId") Integer publisherId){
		publisherRepo.deleteById(publisherId);	
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/updatePublisher", method = RequestMethod.PUT)
	public void updatePublisher(@RequestBody() Publisher publisher){
		publisherRepo.save(publisher);
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/addPublisher", method = RequestMethod.POST )
	public void addGenre(@RequestBody()Publisher publisher){
		publisherRepo.save(publisher);
	}
	
	
	
	
	
	//Borrower
	
	@ResponseBody
	@RequestMapping(value = "/admin/borrowers", method = RequestMethod.GET)
	public List<Borrower> readBorrowers(){
		return borrowerRepo.findAll();	
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/borrowers/{cardNo}", method = RequestMethod.GET)
	public Optional<Borrower> readBorrowersByPK(@PathVariable("cardNo") Integer cardNo){
		return borrowerRepo.findById(cardNo);	
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/deleteBorrower/{cardNo}", method = RequestMethod.DELETE)
	public void deleteBorrower(@PathVariable("cardNo") Integer cardNo){
		borrowerRepo.deleteById(cardNo);	
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateBorrower", method = RequestMethod.PUT)
	public void updateBorrower(@RequestBody Borrower borrower){
		borrowerRepo.save(borrower);	
	}
	
	@ResponseBody
	@RequestMapping(value = "/addBorrower", method = RequestMethod.POST)
	public void addBorrower(@RequestBody Borrower borrower){
		borrowerRepo.save(borrower);	
	}
	
	
	
	//Branches
	@ResponseBody
	@RequestMapping(value = "/admin/branches", method = RequestMethod.GET)
	public List<LibraryBranch> readBranchess(){
		return branchRepo.findAll();	
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/branch/{branchId}", method = RequestMethod.GET)
	public Optional<LibraryBranch> readBranchesByPK(@PathVariable("branchId") Integer branchId){
		return branchRepo.findById(branchId);	
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/deleteBranch/{branchId}", method = RequestMethod.DELETE)
	public void deleteBranch(@PathVariable("branchId") Integer branchId){
		 branchRepo.deleteById(branchId);	
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/updateBranch", method = RequestMethod.PUT)
	public void updateBranch(@RequestBody LibraryBranch branch){
		branchRepo.save(branch);	
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/addBranch", method = RequestMethod.POST)
	public void addBranch(@RequestBody LibraryBranch branch){
		branchRepo.save(branch);	
	}
	
	
	
	
	//Books
	
	@ResponseBody
	@RequestMapping(value = "/admin/books", method = RequestMethod.GET)
	public List<Book> readBooks(){
		return bookRepo.findAll();	
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/checkedOutbooks", method = RequestMethod.GET)
	public List<Book> readCcheckedOutBooks(){
		return bookRepo.findCheckedOutBooks();	
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/booksByAuthor/{authorId}", method = RequestMethod.GET)
	public List<Book> readBooksByAuthor(@PathVariable Integer authorId){
		return bookRepo.findByBookAuthor(authorId);	
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/bookByPublisher/{pubId}", method = RequestMethod.GET)
	public List<Book> readBookByPublisher(@PathVariable("pubId") Integer pubId){
		return bookRepo.findByBookPublisher(pubId);
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/readBooksByBranch/{branchId}", method = RequestMethod.GET)
	public List<Book> readBookByBranch(@PathVariable Integer branchbId){
		return bookRepo.findByBookPublisher(branchbId);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/admin/addBook", method = RequestMethod.POST)
	public void addBook(@RequestBody Book book){
		bookRepo.save(book);	
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/deleteBook/{bookId}", method = RequestMethod.DELETE)
	public void deleteBook(@PathVariable("bookId") Integer bookId){
		 bookRepo.deleteById(bookId);	
	}
	
	@Transactional
	@RequestMapping(value = "/admin/updateBook", method = RequestMethod.PUT)
	public void updateBook(@RequestBody Book book){
		bookRepo.save(book);	
	}
	
	
	
	
	
}
