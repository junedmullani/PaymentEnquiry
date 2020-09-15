package com.jd.PaymentEnquiryHistory.controller;

import java.util.List;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.LoggerFactory;
import com.jd.PaymentEnquiryHistory.DTO.PaymentEnquiryHistoryDTO;
import com.jd.PaymentEnquiryHistory.entity.DateSearch;
import com.jd.PaymentEnquiryHistory.entity.PaymentEnquiryHistory;
import com.jd.PaymentEnquiryHistory.exceptionhandle.DatanotfoundException;
import com.jd.PaymentEnquiryHistory.service.PaymentEnquiryHistoryService;

@RestController
@RequestMapping("/api")
public class PaymentEnquiryHistoryController {

	Logger logging=LoggerFactory.getLogger(PaymentEnquiryHistoryController.class);
	@Autowired
	PaymentEnquiryHistoryService pehService;
	
	@GetMapping("/paymentenquiryhistory")
	@ResponseBody
    public ResponseEntity<List<PaymentEnquiryHistoryDTO>> getAllUsersLocation() {
		logging.info("get all data of paymentenquiryhistory");
        List <PaymentEnquiryHistoryDTO> paymentData = pehService.paymentEnquiryHistorySearch();
        return new ResponseEntity<>(paymentData, HttpStatus.OK);
    }
	
	@PostMapping("/paymentenquiryhistory")
	@ResponseBody
	public ResponseEntity<PaymentEnquiryHistory> addData(@RequestBody PaymentEnquiryHistory user) {
		logging.info("adding data to paymentenquiryhistory");
		PaymentEnquiryHistory data= pehService.paymentEnquiryHistory(user);
		return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/paymentenquiryhistorysearch")
	public ResponseEntity<List<PaymentEnquiryHistoryDTO>> searchByDate(
	        @RequestBody DateSearch data){
		logging.info("get data within a specific date range from paymentenquiryhistory");
		
	    List<PaymentEnquiryHistoryDTO> searchdata=pehService.searchByDate(data.getFrom(),data.getTo());
	    return new ResponseEntity<>(searchdata, HttpStatus.OK);
	}
}
