/**
 * 
 */
package com.gcit.lms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author jeanpaul.nkundiyimana
 *
 */

@Entity
@Table(name="tbl_borrower", catalog="library")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="borrowerName", scope=Borrower.class)
public class Borrower {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cardNo;
	
	@NotNull
	@Length(max=45)
	@Column(name="name")
	private String borrowerName;
	
	@Length(max=45)
	@Column(name="address")
	private String borrowerAddress;
	
	@Length(max=45)
	@Column(name="phone")
	private String borrowerPhone;

	/**
	 * 
	 */
	public Borrower() {
		// TODO Auto-generated constructor stub
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

	/**
	 * @return the borrowerName
	 */
	public String getBorrowerName() {
		return borrowerName;
	}

	/**
	 * @param borrowerName the borrowerName to set
	 */
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	/**
	 * @return the borrowerAddress
	 */
	public String getBorrowerAddress() {
		return borrowerAddress;
	}

	/**
	 * @param borrowerAddress the borrowerAddress to set
	 */
	public void setBorrowerAddress(String borrowerAddress) {
		this.borrowerAddress = borrowerAddress;
	}

	/**
	 * @return the borrowerPhone
	 */
	public String getBorrowerPhone() {
		return borrowerPhone;
	}

	/**
	 * @param borrowerPhone the borrowerPhone to set
	 */
	public void setBorrowerPhone(String borrowerPhone) {
		this.borrowerPhone = borrowerPhone;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Borrower [cardNo=" + cardNo + ", borrowerName=" + borrowerName + ", borrowerAddress=" + borrowerAddress
				+ ", borrowerPhone=" + borrowerPhone + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((borrowerAddress == null) ? 0 : borrowerAddress.hashCode());
		result = prime * result + ((borrowerName == null) ? 0 : borrowerName.hashCode());
		result = prime * result + ((borrowerPhone == null) ? 0 : borrowerPhone.hashCode());
		result = prime * result + ((cardNo == null) ? 0 : cardNo.hashCode());
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
		Borrower other = (Borrower) obj;
		if (borrowerAddress == null) {
			if (other.borrowerAddress != null)
				return false;
		} else if (!borrowerAddress.equals(other.borrowerAddress))
			return false;
		if (borrowerName == null) {
			if (other.borrowerName != null)
				return false;
		} else if (!borrowerName.equals(other.borrowerName))
			return false;
		if (borrowerPhone == null) {
			if (other.borrowerPhone != null)
				return false;
		} else if (!borrowerPhone.equals(other.borrowerPhone))
			return false;
		if (cardNo == null) {
			if (other.cardNo != null)
				return false;
		} else if (!cardNo.equals(other.cardNo))
			return false;
		return true;
	}
	
	
	
	
	
}
