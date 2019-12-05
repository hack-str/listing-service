package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Listing;
import com.revature.repositories.ListingRepository;

@Service
public class ListingService {
	
	@Autowired
	private ListingRepository listingRepo;
	
	public List<Listing> getAllListings(){
		return listingRepo.findAll();
	}

	public Listing getListingById(int id) {
		return listingRepo.findOne(id);
	}

	public List<Listing> getListingsByUserId(int userId){
		return listingRepo.findListingsByUserId(userId);
	}
	
	public Listing addListing(Listing listing) {
		return listingRepo.save(listing);
	}
	
	public Listing updateListing(Listing listing) {
		return listingRepo.save(listing);
	}
	
	public void deleteListing(Listing listing) {
		listingRepo.delete(listing);
	}
}
