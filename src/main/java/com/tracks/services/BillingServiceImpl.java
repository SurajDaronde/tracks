package com.tracks.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracks.entities.Billing;
import com.tracks.repositories.BillingRepository;

@Service
public class BillingServiceImpl implements BillingService {

	@Autowired
	private BillingRepository billingRepo;
	
	@Override
	public void saveBill(Billing bill) {
		billingRepo.save(bill);
	}

}
