 /**
 * 
 */
package com.gcit.lms.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * @author jeanpaul.nkundiyimana
 *
 */
@Entity
@Table(name="tbl_book", catalog = "library")
public class Book {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer bookId;
	
	@NotNull
	@Length(max=45)
	@Column(name="title")
	private String title;
	
	@ManyToOne
	@JoinColumn(name="pubId")
	private Publisher publisher;
	
	@ManyToMany
	@JoinTable(name = "tbl_book_authors", joinColumns = { @JoinColumn(name = "bookId") }, inverseJoinColumns = { @JoinColumn(name = "authorId") })
	private List <Author> authors;
	
	@ManyToMany
	@JoinTable(name = "tbl_book_genres", joinColumns = { @JoinColumn(name = "bookId") }, inverseJoinColumns = { @JoinColumn(name = "genre_id")  })
	private List <Genre> genres;
	
	

	/**
	 * 
	 */
	public Book() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * 
	 * @param title
	 * @param publisher
	 */
	public Book(String title, Publisher publisher) {
		this.title = title;
		this.publisher = publisher;

	}

	
	
	/**
	 * @param bookId
	 * @param title
	 * @param publisher
	 * @param authors
	 * @param genres
	 */
	public Book(Integer bookId, @NotNull @Length(max = 45) String title, Publisher publisher, List<Author> authors,
			List<Genre> genres) {
		this.bookId = bookId;
		this.title = title;
		this.publisher = publisher;
		this.authors = authors;
		this.genres = genres;
	}




	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the publisher
	 */
	public Publisher getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(Publisher publishers) {
		this.publisher = publishers;
	}

	/**
	 * @return the authors
	 */
	public List<Author> getAuthors() {
		return authors;
	}

	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	/**
	 * @return the genres
	 */
	public List<Genre> getGenres() {
		return genres;
	}

	/**
	 * @param genres the genres to set
	 */
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	/**
	 * @return the bookId
	 */
	public Integer getBookId() {
		return bookId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {											// in front of publisher		
		return "Book [bookId=" + bookId + ", title=" + title + ", publisher=" + ", authors=" + authors
				+ ", genres=" + genres + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((genres == null) ? 0 : genres.hashCode());
		//result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (genres == null) {
			if (other.genres != null)
				return false;
		} else if (!genres.equals(other.genres))
			return false;
//		if (publisher == null) {
//			if (other.publisher != null)
//				return false;
//		} else if (!publisher.equals(other.publisher))
//			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	
	
	
	
	
}
