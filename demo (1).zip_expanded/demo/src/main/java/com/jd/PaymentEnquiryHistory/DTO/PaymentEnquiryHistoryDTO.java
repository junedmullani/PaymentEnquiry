package com.jd.PaymentEnquiryHistory.DTO;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class PaymentEnquiryHistoryDTO {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	int transactionNo;
	long amount;
	String currency;
	String instructedDate;
	
	public String getInstructedDate() {
		return instructedDate;
	}

	public void setInstructedDate(String instructedDate) {
		this.instructedDate = instructedDate;
	}

	public String setDateFormat(Date date) {
		String format = formatter.format(date);
		//Date date1 = formatter.StringToDate(format);
		  //  System.out.println(format);
		
		
		return format;
	}

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



}
