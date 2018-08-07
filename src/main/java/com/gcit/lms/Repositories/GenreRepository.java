/**
 * 
 */
package com.gcit.lms.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gcit.lms.entity.Genre;

/**
 * @author jeanpaul.nkundiyimana
 *
 */

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {

	@Query("from Genre where genreName like %:genreName%")
	public List<Genre> findByGenreName(@Param("genreName") String genreName);
}
