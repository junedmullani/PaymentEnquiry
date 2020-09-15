package com.jd.PaymentEnquiryHistory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jd.PaymentEnquiryHistory.entity.PaymentEnquiryHistory;

@Repository
public interface PaymentEnquiryHistoryRepo extends JpaRepository<PaymentEnquiryHistory, Integer> {

}
