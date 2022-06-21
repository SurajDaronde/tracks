package com.tracks.services;

import java.util.List;

import com.tracks.entities.Contact;

public interface ContactService {

	public void saveContact(Contact contact);
	
	public List<Contact> getAllContacts();

	public Contact findcontactById(long id);
}
