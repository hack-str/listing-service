package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Listing;
import com.revature.services.ListingService;

@RestController
@RequestMapping("/listings")
public class ListingController {
	
	@Autowired	
	private ListingService listingService;
	
	@GetMapping
	public List<Listing> getAllListings(){
		return listingService.getAllListings();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Listing> getListingById(@PathVariable("id")int id){
		return  new ResponseEntity<Listing>(listingService.getListingById(id), HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<List<Listing>> getListingsByUserId(@PathVariable("id")int userId){
		return new ResponseEntity<List<Listing>>(listingService.getListingsByUserId(userId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Listing> addListing(@RequestBody Listing listing){
		return new ResponseEntity<Listing>(listing, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Listing> updateListing(@PathVariable("id")int id, @RequestBody Listing listing){
		listing.setId(id);
		return new ResponseEntity<Listing>(listing, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Listing> deleteListing(@RequestBody Listing listing){
		return new ResponseEntity<Listing>(listing, HttpStatus.OK);
	}
}
