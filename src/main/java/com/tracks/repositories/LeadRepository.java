package com.tracks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tracks.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
