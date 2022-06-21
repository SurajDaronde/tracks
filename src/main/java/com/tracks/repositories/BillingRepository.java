package com.tracks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tracks.entities.Billing;

public interface BillingRepository extends JpaRepository<Billing, Long> {

}
