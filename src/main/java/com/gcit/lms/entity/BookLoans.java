/**
 * 
 */
package com.gcit.lms.entity;



/**
 * @author jeanpaul.nkundiyimana
 *
 */

public class BookLoans {


	private Integer bookId;
	private Integer branchId;
	private Integer cardNo;
	
	
	
	/**
	 * 
	 */
	public BookLoans() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the bookId
	 */
	public Integer getBookId() {
		return bookId;
	}
	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	/**
	 * @return the branchId
	 */
	public Integer getBranchId() {
		return branchId;
	}
	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	/**
	 * @return the cardNo
	 */
	public Integer getCardNo() {
		return cardNo;
	}
	/**
	 * @param cardNo the cardNo to set
	 */
	public void setCardNo(Integer cardNo) {
		this.cardNo = cardNo;
	}
	
	
	
}
