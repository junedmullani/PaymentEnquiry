package com.jd.PaymentEnquiryHistory.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PaymentEnquiryHistory {

	//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	@Id
	int transactionNo;
	long amount;
	String currency;
	Date instructedDate;
	
	
	/*public String setDateFormat(Date date) {
		String format = formatter.format(date);
		return format;
	}*/

	public int getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(int transactionNo) {
		this.transactionNo = transactionNo;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getInstructedDate() {
		return instructedDate;
	}

	public void setInstructedDate(Date instructedDate) {
		this.instructedDate = instructedDate;
	}


	
}
