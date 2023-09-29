package com.eazybytes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eazybytes.Entity.Cards;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Integer> {
	List<Cards> findByCustomerId(int customerId);
}
