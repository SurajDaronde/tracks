package com.tracks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tracks.entities.Contact;
import com.tracks.entities.Lead;
import com.tracks.services.ContactService;
import com.tracks.services.LeadService;

@Controller
public class ContactController {

	@Autowired
	private LeadService leadService;
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/convertLead")
	public String convertLead(@RequestParam("id") long id , ModelMap model) {
		Lead lead= leadService.findLeadById(id);
		
		Contact contact= new Contact();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setLeadSource(lead.getLeadSource());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		
		contactService.saveContact(contact);
		
		leadService.deleteLeadById(id);
		
		List<Contact> contacts = contactService.getAllContacts();
		model.addAttribute("contacts", contacts);
		return "contact_search_result";
	}
	
	@RequestMapping("/contactInfo")
	public String contactInfo(@RequestParam("id") long id, ModelMap model) {
		Contact contact = contactService.findcontactById(id);
		model.addAttribute("contact", contact);
		return "contact_info";
	}
	
	@RequestMapping("/listallcontacts")
	public String listAllContactss(ModelMap model) {
		List<Contact> contacts = contactService.getAllContacts();
		model.addAttribute("contacts", contacts);
		return "contact_search_result";
	}
}
