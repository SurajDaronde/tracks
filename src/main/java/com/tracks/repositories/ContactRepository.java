package com.tracks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tracks.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}
