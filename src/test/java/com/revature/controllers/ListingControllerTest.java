package com.revature.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.revature.Application;
import com.revature.model.Listing;
import com.revature.services.ListingService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
@AutoConfigureMockMvc
public class ListingControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Mock
	private ListingService listingService;
	
	@Autowired
	@InjectMocks
	private ListingController listingController;
	
	@Before
	public void setup() {
		// build mock MVC so can build mock requests
		listingController = new ListingController();
		mvc = MockMvcBuilders.standaloneSetup(listingController).build();
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void testGetAll() throws Exception {
		when(listingService.getAllListings()).thenReturn(Arrays.asList(new Listing(), new Listing()));
		this.mvc.perform(get("/listing")).andExpect(status().isOk());
	}

}
