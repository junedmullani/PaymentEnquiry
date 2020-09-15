package com.jd.PaymentEnquiryHistory.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jd.PaymentEnquiryHistory.DTO.PaymentEnquiryHistoryDTO;
import com.jd.PaymentEnquiryHistory.Repository.PaymentEnquiryHistoryRepo;

import com.jd.PaymentEnquiryHistory.entity.PaymentEnquiryHistory;
import com.jd.PaymentEnquiryHistory.exceptionhandle.DatanotfoundException;
import com.jd.PaymentEnquiryHistory.exceptionhandle.NullDataException;

@Service
public class PaymentEnquiryHistoryService {

	@Autowired
	PaymentEnquiryHistoryRepo pehRepo;
	
	 public List<PaymentEnquiryHistoryDTO> paymentEnquiryHistorySearch() {
	        return ((List<PaymentEnquiryHistory>) pehRepo
	                .findAll())
	                .stream()
	                .map(this::convertToPaymentEnquiryHistoryDTO)
					        .collect(Collectors.toList());
	    }
	 
	 public PaymentEnquiryHistory paymentEnquiryHistory(PaymentEnquiryHistory user) {
	        return  pehRepo.save(user);
	             
	                
	    }
	 
	 
	
	public List<PaymentEnquiryHistoryDTO> searchByDate(String dateBeforeString, String dateAfterString) {
		// TODO Auto-generated method stub
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		if(dateBeforeString.equalsIgnoreCase("") || dateAfterString.equalsIgnoreCase("")) {
			throw new NullDataException();
		}
		Date date1 = null;
		Date date2=null;
		try {

		    date1 = format1.parse(dateBeforeString);
		    date2 = format1.parse(dateAfterString);

		} catch (Exception e1) {

		    // TODO Auto-generated catch block

		    throw new NullDataException();

		}
		if(date1.after(new Date()) || date2.after(new Date()))
		{
			throw new DatanotfoundException();
		}
		
		List<PaymentEnquiryHistory> allData=pehRepo.findAll();
		List<PaymentEnquiryHistory> searchedData=new ArrayList<PaymentEnquiryHistory>();;
		for(int i=0;i<allData.size();i++)
		{
			if((allData.get(i).getInstructedDate().before(date2)) && (allData.get(i).getInstructedDate().after(date1)))
			{
				searchedData.add(allData.get(i));
			}
		}
		
		//return mouvementsRepository.getMouvementsByDate(dateBefore, dateAfter, new PageRequest(page, size));
		return searchedData.stream().map(this::convertToPaymentEnquiryHistoryDTO).collect(Collectors.toList());
	}
	
	
	private PaymentEnquiryHistoryDTO convertToPaymentEnquiryHistoryDTO(PaymentEnquiryHistory user) {
		PaymentEnquiryHistoryDTO userPaymentEnquiryHistoryDTO = new PaymentEnquiryHistoryDTO();
		userPaymentEnquiryHistoryDTO.setTransactionNo(user.getTransactionNo());
		userPaymentEnquiryHistoryDTO.setAmount(user.getAmount());
		userPaymentEnquiryHistoryDTO.setCurrency(user.getCurrency());
		userPaymentEnquiryHistoryDTO.setInstructedDate(userPaymentEnquiryHistoryDTO.setDateFormat(user.getInstructedDate()));
        return userPaymentEnquiryHistoryDTO;
}

}
