/**
 * 
 */
package com.gcit.lms.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.gcit.lms.entity.Author;

/**
 * @author jeanpaul.nkundiyimana
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
	
	@Query("from Author where authorName like %:authorName%")
	public List<Author> findByAuthorName(@Param("authorName") String authorName);
	
}
