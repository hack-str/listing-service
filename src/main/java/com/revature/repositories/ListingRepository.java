package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Listing;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Integer> {
	
	public List<Listing> findListingsByUserId(int id);

}
