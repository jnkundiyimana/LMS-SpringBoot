/**
 * 
 */
package com.gcit.lms.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gcit.lms.entity.Publisher;

/**
 * @author jeanpaul.nkundiyimana
 *
 */
@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
	
	@Query("from Publisher where publisherName like %:publisherName%")
	public List<Publisher> findByPublisherName(@Param("publisherName") String publisherName);

}
