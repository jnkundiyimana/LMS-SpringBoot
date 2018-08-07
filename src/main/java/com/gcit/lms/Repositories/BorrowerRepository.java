/**
 * 
 */
package com.gcit.lms.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gcit.lms.entity.Borrower;

/**
 * @author jeanpaul.nkundiyimana
 *
 */
@Repository
public interface BorrowerRepository extends JpaRepository <Borrower, Integer> {

	@Query("from Borrower where borrowerName like %:borrowerName%")
	public List<Borrower> findByBorrowerName(@Param("borrowerName") String borrowerName);
	
	
}
