package com.tracks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracks.entities.Contact;
import com.tracks.repositories.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;
	
	@Override
	public void saveContact(Contact contact) {
      contactRepo.save(contact);
	}

	@Override
	public List<Contact> getAllContacts() {
      List<Contact> contacts = contactRepo.findAll();
		return contacts;
	}

	@Override
	public Contact findcontactById(long id) {
        Optional<Contact> findById = contactRepo.findById(id);
		Contact contact = findById.get();
        return contact;
	}

}
