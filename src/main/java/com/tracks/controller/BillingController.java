package com.tracks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tracks.entities.Billing;
import com.tracks.entities.Contact;
import com.tracks.services.BillingService;
import com.tracks.services.ContactService;

@Controller
public class BillingController {
	
	@Autowired
	private ContactService contactservice;
	
	@Autowired
	private BillingService billingService;

	@RequestMapping("/createBill")
	public String CreateBill(@RequestParam("bid") long id, ModelMap model) {
		Contact contact = contactservice.findcontactById(id);
	    model.addAttribute("contact", contact);
	    return "create_bill";
	}
	
	@RequestMapping("/saveBill")
	public String saveBill(@ModelAttribute("bill") Billing bill) {
		billingService.saveBill(bill);
		return "";
	}
}
